package Oyun;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Ekran extends Canvas{

	private static final long serialVersionUID = 5026306309915443510L;
		
	public Ekran(int genislik,int yükselik,String Baþlýk,Oyun oyun) {
		
		JFrame frame = new JFrame(Baþlýk);
		
		frame.setPreferredSize(new Dimension(genislik,yükselik));
		frame.setMaximumSize(new Dimension(genislik,yükselik));
		frame.setMinimumSize(new Dimension(genislik,yükselik));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.add(oyun);
		frame.setVisible(true);
		oyun.start();
		
	}
}
