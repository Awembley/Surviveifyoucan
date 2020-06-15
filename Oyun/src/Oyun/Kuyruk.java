package Oyun;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Kuyruk extends OyunObje {

	private float can;
	private int genislik,y�kseklik;
	private float alpha=1;
	private Kontrol kontrol;
	private Color renk;
	
	public Kuyruk(int x, int y, ID id,Color renk,int genislik,int y�kseklik,float can,Kontrol kontrol) {
		super(x, y, id);
		this.kontrol = kontrol;
		this.renk=renk;
		this.genislik = genislik;
		this.y�kseklik = y�kseklik;
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
		g2d.setComposite(�effayYap(alpha));
		g.setColor(renk);
		g.fillRect((int)x,(int)y, genislik, y�kseklik);
		
		g2d.setComposite(�effayYap(1));
	}

	private AlphaComposite �effayYap(float alpha) {   // kuyru�un �effaf olup hasar vermemesi ve i�inden ge�ilmesini sa�lar.
		
		int type = AlphaComposite.SRC_OVER;
		return (AlphaComposite.getInstance(type,alpha));
		
	}
	
	@Override
	public Rectangle ds�n�r() {
		// TODO Auto-generated method stub
		return null;
	}

}
