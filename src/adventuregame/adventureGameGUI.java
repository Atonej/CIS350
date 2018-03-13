package adventuregame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;



public class adventureGameGUI extends JFrame implements ActionListener{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JMenuBar menu;
	private JMenu file;
	private JMenuItem quit;
	
	private JButton right;
	private JButton left;
	private JButton down;
	private JButton up;
	private JPanel panel;
	
	/**image instead of a button*/
	private ImageIcon image;
	Image img;
	Image img2;
	private JButton imageButton1;
	//private Image im;
	private JButton imageButton2;
	private JPanel buttonPanel;
	private JButton imageButton4;
	private JButton imageButton3;
	
	
	public adventureGameGUI() {//throws IOException{
		
		
	panel = new JPanel();
	buttonPanel = new JPanel();
	 // Image img = Toolkit.getDefaultToolkit().createImage("IMG_0061.jpg");
	  
//	    (() panel1).drawImage(background, 0, 0, null);
		
//		BufferedImage img2 = ImageIO.read(new File("IMG_0061.jpg"));
		
		
		right = new JButton("right");
		left = new JButton("left");
		down = new JButton("down");
		up = new JButton("up");
		quit = new JMenuItem("Quit");
		file = new JMenu("File");
		
		menu = new JMenuBar();
		
		
		
		
		right.addActionListener(this);
		left.addActionListener(this);
		down.addActionListener(this);
		up.addActionListener(this);
		
		
		
		file.add(quit);
		menu.add(file);
		
		panel.add(right);
		panel.add(left);
		panel.add(down);
		panel.add(up);
		
		this.setLayout(new BorderLayout());
		
		this.add(menu, BorderLayout.NORTH);
		this.add(panel, BorderLayout.SOUTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		//add(file);
		
		setVisible(true);
		setSize(800,700);
		
		
	}
	
	/***********************************************************************
	 * This main class will start up the GUI inside the program
	 **********************************************************************/
	public static void main (String[] args) {
		//new mainPanel();
		
		final JFrame frame = new adventureGameGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
	}

	
	
	
	
	
	public void paintComponent(Graphics g) {
		
		
		g.drawImage(img, 0, 0, null);
		g.drawImage(img2, 0, 0, null);
		
		
		
		
		
	}


	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == right) {
			//try
	       // {	//use an url for the undo button

			
			File url = new File("src/image1-1.jpeg");
			
try
{	//use an url for the undo button
    image = new ImageIcon(ImageIO.read(
            url));
}
catch(MalformedURLException mue)
{	//error of form to frame
    mue.printStackTrace();
}
catch(IOException ioe)
{	//can't print
    ioe.printStackTrace();
}

imageButton1 = new JButton(image);
imageButton1.addActionListener(this);
//imageButton1.setPreferredSize(new Dimension(400, 400));

	       	buttonPanel.removeAll();
			buttonPanel.add(imageButton1);
			
			revalidate();
			repaint();

		}
		
		if(e.getSource() == imageButton1) {
			//TODO: include the tictactoe game 
			
		}
		
		
		if(e.getSource() == left) {
			File url = new File("src/image1.jpeg")	;
			
			try
			{	//use an url for the undo button
			    image = new ImageIcon(ImageIO.read(
			            url));
			}
			catch(MalformedURLException mue)
			{	//error of form to frame
			    mue.printStackTrace();
			}
			catch(IOException ioe)
			{	//can't print
			    ioe.printStackTrace();
			}

			imageButton2 = new JButton(image);
			imageButton2.addActionListener(this);
			//imageButton1.setPreferredSize(new Dimension(400, 400));

			//remove the button then replace it
			
						//panel.remove(4);
						
			buttonPanel.removeAll();
			buttonPanel.add(imageButton2);
						
						revalidate();
						repaint();
						
						
		}
		
		if(e.getSource() == imageButton2) {
			new DialogHangman(); 
			
		}
		if(e.getSource() == down) {
			File url = new File("src/IMG_0061.jpg");
			
			try
			{	//use an url for the undo button
			    image = new ImageIcon(ImageIO.read(
			            url));
			}
			catch(MalformedURLException mue)
			{	//error of form to frame
			    mue.printStackTrace();
			}
			catch(IOException ioe)
			{	//can't print
			    ioe.printStackTrace();
			}

			imageButton3 = new JButton(image);
			imageButton3.addActionListener(this);
			//imageButton1.setPreferredSize(new Dimension(400, 400));

				       
			buttonPanel.removeAll();
			buttonPanel.add(imageButton3);
						
						revalidate();
						repaint();
			
		}
		
		if(e.getSource() == imageButton3) {
			//TODO: include the third game 
			
		}
		if(e.getSource() == up) {
			File url = new File("src/IMG_0063.jpg");
			
			try
			{	//use an url for the undo button
			    image = new ImageIcon(ImageIO.read(
			            url));
			}
			catch(MalformedURLException mue)
			{	//error of form to frame
			    mue.printStackTrace();
			}
			catch(IOException ioe)
			{	//can't print
			    ioe.printStackTrace();
			}

			imageButton4 = new JButton(image);
			imageButton4.addActionListener(this);
			//imageButton1.setPreferredSize(new Dimension(400, 400));
				       
			buttonPanel.removeAll();
			buttonPanel.add(imageButton4);
						
						revalidate();
						repaint();
		}
		
		if(e.getSource() == imageButton4) {
			//TODO: include the fourth game 
			
		}


		
	}
	
	
	
	
	
	
	
	

	
}
