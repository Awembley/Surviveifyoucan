package Oyun;

import java.awt.Color;
import java.awt.Graphics;

public class GöstergeEkran {
	
	private Kontrol kontrol;
	public int sýnýr;
	public static int SAGLIK = 100;
	
	private int yeþildeðeri= 255;
	private int skor = 0;
	private int level = 1;
	
	
	
	
	public GöstergeEkran(Kontrol kontrol) {
		this.kontrol = kontrol;
	}
	
	
	public void tick() {
		//SAGLIK--;
		
		SAGLIK =(int) Oyun.sýnýr(SAGLIK, 0, 100 + (sýnýr / 2));
		yeþildeðeri = (int)Oyun.sýnýr(yeþildeðeri, 0, 255);
		yeþildeðeri = SAGLIK *2;
		
		
		skor++;
				
		
		}
	


	public void render(Graphics g) {
		
		g.setColor(Color.gray); // eksilen canda bar rengi
		g.fillRect(15, 15, 200 + sýnýr, 32);  // can arttýkça yeþil barý arttýrýyoruz.
		g.setColor(Color.getHSBColor( (1f * SAGLIK) / 360, 1f, 1f));   //saðlýk barý ve azaldýkça renk deðeleri
		g.fillRect(15, 15, SAGLIK * 2 , 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200 + sýnýr, 32);  //çerçeve rengi
		
		
		g.drawString("Skor :" + skor ,10 , 64);
		g.drawString("Level :" + level ,10 , 78);
		g.drawString("Saðlýk : " + SAGLIK,10, 93);
		g.drawString("Hýz : " + kontrol.hýz ,10, 107);
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
