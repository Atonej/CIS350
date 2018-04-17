package escaperoom;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;

import javax.swing.JPanel;

/**
 * This class handles all the graphics of the program
 * @author Atone Joryman
 * @version Winter 2018
 */
public class Graphics extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int x;
	private int y;
	
	private Graphics2D graphic;

	// TODO: use a separate graphics class to change the default 
	// GUI look
	
	Graphics(){
		
	}
	
	/**
	 * Give the header to be displayed at a point at time 
	 * @param num which header to choose
	 * @return
	 */
	public Graphics header(int num) {
		if(num == 0) {
			graphic.drawString("Welcome", x, y);

		}
			
		return null;
		
	}
	
	public void paintComponent(java.awt.Graphics g) {
		super.paintComponent(g);
		Graphics2D g2D = (Graphics2D)g;
		
		Font font = new Font("Tahoma", Font.BOLD + Font.PLAIN, 50);
		
		g2D.setFont(font);
		g2D.setColor(Color.RED);
		graphic = g2D;
		
		
		
		
		
	}
}
