package Oyun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import Oyun.Oyun.STATE;

public class SPR {   //D��manlar�n olu�turuldu�u s�n�f
	
	private Kontrol kontrol;
	private G�stergeEkran g�sterge;
	private Random r = new Random();
	Oyun oyun;
	Graphics g;
	

	private int gskor = 0;
	
	
	public SPR(Kontrol kontrol,G�stergeEkran g�sterge) {
		
		this.kontrol = kontrol;
		this.g�sterge = g�sterge;
		
	}
	
	public void tick() {   //Her level ald���m�zda  d��man yaratmak i�in
		gskor++;
		
		
		if(gskor >= 1000 ) { //d��manlar�n spawn olma skoru 
			
			gskor=0;
			g�sterge.setLevel(g�sterge.getLevel() + 1);

			if(g�sterge.getLevel() == 2) {
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
			}
			else if(g�sterge.getLevel() == 3) {		
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				}
			else if(g�sterge.getLevel() == 4) {
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				
				
				}
			else if(g�sterge.getLevel() == 5) {
				kontrol.objeEkle(new S�l�k(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.S�l�k,kontrol));
				}
			else if(g�sterge.getLevel() == 6) {
				
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				//kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  �ift bos :)
			}
			
			else if(g�sterge.getLevel() == 7) {
				kontrol.D��manlar�Sil();
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				kontrol.objeEkle(new HD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HD��man,kontrol));
				kontrol.objeEkle(new HD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HD��man,kontrol));
				
			}else if(g�sterge.getLevel() == 8) {
			
				kontrol.objeEkle(new HD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HD��man,kontrol));
				kontrol.objeEkle(new HD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HD��man,kontrol));
				kontrol.objeEkle(new S�l�k(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.S�l�k,kontrol));
			}else if(g�sterge.getLevel() == 9) {
				
				kontrol.D��manlar�Sil();  //Boss gelince varolan d��manlar� silmek i�in
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 -48,-160,ID.Kurio,kontrol));
				//kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  �ift bos :)
			}else if(g�sterge.getLevel() == 10) {
				
				kontrol.D��manlar�Sil();  
				//kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  �ift bos :)
				kontrol.objeEkle(new S�l�k(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.S�l�k,kontrol));
				kontrol.objeEkle(new S�l�k(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.S�l�k,kontrol));
				kontrol.objeEkle(new S�l�k(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.S�l�k,kontrol));
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				
				
			}
			else if(g�sterge.getLevel() == 12) {
				
				kontrol.objeEkle(new HD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HD��man,kontrol));
				kontrol.objeEkle(new HD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HD��man,kontrol));
				kontrol.objeEkle(new HD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HD��man,kontrol));
			
				
			}
			else if(g�sterge.getLevel() == 13) {
				
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
				kontrol.objeEkle(new BD��man(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BD��man,kontrol));
			
				
			}else if(g�sterge.getLevel() == 14) {
				
				kontrol.D��manlar�Sil();  //Boss gelince varolan d��manlar� silmek i�in
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 -48,-160,ID.Kurio,kontrol));
				 
			}else if(g�sterge.getLevel() == 15) {
				
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  
			}else if(g�sterge.getLevel() == 16) {
				
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 -120,-220,ID.Kurio,kontrol));  
			}
			
			
			else if(g�sterge.getLevel() == 17) {
				
				kontrol.D��manlar�Sil();
				oyun.gameState = STATE.Kazan;
				
				
				
			}
		}	
		
	}


	






}

	