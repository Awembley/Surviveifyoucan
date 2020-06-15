package Oyun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import Oyun.Oyun.STATE;

public class Menu extends MouseAdapter {
	
	Random r = new Random();
	private Oyun oyun;
	private Kontrol kontrol;
	private GöstergeEkran gösterge;
	
	
	public Menu(Oyun oyun,Kontrol kontrol,GöstergeEkran gösterge) {
		this.oyun = oyun;
		this.kontrol = kontrol;
		this.gösterge = gösterge;
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if(oyun.gameState == STATE.Menu) {

			
			if(mouseOver(mx, my, 310, 90, 200, 64)) { //Oyna butonu 
				oyun.gameState = STATE.Game;          
				kontrol.objeEkle(new Oyuncu(Oyun.GENISLIK/2-32,Oyun.YUKSEKLIK/2-32,ID.Player,kontrol));
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman, kontrol));
			}
			if(mouseOver(mx,my,310,190,200,64)) { //Yardým butonu
				oyun.gameState = STATE.Yardým;
			}
			
			if(mouseOver(mx,my,310,290,200,64)) { //Çýkýþ butonu
				System.exit(1);
			}
		}
		
		if(oyun.gameState == STATE.Bitiþ ||  oyun.gameState == STATE.Kazan) {
			if(mouseOver(mx, my, 410, 390, 200, 64)) { //Yeniden dene butonu
				kontrol.DüþmanlarýSil();
				oyun.gameState = STATE.Game;
				kontrol.objeEkle(new Oyuncu(Oyun.GENISLIK/2-32,Oyun.YUKSEKLIK/2-32,ID.Player,kontrol));
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman, kontrol));
				gösterge.setLevel(1);
				gösterge.setSkor(0);
			}
			}
		if(oyun.gameState == STATE.Bitiþ ||  oyun.gameState == STATE.Kazan) {
			if(mouseOver(mx, my, 100, 390, 200, 64)) {  //Çýkýþ tuþu
				kontrol.DüþmanlarýSil();
				gösterge.setLevel(1);
				gösterge.setSkor(0);
				oyun.gameState = STATE.Menu;
			}
		}
		
		
		//Menünün dýþýna taþýdýk çünkü yardýmýn içerisindeyken menü komutlarýný kullanabiliyorduk.
		if(oyun.gameState == STATE.Yardým) {
			if(mouseOver(mx,my,300,370,200,64)) { //Geri butonu
				oyun.gameState = STATE.Menu;
				return;
		}
	
		}
	}
	
	public void mouseRelease(MouseEvent e) {
		
		
	}
	
	private boolean mouseOver(int mx ,int my ,int x,int y,int genislik,int yükseklik) {
		if(mx > x && mx < x + genislik) {
			if(my > y && my < y + yükseklik) {
				return true;					//Kutu sýnýrlarýný belirliyoruz.Týklandýðýnda anlaþýlmasý için.
		}else return false;
		
	}else return false;
	}
	
	public void tick() {
		
	}
	
	public void render(Graphics g) {
		
		if(oyun.gameState == STATE.Menu) {
		
		Font fnt = new Font("arial" , 1 ,50);
		g.setFont(fnt);
		Font fnt2 = new Font("arial",1,30);
		
		g.setFont(fnt);
		g.setColor(Color.white);
		g.drawString("Menü",  oyun.GENISLIK / 2 -60, 50);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Oyna", 370, 130);
		g.setColor(Color.white);			//Menü bölümleri tasarýmý
		g.drawRect(310, 90, 200, 64);
		
		g.setColor(Color.white);
		g.drawRect(310, 190, 200, 64);
		g.drawString("Yardým", 360, 230);
		
		g.setColor(Color.white);
		g.drawRect(310, 290, 200, 64);
		g.drawString("Çýkýþ", 370, 330);
		}
		else if(oyun.gameState == STATE.Yardým) {
			Font fnt = new Font("arial" , 1 ,50);
			Font fnt2 = new Font("arial",1,18);
			Font fnt3 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Yardým", 310, 50);
			
			g.setFont(fnt2);
			g.drawString("Dükkan için M oyunu durdurmak için P ye basýnýz.",50, 90);
			g.drawString("Oynamak için WASD tuþlarýný kullanýn.",50, 140);
			g.drawString("Dükkandan Geliþtirme Satýn Alabilirsiniz.",50, 190);
			g.drawString("Her levelde oyunun zorluðu ve düþman çeþitliliði artar.", 50, 230);
			g.drawString("Düþmanlarýn baþýndan hasar alýrsýnýz kuyruklar zararsýzdýr.",50, 280);
			g.drawString("9 lvlde boss gelir 17 levelde oyunu kazanýrsýnýz.",50, 330);
			
			
			g.setFont(fnt3);
			g.drawRect(300, 370, 200, 64);
			g.drawString("Geri", 370, 410);
		}
		else if(oyun.gameState == STATE.Bitiþ) {
			Font fnt = new Font("arial" , 1 ,50);
			Font fnt2 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Kaybettin", 300, 50);
			g.drawString("Skorun: " + gösterge.getSkor() ,50, 170);
			
			g.setFont(fnt2);
			g.drawRect(410, 390, 200, 64);
			g.drawString("Yeniden dene", 413, 430);
			
			
			g.setFont(fnt2);
			g.drawRect(100, 390, 200, 64);
			g.drawString("Çýkýþ", 160, 430);
			
			
		}else if(oyun.gameState == STATE.Kazan) {
			
			Font fnt2 = new Font("arial",1,30);
			Font fnt4 = new Font("arial",1,25);
			
			g.setFont(fnt4);
			g.setColor(Color.red);
			g.drawString("KAZANDIN", 320, 100);
			g.drawString("Skor: " + gösterge.getSkor() , 325, 140);
			
			g.setFont(fnt2);
			g.drawRect(410, 390, 200, 64);
			g.drawString("Yeniden dene", 413, 430);
			
			
			g.setFont(fnt2);
			g.drawRect(100, 390, 200, 64);
			g.drawString("Çýkýþ", 160, 430);
			
		}
		}
		}
	

