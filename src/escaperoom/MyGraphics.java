package escaperoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * This class handles all the graphics of the program
 * @author Atone Joryman
 * @version Winter 2018
 */
public class MyGraphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y = 300;
	
	private Graphics2D graphic;

	// TODO: use a separate graphics class to change the default 
	// GUI look
	
	MyGraphics(){
		
	}
	

	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		
		Font font = new Font("Tahoma", Font.BOLD + Font.PLAIN, 50);
		
		g2D.setFont(font);
		g2D.setColor(Color.RED);
		graphic = g2D;
		header(0);
		
		
		repaint();
		
		
	}
	
	/**
	 * Give the header to be displayed at a point at time 
	 * @param num which header to choose
	 * @return
	 */
	public void header(int num) {
		if(num == 0) {
			this.setSize(100,100);
	//		graphic.drawString("Welcome", x, y);
			
//			try {
//				Thread.sleep(100);
//			} catch (Exception e){
//				e.printStackTrace();
//			}
			
			x = x+10;
			
			if(x> this.getWidth()) {
				x =0;
			}

		}
					
	}
}
