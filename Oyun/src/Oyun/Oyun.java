package Oyun;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Oyun extends Canvas implements Runnable{

	
	private static final long serialVersionUID = -5665090768239970352L;

	public static final int GENISLIK = 820, YUKSEKLIK = GENISLIK / 12 * 9;  //oyun �er�evesinin b�y�kl���n� ayarlayabiliriz.
	
	private Thread thread;
	private boolean �al���yor=false;
	public static boolean paused = false;
	
	private Kontrol kontrol;
	private Random r;
	private G�stergeEkran g�sterge;
	private SPR sp;
	private Menu menu;
	private Market market;
	Graphics g;
	
	
	public enum STATE {  //Oyun menusu yap�m�
		Menu,
		Yard�m,
		Game,
		Biti�,
		Market,
		Kazan
	};
	
	public static STATE gameState = STATE.Menu;
	
	public Oyun() {
		
		
		kontrol = new Kontrol();
		g�sterge = new G�stergeEkran(kontrol);
		market = new Market(kontrol,g�sterge);
		menu = new Menu(this,kontrol,g�sterge);
		this.addKeyListener(new Hareket(kontrol,this));
		this.addMouseListener(menu);
		this.addMouseListener(market);
		
		
		new Ekran(GENISLIK,YUKSEKLIK,"Surive if you can",this); // oyun ekran ayarlar�
		
	
		sp = new SPR(kontrol, g�sterge);   // null pointer exception hatas� ald���m�z yer ��nk� kontrol ve g�stergeden �nce tan�mlad�k,tan�mlanmayan nesne �a�r�lamaz :)
		r = new Random();
		
		if(gameState == STATE.Game) {
			kontrol.objeEkle(new Oyuncu(GENISLIK/2-32,YUKSEKLIK/2-32,ID.Player,kontrol));
			//kontrol.objeEkle(new Oyuncu(GENISLIK/2+64,YUKSEKLIK/2-32,ID.Player2));
			//for (int i = 0 ; i < 20 ; i++)   // random d��man �retmek i�in
			kontrol.objeEkle(new BD��man(r.nextInt(GENISLIK),r.nextInt(YUKSEKLIK),ID.BD��man, kontrol));
		}
		
	}
	
	
	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		�al���yor = true;
	}
	
	public synchronized void stop() {
		try {
			thread.join();
			�al���yor=false;
			
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
		
		while(�al���yor) {
			
			long now =System.nanoTime();
			delta += (now -lastTime) / ns;
			lastTime = now;
			
			while(delta >= 1) {
				tick();
				delta--;
			}
			if (�al���yor)
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
				
				g�sterge.tick();
				sp.tick();
				kontrol.tick();
				
				if(g�sterge.SAGLIK <= -2) {  // Can�m�z 0 a d���nce kaybediyoruz .
					g�sterge.SAGLIK = 100;
					gameState = STATE.Biti�;
					kontrol.D��manlar�Sil();
					
					
				}
		}
		
			
		}else if(gameState == STATE.Menu || gameState == STATE.Biti�) {
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
			
			g�sterge.render(g);  //oyuna ba�lad���m�zda g�stergeleri g�sterecek
		}
		else if (gameState == STATE.Market) {
		
			market.render(g);
		
		}
		
		else if(gameState == STATE.Menu || gameState == STATE.Yard�m || gameState == STATE.Biti� || gameState == STATE.Kazan) {

			menu.render(g);
		}
		
				
		g.dispose();
		bs.show();
	}
		
	public static float s�n�r(float de�er,float min , float max) {
		if ( de�er >= max) 
			return de�er = max;
			
		else if(de�er <= min)       // Oyuncunumuzun oyun ekran s�n�rlar�n� a�mamas� i�in
			return de�er = min;
		
		else 
			return de�er;
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
