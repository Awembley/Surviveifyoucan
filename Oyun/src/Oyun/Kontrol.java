package Oyun;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.LinkedList;

import Oyun.Oyun.STATE;

public class Kontrol {

	LinkedList<OyunObje> obje = new LinkedList<OyunObje>();
	
	
	Oyun oyun;
	public int boyut =32;
	public float h�z = 5 ;
	
	public void tick() {
		
		for(int i = 0; i < obje.size(); i++) {
			
			OyunObje gn = obje.get(i);
			gn.tick();
			
		}
		
	}
	
	public void render(Graphics g) {
		for(int i = 0; i < obje.size(); i++) {
			
			OyunObje gn = obje.get(i);
			gn.render(g);
			 
		}
	}
	
	public void D��manlar�Sil() {
		Iterator<OyunObje> it = this.obje.iterator();   //D��manlar� temizlemek i�ni kod 
		 while(it.hasNext()) {
		  OyunObje gn = it.next();
		  if(gn.getId() != ID.Player){
			 
				  it.remove();
			  
		  }
		  else if(oyun.gameState == STATE.Biti� ||  oyun.gameState == STATE.Kazan) {  //Oyun bitti�inde olu�an bugu �nlemek i�in
			  it.remove();
		  }
		  
		  
		  
		 }
		}
	
	
	public void objeEkle(OyunObje obje) {
		
		this.obje.add(obje);
	}
	
	public void objeSil(OyunObje obje) {
		
		this.obje.remove(obje);
	}
	
	
	
	
	
}
