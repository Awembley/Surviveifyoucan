package Oyun;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


import Oyun.Oyun.STATE;

public class Hareket extends KeyAdapter{
	
	private Kontrol kontrol;
	private boolean[] kDown = new boolean[4];
	
	
	Oyun oyun;
	
	public Hareket(Kontrol kontrol , Oyun oyun) {
		this.kontrol = kontrol;
		this.oyun = oyun;
		
		kDown[0] = false;    //Daha seri hareket edebilmek için
		kDown[1] = false;
		kDown[2] = false;
		kDown[3] = false;
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for (int i = 0 ; i < kontrol.obje.size() ; i++) {
			OyunObje gn = kontrol.obje.get(i);
			
			
			if (gn.getId() == ID.Player) {
				//birinci oyuncu hareketleri
				
				if(key == KeyEvent.VK_W) {gn.setVelY((int)-kontrol.hýz); kDown[0]=true; }  //Market classýnda editleyebilmek için kontrolden türettik.
				if(key == KeyEvent.VK_S) {gn.setVelY((int)kontrol.hýz);   kDown[1]=true; }
				if(key == KeyEvent.VK_D) {gn.setVelX((int)kontrol.hýz);   kDown[2]=true; }
				if(key == KeyEvent.VK_A) {gn.setVelX((int)-kontrol.hýz);  kDown[3]=true; }	//1 birim hareket etttirmek için
			}
		
			/*if (gn.getId() == ID.Player2) {
		
				if(key == KeyEvent.VK_UP) gn.setVelY(-5);
				if(key == KeyEvent.VK_DOWN) gn.setVelY(5);
				if(key == KeyEvent.VK_RIGHT) gn.setVelX(5);
				if(key == KeyEvent.VK_LEFT) gn.setVelX(-5);
			}*/
		}
		
		if (key == KeyEvent.VK_ESCAPE) System.exit(1);  // Esc ile oyundan çýkýþ.
		
		if (key == KeyEvent.VK_M) {
			if(Oyun.gameState == STATE.Game) Oyun.gameState = STATE.Market; //Markete eriþmemiz için
			else if(Oyun.gameState == STATE.Market) Oyun.gameState = STATE.Game;
		}
		if (key == KeyEvent.VK_P) {
			
			if(oyun.gameState == STATE.Game) {
				
			
			if(Oyun.paused) Oyun.paused= false;
			else Oyun.paused = true;
			}
		}
	
	}
	
	
	public void keyReleased(KeyEvent e) {
		
		int key = e.getKeyCode();
		
		for (int i = 0 ; i < kontrol.obje.size() ; i++) {
			OyunObje gn = kontrol.obje.get(i);
			
			
			if (gn.getId() == ID.Player) {
				//birinci oyuncu hareketleri
				
				if(key == KeyEvent.VK_W) kDown[0]=false;//gn.setVelY(0);
				if(key == KeyEvent.VK_S) kDown[1]=false;//gn.setVelY(0);		//Sürekli hareketi önlemek için
				if(key == KeyEvent.VK_D) kDown[2]=false;//gn.setVelX(0);		//Basýlý kalmamasý için 
			    if(key == KeyEvent.VK_A) kDown[3]=false;//gn.setVelX(0);
			
			
			//dikey hareket için
			    
			    if(!kDown[0] && !kDown[1]) gn.setVelY(0);  
			    
			 //yatay hareket için
			    
			    if(!kDown[2] && !kDown[3]) gn.setVelX(0);
			
			
			
			
			}
		
			/*if (gn.getId() == ID.Player2) {
		
				if(key == KeyEvent.VK_UP) gn.setVelY(0);
				if(key == KeyEvent.VK_DOWN) gn.setVelY(0);
				if(key == KeyEvent.VK_RIGHT) gn.setVelX(0);
				if(key == KeyEvent.VK_LEFT) gn.setVelX(0);
			}*/
		}
		
	}

}
