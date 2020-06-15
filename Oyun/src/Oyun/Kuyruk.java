package Oyun;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Kuyruk extends OyunObje {

	private float can;
	private int genislik,yükseklik;
	private float alpha=1;
	private Kontrol kontrol;
	private Color renk;
	
	public Kuyruk(int x, int y, ID id,Color renk,int genislik,int yükseklik,float can,Kontrol kontrol) {
		super(x, y, id);
		this.kontrol = kontrol;
		this.renk=renk;
		this.genislik = genislik;
		this.yükseklik = yükseklik;
		this.can=can;
	}

	@Override
	public void tick() {
		if(alpha > can) {
			alpha -= (can - 0.0001f);
			}
		else kontrol.objeSil(this);
		
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		Graphics2D g2d = (Graphics2D) g;
		g2d.setComposite(þeffayYap(alpha));
		g.setColor(renk);
		g.fillRect((int)x,(int)y, genislik, yükseklik);
		
		g2d.setComposite(þeffayYap(1));
	}

	private AlphaComposite þeffayYap(float alpha) {   // kuyruðun þeffaf olup hasar vermemesi ve içinden geçilmesini saðlar.
		
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type,alpha));
		
	}
	
	@Override
	public Rectangle dsýnýr() {
		// TODO Auto-generated method stub
		return null;
	}

}
