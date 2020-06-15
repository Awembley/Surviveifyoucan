package Oyun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class S�l�k extends OyunObje{

	
	private Kontrol kontrol;
	private OyunObje oyuncu;
	
	public S�l�k(int x, int y, ID id,Kontrol kontrol) {
		super(x, y, id);
		this.kontrol=kontrol;
		
		
		for (int i = 0 ; i < kontrol.obje.size() ; i++) {
			if (kontrol.obje.get(i).getId() == ID.Player) oyuncu = kontrol.obje.get(i);
		}
		
		
		
	
	}
	
	public Rectangle ds�n�r() {
		return new Rectangle((int)x,(int)y,16,16);
		
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		 //D��man�n konumumuzu saptay�p bizi takip etmesi i�in gerekli kodlar
		
		float dX = x - oyuncu.getX() - 8;    
		float dY = y - oyuncu.getY() - 8;
		float mesafe = (float)Math.sqrt(((x-oyuncu.getX())*(x-oyuncu.getX())) + ((y-oyuncu.getY())*(y-oyuncu.getY())));
		
		velX = (float) ((-1.0 / mesafe) * dX);
		velY = (float) ((-1.0 / mesafe) * dY);
		
		if ( y <= 0 || y >= Oyun.YUKSEKLIK - 52) velY *= -1;  //D��man�n Ekran i�erisinde rastgele hareket etmesi i�in
		if ( x <= 0 || x >= Oyun.GENISLIK - 25) velX *= -1;
		
		kontrol.objeEkle(new Kuyruk((int)x ,(int) y ,ID.Kuyruk,Color.blue , 16 ,16, 0.02f ,kontrol ));  // kuyruk objesi olu�tural�m can de�eri uzunlu�unu belirler
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.blue);
		g.fillRect((int)x,(int) y, 16, 16);
		
	}

	public Kontrol getKontrol() {
		return kontrol;
	}

	public void setKontrol(Kontrol kontrol) {
		this.kontrol = kontrol;
	}

}
