package Oyun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class HD��man extends OyunObje{

	
	private Kontrol kontrol;
	
	public HD��man(int x, int y, ID id,Kontrol kontrol) {
		super(x, y, id);
		this.kontrol=kontrol;
		
		velX = 7 ; 
		velY = 8 ;
	}
	
	public Rectangle ds�n�r() {
		return new Rectangle((int)x,(int)y,16,16);
		
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		
		if ( y <= 0 || y >= Oyun.YUKSEKLIK - 52) velY *= -1;  //D��man�n Ekran i�erisinde rastgele hareket etmesi i�in
		if ( x <= 0 || x >= Oyun.GENISLIK - 25) velX *= -1;
		
		kontrol.objeEkle(new Kuyruk((int)x ,(int) y ,ID.Kuyruk,Color.DARK_GRAY , 16 ,16, 0.03f ,kontrol ));  // kuyruk objesi olu�tural�m can de�eri uzunlu�unu belirler
	}

	@Override
	public void render(Graphics g) {
	
			g.setColor(Color.DARK_GRAY);
			g.fillRect((int)x,(int) y, 16, 16);
			
		
	}

	public Kontrol getKontrol() {
		return kontrol;
	}

	public void setKontrol(Kontrol kontrol) {
		this.kontrol = kontrol;
	}

}
