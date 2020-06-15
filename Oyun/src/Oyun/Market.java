package Oyun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import Oyun.Oyun.STATE;

public class Market extends MouseAdapter{

	private static long start;
	private static long time;
	
	Kontrol kontrol;
	GöstergeEkran gösterge;
	
	private int Y1 = 500;
	private int Y2 = 500;
	private int Y3 = 500;
	private int Y4 = 500;
	private int Y5 = 500;
	private int Y6 = 500;
	
	int geciciboyut = 2;
	float gecicihýz = 1.5f;
	
	public Market(Kontrol kontrol,GöstergeEkran gösterge) {
		this.kontrol = kontrol;
		this.gösterge = gösterge;
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",0,48));
		g.drawString("Market", Oyun.GENISLIK / 2 -100, 50);
		
		
		//CAN YETENEÐÝ
		g.setFont(new Font("arial",0,12));          
		g.drawString("Caný Yükselt", 110, 130);
		g.drawString("Fiyat:" + Y1 , 110, 150);
		g.drawRect(100, 100, 100, 80);
		

		//CANI YENÝLE
		g.setFont(new Font("arial",0,12));          
		g.drawString("Caný Yenile", 340, 130);
		g.drawString("Fiyat:" + Y2 , 340, 150);
		g.drawRect(330, 100, 100, 80);
		

		//HIZI ARTTIR
		g.setFont(new Font("arial",0,12));          
		g.drawString("Hýzý arttýr", 515, 130);
		g.drawString("Fiyat: " + Y3 , 515, 150);
		g.drawRect(500, 100, 100, 80);
		

		//DÜÞMANLARI SÝL
		g.setFont(new Font("arial",0,12));          
		g.drawString("Düþmanlarý Sil", 110, 230);
		g.drawString("Fiyat:" + Y4 , 110, 250);
		g.drawString("!Boss", 110, 270);
		g.drawRect(100, 200, 100, 80);
		
		//Kendini Küçült
		g.setFont(new Font("arial",0,12));          
		g.drawString("Kendini Küçült", 340, 230);
		g.drawString("Fiyat:" + Y5 , 340, 250);
		g.drawString("Max 6 kere", 340, 270);
		g.drawRect(330, 200, 100, 80);
		
		//Özel Karýþým
		g.setFont(new Font("arial",0,12));          
		g.drawString("Özel Karýþým", 515, 230);
		g.drawString("Fiyat:" + Y6 , 515, 250);
		g.drawRect(500, 200, 100, 80);
		
		
		g.drawString("Skor: " + gösterge.getSkor() , Oyun.GENISLIK / 2 - 60, 330);
		g.drawString("Oyuna Dönmek Ýçin 'M' ye basýn." , Oyun.GENISLIK / 2 -110, 360);
	}
	
	
	public void mousePressed(MouseEvent e) {   //Marketin özelliklerini ayarlama.
		
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= 100 && mx <= 200) {  //Caný arttýr
			
			if (my >= 100 && my <= 180) {
				if(gösterge.getSkor() >= Y1) {
					gösterge.setSkor(gösterge.getSkor() - Y1);
					Y1 += 500;
					gösterge.sýnýr += 20;
					gösterge.SAGLIK = (100 + (gösterge.sýnýr / 2));
					
				}
			}
		}
		if(mx >= 330 && mx <= 430) { //Caný Yenile
			
			if (my >= 100 && my <= 180) {
				if(gösterge.getSkor() >= Y2) {
					gösterge.setSkor(gösterge.getSkor() - Y2);
					Y2 += 500;
					gösterge.SAGLIK = (100 + (gösterge.sýnýr / 2));
						}
			}
		}
		if(mx >= 500 && mx <= 600) {  // Hýzý arttýr
	
			if (my >= 100 && my <= 180) {
				if(gösterge.getSkor() >= Y3) {
				gösterge.setSkor(gösterge.getSkor() - Y3);
				Y3 += 10;	
				kontrol.hýz+= 0.5;
				}

			}
			}
		if(mx >= 100 && mx <= 200) {  //Düþmanlarý Sil
				
			if (my >= 200 && my <= 300) {
				if(gösterge.getSkor() >= Y4) { 
					if(gösterge.getLevel() != 6) {   //boss leveller 
					gösterge.setSkor(gösterge.getSkor() - Y4);
					Y4 += 500;	
					kontrol.DüþmanlarýSil();
					}
				}
			}
			
		}

		if(mx >= 330 && mx <= 430) {  //Kendini Küçült
			
			if (my >= 200 && my <= 300) {
				if(gösterge.getSkor() >= Y5) { 
				if(kontrol.boyut > 20) {
					gösterge.setSkor(gösterge.getSkor() - Y5);
					Y5 += 500;	
					kontrol.boyut -= 2;
					
				}
				}
			}
		}
			if(mx >= 500 && mx <= 600) {  //Özel Karýþým
				
				if (my >= 200 && my <= 300) {
					if(gösterge.getSkor() >= Y6) { 
						if(kontrol.boyut > 20 || kontrol.hýz < 12.0f) {
						gösterge.setSkor(gösterge.getSkor() - Y6);
						Y6 += 500;	
						kontrol.boyut -= geciciboyut;
						kontrol.hýz += gecicihýz;
						}
					}
					}
				}
			
		}
	
	}

	

