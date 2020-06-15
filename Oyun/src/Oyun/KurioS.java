package Oyun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class KurioS extends OyunObje{

	
	private Kontrol kontrol;
	Random r = new Random();
	
	public KurioS(int x, int y, ID id,Kontrol kontrol) {
		super(x, y, id);
		this.kontrol=kontrol;
		
		velX = (r.nextInt(5 - -5) + -5) ; 
		velY = 5 ;
	}
	
	public Rectangle dsýnýr() {
		return new Rectangle((int)x,(int)y,16,16);
		
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		
		//if ( y <= 0 || y >= Oyun.YUKSEKLIK - 52) velY *= -1;  //Düþmanýn Ekran içerisinde rastgele hareket etmesi için
		//if ( x <= 0 || x >= Oyun.GENISLIK - 25) velX *= -1;
		
		if (y >= Oyun.YUKSEKLIK) kontrol.objeSil(this);
		
		kontrol.objeEkle(new Kuyruk((int)x ,(int) y ,ID.Kuyruk,Color.red , 16 ,16, 0.03f ,kontrol ));  // kuyruk objesi oluþturalým can deðeri uzunluðunu belirler
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 16, 16);
		
	}

	public Kontrol getKontrol() {
		return kontrol;
	}

	public void setKontrol(Kontrol kontrol) {
		this.kontrol = kontrol;
	}

}
