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
	private G�stergeEkran g�sterge;
	
	
	public Menu(Oyun oyun,Kontrol kontrol,G�stergeEkran g�sterge) {
		this.oyun = oyun;
		this.kontrol = kontrol;
		this.g�sterge = g�sterge;
	}
	
	public void mousePressed(MouseEvent e) {
		
		int mx = e.getX();
		int my = e.getY();
		
		if(oyun.gameState == STATE.Menu) {

			
			if(mouseOver(mx, my, 310, 90, 200, 64)) { //Oyna butonu 
				oyun.gameState = STATE.Game;          
				kontrol.objeEkle(new Oyuncu(Oyun.GENISLIK/2-32,Oyun.YUKSEKLIK/2-32,ID.Player,kontrol));
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man, kontrol));
			}
			if(mouseOver(mx,my,310,190,200,64)) { //Yard�m butonu
				oyun.gameState = STATE.Yard�m;
			}
			
			if(mouseOver(mx,my,310,290,200,64)) { //��k�� butonu
				System.exit(1);
			}
		}
		
		if(oyun.gameState == STATE.Biti� ||  oyun.gameState == STATE.Kazan) {
			if(mouseOver(mx, my, 410, 390, 200, 64)) { //Yeniden dene butonu
				kontrol.D��manlar�Sil();
				oyun.gameState = STATE.Game;
				kontrol.objeEkle(new Oyuncu(Oyun.GENISLIK/2-32,Oyun.YUKSEKLIK/2-32,ID.Player,kontrol));
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man, kontrol));
				g�sterge.setLevel(1);
				g�sterge.setSkor(0);
			}
			}
		if(oyun.gameState == STATE.Biti� ||  oyun.gameState == STATE.Kazan) {
			if(mouseOver(mx, my, 100, 390, 200, 64)) {  //��k�� tu�u
				kontrol.D��manlar�Sil();
				g�sterge.setLevel(1);
				g�sterge.setSkor(0);
				oyun.gameState = STATE.Menu;
			}
		}
		
		
		//Men�n�n d���na ta��d�k ��nk� yard�m�n i�erisindeyken men� komutlar�n� kullanabiliyorduk.
		if(oyun.gameState == STATE.Yard�m) {
			if(mouseOver(mx,my,300,370,200,64)) { //Geri butonu
				oyun.gameState = STATE.Menu;
				return;
		}
	
		}
	}
	
	public void mouseRelease(MouseEvent e) {
		
		
	}
	
	private boolean mouseOver(int mx ,int my ,int x,int y,int genislik,int y�kseklik) {
		if(mx > x && mx < x + genislik) {
			if(my > y && my < y + y�kseklik) {
				return true;					//Kutu s�n�rlar�n� belirliyoruz.T�kland���nda anla��lmas� i�in.
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
		g.drawString("Men�",  oyun.GENISLIK / 2 -60, 50);
		
		g.setFont(fnt2);
		g.setColor(Color.white);
		g.drawString("Oyna", 370, 130);
		g.setColor(Color.white);			//Men� b�l�mleri tasar�m�
		g.drawRect(310, 90, 200, 64);
		
		g.setColor(Color.white);
		g.drawRect(310, 190, 200, 64);
		g.drawString("Yard�m", 360, 230);
		
		g.setColor(Color.white);
		g.drawRect(310, 290, 200, 64);
		g.drawString("��k��", 370, 330);
		}
		else if(oyun.gameState == STATE.Yard�m) {
			Font fnt = new Font("arial" , 1 ,50);
			Font fnt2 = new Font("arial",1,18);
			Font fnt3 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Yard�m", 310, 50);
			
			g.setFont(fnt2);
			g.drawString("D�kkan i�in M oyunu durdurmak i�in P ye bas�n�z.",50, 90);
			g.drawString("Oynamak i�in WASD tu�lar�n� kullan�n.",50, 140);
			g.drawString("D�kkandan Geli�tirme Sat�n Alabilirsiniz.",50, 190);
			g.drawString("Her levelde oyunun zorlu�u ve d��man �e�itlili�i artar.", 50, 230);
			g.drawString("D��manlar�n ba��ndan hasar al�rs�n�z kuyruklar zarars�zd�r.",50, 280);
			g.drawString("9 lvlde boss gelir 17 levelde oyunu kazan�rs�n�z.",50, 330);
			
			
			g.setFont(fnt3);
			g.drawRect(300, 370, 200, 64);
			g.drawString("Geri", 370, 410);
		}
		else if(oyun.gameState == STATE.Biti�) {
			Font fnt = new Font("arial" , 1 ,50);
			Font fnt2 = new Font("arial",1,30);
			
			g.setFont(fnt);
			g.setColor(Color.white);
			g.drawString("Kaybettin", 300, 50);
			g.drawString("Skorun: " + g�sterge.getSkor() ,50, 170);
			
			g.setFont(fnt2);
			g.drawRect(410, 390, 200, 64);
			g.drawString("Yeniden dene", 413, 430);
			
			
			g.setFont(fnt2);
			g.drawRect(100, 390, 200, 64);
			g.drawString("��k��", 160, 430);
			
			
		}else if(oyun.gameState == STATE.Kazan) {
			
			Font fnt2 = new Font("arial",1,30);
			Font fnt4 = new Font("arial",1,25);
			
			g.setFont(fnt4);
			g.setColor(Color.red);
			g.drawString("KAZANDIN", 320, 100);
			g.drawString("Skor: " + g�sterge.getSkor() , 325, 140);
			
			g.setFont(fnt2);
			g.drawRect(410, 390, 200, 64);
			g.drawString("Yeniden dene", 413, 430);
			
			
			g.setFont(fnt2);
			g.drawRect(100, 390, 200, 64);
			g.drawString("��k��", 160, 430);
			
		}
		}
		}
	

