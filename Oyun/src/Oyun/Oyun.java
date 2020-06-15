package Oyun;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Oyun extends Canvas implements Runnable{

	
	private static final long serialVersionUID = -5665090768239970352L;

	public static final int GENISLIK = 820, YUKSEKLIK = GENISLIK / 12 * 9;  //oyun çerçevesinin büyüklüðünü ayarlayabiliriz.
	
	private Thread thread;
	private boolean çalýþýyor=false;
	public static boolean paused = false;
	
	private Kontrol kontrol;
	private Random r;
	private GöstergeEkran gösterge;
	private SPR sp;
	private Menu menu;
	private Market market;
	Graphics g;
	
	
	public enum STATE {  //Oyun menusu yapýmý
		Menu,
		Yardým,
		Game,
		Bitiþ,
		Market,
		Kazan
	};
	
	public static STATE gameState = STATE.Menu;
	
	public Oyun() {
		
		
		kontrol = new Kontrol();
		gösterge = new GöstergeEkran(kontrol);
		market = new Market(kontrol,gösterge);
		menu = new Menu(this,kontrol,gösterge);
		this.addKeyListener(new Hareket(kontrol,this));
		this.addMouseListener(menu);
		this.addMouseListener(market);
		
		
		new Ekran(GENISLIK,YUKSEKLIK,"Surive if you can",this); // oyun ekran ayarlarý
		
	
		sp = new SPR(kontrol, gösterge);   // null pointer exception hatasý aldýðýmýz yer çünkü kontrol ve göstergeden önce tanýmladýk,tanýmlanmayan nesne çaðrýlamaz :)
		r = new Random();
		
		if(gameState == STATE.Game) {
			kontrol.objeEkle(new Oyuncu(GENISLIK/2-32,YUKSEKLIK/2-32,ID.Player,kontrol));
			//kontrol.objeEkle(new Oyuncu(GENISLIK/2+64,YUKSEKLIK/2-32,ID.Player2));
			//for (int i = 0 ; i < 20 ; i++)   // random düþman üretmek için
			kontrol.objeEkle(new BDüþman(r.nextInt(GENISLIK),r.nextInt(YUKSEKLIK),ID.BDüþman, kontrol));
		}
		
	}
	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		çalýþýyor = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			çalýþýyor=false;
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void run() {
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks;
		double delta = 0 ;
		long timer = System.currentTimeMillis();
		int frames = 0 ;
		
		while(çalýþýyor) {
			
			long now =System.nanoTime();
			delta += (now -lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			if (çalýþýyor)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.println("FPS : " + frames);
				frames = 0;
			}
		}
		
		stop();
		
		 }

	private void tick() {
		
		
		
		if(!paused) {
			
			if(gameState == STATE.Game) {
				
				gösterge.tick();
				sp.tick();
				kontrol.tick();
				
				if(gösterge.SAGLIK <= -2) {  // Canýmýz 0 a düþünce kaybediyoruz .
					gösterge.SAGLIK = 100;
					gameState = STATE.Bitiþ;
					kontrol.DüþmanlarýSil();
					
					
				}
		}
		
			
		}else if(gameState == STATE.Menu || gameState == STATE.Bitiþ) {
			menu.tick();
			kontrol.tick();
		}
		
	}
	private void render() {
		
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
		}
	
		Graphics g = bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, GENISLIK, YUKSEKLIK);
		
		Graphics p = bs.getDrawGraphics();
		
		kontrol.render(g);
		
		
		if(paused) {
			
			Font fnt = new Font("arial",1,20);
			
			p.setFont(fnt);
			p.setColor(Color.red);
			p.drawString("Oyun Durdu", 340, 200);
		}
		
		if (gameState == STATE.Game) {
			
			gösterge.render(g);  //oyuna baþladýðýmýzda göstergeleri gösterecek
		}
		else if (gameState == STATE.Market) {
		
			market.render(g);
		
		}
		
		else if(gameState == STATE.Menu || gameState == STATE.Yardým || gameState == STATE.Bitiþ || gameState == STATE.Kazan) {

			menu.render(g);
		}
		
				
		g.dispose();
		bs.show();
	}
		
	public static float sýnýr(float deðer,float min , float max) {
		if ( deðer >= max) 
			return deðer = max;
			
		else if(deðer <= min)       // Oyuncunumuzun oyun ekran sýnýrlarýný aþmamasý için
			return deðer = min;
		
		else 
			return deðer;
	}
	
	
	public static void main(String[] args) {
		
		new Oyun();
	}


	public static int getGenislik() {
		return GENISLIK;
	}


	public static int getYukseklik() {
		return YUKSEKLIK;
	}

}
