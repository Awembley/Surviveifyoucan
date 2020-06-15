package Oyun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Oyuncu extends OyunObje{

	Random r = new Random();
	
	Kontrol kontrol;
	
	public Oyuncu(int x, int y, ID id,Kontrol kontrol) {
		super(x, y, id);
		this.kontrol = kontrol;
		
	}
	
	public Rectangle dsýnýr() {
		return new Rectangle((int)x,(int)y,kontrol.boyut,kontrol.boyut);
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Oyun.sýnýr(x, 0, Oyun.GENISLIK - 49); //x ekseni için
		y = Oyun.sýnýr(y, 0, Oyun.YUKSEKLIK - 71); // y ekseni için
		
		kontrol.objeEkle(new Kuyruk((int)x ,(int) y ,ID.Kuyruk,Color.yellow , kontrol.boyut ,kontrol.boyut, 0.05f ,kontrol)); //kendi kuyruðumuzu oluþturalým renk ve büyüklüðü seçebiliriz. 
	
		çarpýþma();
	}

	
	private void çarpýþma() {          // objelerin çarpýþmasý için metod
		
		for(int i = 0 ; i < kontrol.obje.size() ; i++) {
			
			OyunObje gn = kontrol.obje.get(i);
			
			
			if(gn.getId() == ID.BDüþman || gn.getId() == ID.HDüþman || gn.getId() == ID.Sülük) { //eklediðimiz düþmanlarý tanýmlamak için
				
				if(dsýnýr().intersects(gn.dsýnýr())) {  //basit seviyede düþman için
					GöstergeEkran.SAGLIK -=2;
					
				}
				
				
			}
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
		
		g.setColor(Color.white);
		//else if(id == ID.Player2) g.setColor(Color.red); //hareket deneme
			g.fillRect((int)x,(int) y, kontrol.boyut, kontrol.boyut);  //hata yaptýðým yer 0 0 deðerleri hata veriyor :)
		
	}

	
	
	
}
