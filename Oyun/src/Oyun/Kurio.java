package Oyun;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Kurio extends OyunObje{

	
	private Kontrol kontrol;
	Random r = new Random();
	
	private int timer = 80;
	private int timer2 = 50;
	
	public Kurio(int x, int y, ID id,Kontrol kontrol) {
		super(x, y, id);
		this.kontrol=kontrol;
		
		velX = 0 ; 
		velY = 2 ;
	}
	
	public Rectangle dsýnýr() {
		return new Rectangle((int)x,(int)y,96,96);
		
	}
	
	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if (timer <= 0) velY = 0;   //ekrana giriþ yapmasý için
		else timer--;
		
		if(timer <= 0) timer2--;
		if(timer2 <= 0) {
			
			if(velX == 0) velX = 3;
			
			if(velX > 0) {
			velX += 0.005f;
			}
			else if(velX < 0) {
				velX -= 0.005f;
			}
			
			velX = Oyun.sýnýr(velX, -10, 10);
			
			int sp = r.nextInt(10);
			if(sp == 0) kontrol.objeEkle(new KurioS((int)x + 48, (int)y + 48, ID.BDüþman, kontrol));
			
		}
		
		//if ( y <= 0 || y >= Oyun.YUKSEKLIK - 52) velY *= -1;  //Düþmanýn Ekran içerisinde rastgele hareket etmesi için
		if ( x <= 0 || x >= Oyun.GENISLIK - 100) velX *= -1;
		
		//kontrol.objeEkle(new Kuyruk((int)x ,(int) y ,ID.Kuyruk,Color.red , 96 ,96, 0.03f ,kontrol ));  // kuyruk objesi oluþturalým can deðeri uzunluðunu belirler
	}

	@Override
	public void render(Graphics g) {
		
		g.setColor(Color.red);
		g.fillRect((int)x,(int) y, 96, 96);
		
	}

	public Kontrol getKontrol() {
		return kontrol;
	}

	public void setKontrol(Kontrol kontrol) {
		this.kontrol = kontrol;
	}

}
