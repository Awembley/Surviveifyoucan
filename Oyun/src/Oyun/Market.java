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
	G�stergeEkran g�sterge;
	
	private int Y1 = 500;
	private int Y2 = 500;
	private int Y3 = 500;
	private int Y4 = 500;
	private int Y5 = 500;
	private int Y6 = 500;
	
	int geciciboyut = 2;
	float gecicih�z = 1.5f;
	
	public Market(Kontrol kontrol,G�stergeEkran g�sterge) {
		this.kontrol = kontrol;
		this.g�sterge = g�sterge;
	}
	
	public void render(Graphics g) {
		
		g.setColor(Color.white);
		g.setFont(new Font("arial",0,48));
		g.drawString("Market", Oyun.GENISLIK / 2 -100, 50);
		
		
		//CAN YETENE��
		g.setFont(new Font("arial",0,12));          
		g.drawString("Can� Y�kselt", 110, 130);
		g.drawString("Fiyat:" + Y1 , 110, 150);
		g.drawRect(100, 100, 100, 80);
		

		//CANI YEN�LE
		g.setFont(new Font("arial",0,12));          
		g.drawString("Can� Yenile", 340, 130);
		g.drawString("Fiyat:" + Y2 , 340, 150);
		g.drawRect(330, 100, 100, 80);
		

		//HIZI ARTTIR
		g.setFont(new Font("arial",0,12));          
		g.drawString("H�z� artt�r", 515, 130);
		g.drawString("Fiyat: " + Y3 , 515, 150);
		g.drawRect(500, 100, 100, 80);
		

		//D��MANLARI S�L
		g.setFont(new Font("arial",0,12));          
		g.drawString("D��manlar� Sil", 110, 230);
		g.drawString("Fiyat:" + Y4 , 110, 250);
		g.drawString("!Boss", 110, 270);
		g.drawRect(100, 200, 100, 80);
		
		//Kendini K���lt
		g.setFont(new Font("arial",0,12));          
		g.drawString("Kendini K���lt", 340, 230);
		g.drawString("Fiyat:" + Y5 , 340, 250);
		g.drawString("Max 6 kere", 340, 270);
		g.drawRect(330, 200, 100, 80);
		
		//�zel Kar���m
		g.setFont(new Font("arial",0,12));          
		g.drawString("�zel Kar���m", 515, 230);
		g.drawString("Fiyat:" + Y6 , 515, 250);
		g.drawRect(500, 200, 100, 80);
		
		
		g.drawString("Skor: " + g�sterge.getSkor() , Oyun.GENISLIK / 2 - 60, 330);
		g.drawString("Oyuna D�nmek ��in 'M' ye bas�n." , Oyun.GENISLIK / 2 -110, 360);
	}
	
	
	public void mousePressed(MouseEvent e) {   //Marketin �zelliklerini ayarlama.
		
		int mx = e.getX();
		int my = e.getY();
		
		if(mx >= 100 && mx <= 200) {  //Can� artt�r
			
			if (my >= 100 && my <= 180) {
				if(g�sterge.getSkor() >= Y1) {
					g�sterge.setSkor(g�sterge.getSkor() - Y1);
					Y1 += 500;
					g�sterge.s�n�r += 20;
					g�sterge.SAGLIK = (100 + (g�sterge.s�n�r / 2));
					
				}
			}
		}
		if(mx >= 330 && mx <= 430) { //Can� Yenile
			
			if (my >= 100 && my <= 180) {
				if(g�sterge.getSkor() >= Y2) {
					g�sterge.setSkor(g�sterge.getSkor() - Y2);
					Y2 += 500;
					g�sterge.SAGLIK = (100 + (g�sterge.s�n�r / 2));
						}
			}
		}
		if(mx >= 500 && mx <= 600) {  // H�z� artt�r
	
			if (my >= 100 && my <= 180) {
				if(g�sterge.getSkor() >= Y3) {
				g�sterge.setSkor(g�sterge.getSkor() - Y3);
				Y3 += 10;	
				kontrol.h�z+= 0.5;
				}

			}
			}
		if(mx >= 100 && mx <= 200) {  //D��manlar� Sil
				
			if (my >= 200 && my <= 300) {
				if(g�sterge.getSkor() >= Y4) { 
					if(g�sterge.getLevel() != 6) {   //boss leveller 
					g�sterge.setSkor(g�sterge.getSkor() - Y4);
					Y4 += 500;	
					kontrol.D��manlar�Sil();
					}
				}
			}
			
		}

		if(mx >= 330 && mx <= 430) {  //Kendini K���lt
			
			if (my >= 200 && my <= 300) {
				if(g�sterge.getSkor() >= Y5) { 
				if(kontrol.boyut > 20) {
					g�sterge.setSkor(g�sterge.getSkor() - Y5);
					Y5 += 500;	
					kontrol.boyut -= 2;
					
				}
				}
			}
		}
			if(mx >= 500 && mx <= 600) {  //�zel Kar���m
				
				if (my >= 200 && my <= 300) {
					if(g�sterge.getSkor() >= Y6) { 
						if(kontrol.boyut > 20 || kontrol.h�z < 12.0f) {
						g�sterge.setSkor(g�sterge.getSkor() - Y6);
						Y6 += 500;	
						kontrol.boyut -= geciciboyut;
						kontrol.h�z += gecicih�z;
						}
					}
					}
				}
			
		}
	
	}

	

