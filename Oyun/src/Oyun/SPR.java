package Oyun;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.util.Random;

import Oyun.Oyun.STATE;

public class SPR {   //Düþmanlarýn oluþturulduðu sýnýf
	
	private Kontrol kontrol;
	private GöstergeEkran gösterge;
	private Random r = new Random();
	Oyun oyun;
	Graphics g;
	

	private int gskor = 0;
	
	
	public SPR(Kontrol kontrol,GöstergeEkran gösterge) {
		
		this.kontrol = kontrol;
		this.gösterge = gösterge;
		
	}
	
	public void tick() {   //Her level aldýðýmýzda  düþman yaratmak için
		gskor++;
		
		
		if(gskor >= 1000 ) { //düþmanlarýn spawn olma skoru 
			
			gskor=0;
			gösterge.setLevel(gösterge.getLevel() + 1);

			if(gösterge.getLevel() == 2) {
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
			}
			else if(gösterge.getLevel() == 3) {		
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				}
			else if(gösterge.getLevel() == 4) {
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				
				
				}
			else if(gösterge.getLevel() == 5) {
				kontrol.objeEkle(new Sülük(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.Sülük,kontrol));
				}
			else if(gösterge.getLevel() == 6) {
				
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				//kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  çift bos :)
			}
			
			else if(gösterge.getLevel() == 7) {
				kontrol.DüþmanlarýSil();
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				kontrol.objeEkle(new HDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HDüþman,kontrol));
				kontrol.objeEkle(new HDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HDüþman,kontrol));
				
			}else if(gösterge.getLevel() == 8) {
			
				kontrol.objeEkle(new HDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HDüþman,kontrol));
				kontrol.objeEkle(new HDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HDüþman,kontrol));
				kontrol.objeEkle(new Sülük(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.Sülük,kontrol));
			}else if(gösterge.getLevel() == 9) {
				
				kontrol.DüþmanlarýSil();  //Boss gelince varolan düþmanlarý silmek için
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 -48,-160,ID.Kurio,kontrol));
				//kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  çift bos :)
			}else if(gösterge.getLevel() == 10) {
				
				kontrol.DüþmanlarýSil();  
				//kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  çift bos :)
				kontrol.objeEkle(new Sülük(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.Sülük,kontrol));
				kontrol.objeEkle(new Sülük(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.Sülük,kontrol));
				kontrol.objeEkle(new Sülük(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.Sülük,kontrol));
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				
				
			}
			else if(gösterge.getLevel() == 12) {
				
				kontrol.objeEkle(new HDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HDüþman,kontrol));
				kontrol.objeEkle(new HDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HDüþman,kontrol));
				kontrol.objeEkle(new HDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.HDüþman,kontrol));
			
				
			}
			else if(gösterge.getLevel() == 13) {
				
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
				kontrol.objeEkle(new BDüþman(r.nextInt(Oyun.GENISLIK),r.nextInt(Oyun.YUKSEKLIK),ID.BDüþman,kontrol));
			
				
			}else if(gösterge.getLevel() == 14) {
				
				kontrol.DüþmanlarýSil();  //Boss gelince varolan düþmanlarý silmek için
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 -48,-160,ID.Kurio,kontrol));
				 
			}else if(gösterge.getLevel() == 15) {
				
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 +48,-220,ID.Kurio,kontrol));  
			}else if(gösterge.getLevel() == 16) {
				
				kontrol.objeEkle(new Kurio((Oyun.GENISLIK)/2 -120,-220,ID.Kurio,kontrol));  
			}
			
			
			else if(gösterge.getLevel() == 17) {
				
				kontrol.DüþmanlarýSil();
				oyun.gameState = STATE.Kazan;
				
				
				
			}
		}	
		
	}


	






}

	