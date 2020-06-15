package Oyun;

import java.awt.Color;
import java.awt.Graphics;

public class G�stergeEkran {
	
	private Kontrol kontrol;
	public int s�n�r;
	public static int SAGLIK = 100;
	
	private int ye�ilde�eri= 255;
	private int skor = 0;
	private int level = 1;
	
	
	
	
	public G�stergeEkran(Kontrol kontrol) {
		this.kontrol = kontrol;
	}
	
	
	public void tick() {
		//SAGLIK--;
		
		SAGLIK =(int) Oyun.s�n�r(SAGLIK, 0, 100 + (s�n�r / 2));
		ye�ilde�eri = (int)Oyun.s�n�r(ye�ilde�eri, 0, 255);
		ye�ilde�eri = SAGLIK *2;
		
		
		skor++;
				
		
		}
	


	public void render(Graphics g) {
		
		g.setColor(Color.gray); // eksilen canda bar rengi
		g.fillRect(15, 15, 200 + s�n�r, 32);  // can artt�k�a ye�il bar� artt�r�yoruz.
		g.setColor(Color.getHSBColor( (1f * SAGLIK) / 360, 1f, 1f));   //sa�l�k bar� ve azald�k�a renk de�eleri
		g.fillRect(15, 15, SAGLIK * 2 , 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200 + s�n�r, 32);  //�er�eve rengi
		
		
		g.drawString("Skor :" + skor ,10 , 64);
		g.drawString("Level :" + level ,10 , 78);
		g.drawString("Sa�l�k : " + SAGLIK,10, 93);
		g.drawString("H�z : " + kontrol.h�z ,10, 107);
		g.drawString("Boyut : " + kontrol.boyut ,10, 121);
	}


	public int getSkor() {
		return skor;
	}


	public void setSkor(int skor) {
		this.skor = skor;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}







}
