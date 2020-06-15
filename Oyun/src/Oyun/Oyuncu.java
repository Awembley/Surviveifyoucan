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
	
	public Rectangle ds�n�r() {
		return new Rectangle((int)x,(int)y,kontrol.boyut,kontrol.boyut);
		
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		x = Oyun.s�n�r(x, 0, Oyun.GENISLIK - 49); //x ekseni i�in
		y = Oyun.s�n�r(y, 0, Oyun.YUKSEKLIK - 71); // y ekseni i�in
		
		kontrol.objeEkle(new Kuyruk((int)x ,(int) y ,ID.Kuyruk,Color.yellow , kontrol.boyut ,kontrol.boyut, 0.05f ,kontrol)); //kendi kuyru�umuzu olu�tural�m renk ve b�y�kl��� se�ebiliriz. 
	
		�arp��ma();
	}

	
	private void �arp��ma() {          // objelerin �arp��mas� i�in metod
		
		for(int i = 0 ; i < kontrol.obje.size() ; i++) {
			
			OyunObje gn = kontrol.obje.get(i);
			
			
			if(gn.getId() == ID.BD��man || gn.getId() == ID.HD��man || gn.getId() == ID.S�l�k) { //ekledi�imiz d��manlar� tan�mlamak i�in
				
				if(ds�n�r().intersects(gn.ds�n�r())) {  //basit seviyede d��man i�in
					G�stergeEkran.SAGLIK -=2;
					
				}
				
				
			}
		}
		
	}
	
	@Override
	public void render(Graphics g) {
		
		
		g.setColor(Color.white);
		//else if(id == ID.Player2) g.setColor(Color.red); //hareket deneme
			g.fillRect((int)x,(int) y, kontrol.boyut, kontrol.boyut);  //hata yapt���m yer 0 0 de�erleri hata veriyor :)
		
	}

	
	
	
}
