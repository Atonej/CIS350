package escaperoom;

import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
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
import javax.swing.JOptionPane;
import javax.swing.JPanel;


/**
 * This GUI class is the source for the runnable game that accesses
 * a room and a 4 mini games. 
 * 
 * @author Atone Joryman
 * @version Winter 2018
 *
 */
public class EscapeRoomGameGUI extends JFrame implements ActionListener, KeyListener{
	
	
	/**	Used for files **/
	private static final long serialVersionUID = 1L;
	
	/** menu bar **/
	private JMenuBar menu;
	
	/** Drop down file option on menu bar **/
	private JMenu file;
	
	/** file option **/
	private JMenuItem quit;
	
	/** right directional button on panel **/
	private JButton right;
	
	/** left directional button on panel **/

	private JButton left;
	
	/** BACKWARD directional button on panel **/

	private JButton down;
	
	/** FORWARD directional button on panel **/
	private JButton up;
	
	/** panel interface **/ 
	private JPanel panel;
	
	/** panel for buttons **/
	private JPanel buttonPanel;

	
	/**image instead of a button*/
	private ImageIcon image;
	
	public Image img;
	public Image img2;
	
	/** screen for first mini-game **/
	private JButton imageButton1;
	//private Image im;
	/** screen for first mini-game **/
	private JButton imageButton2;
	
	/** screen for first mini-game **/
	private JButton imageButton4;
	
	/** screen for first mini-game **/
	private JButton imageButton3;
	
	/**
	 * This constructor sets up the GUI for the escape room
	 * 
	 */
	public EscapeRoomGameGUI() {//throws IOException{
		
	// new panels 	
	panel = new JPanel();
	buttonPanel = new JPanel();
	 // Image img = Toolkit.getDefaultToolkit().createImage("IMG_0061.jpg");
	  
//	    (() panel1).drawImage(background, 0, 0, null);
		
//		BufferedImage img2 = ImageIO.read(new File("IMG_0061.jpg"));
		
		//assignments to buttons
		right = new JButton("right");
		left = new JButton("left");
		down = new JButton("down");
		up = new JButton("up");
		quit = new JMenuItem("Quit");
		file = new JMenu("File");
		
		menu = new JMenuBar();
		
		
		
		//make sure there are action listeners for buttons
		right.addActionListener(this);
		left.addActionListener(this);
		down.addActionListener(this);
		up.addActionListener(this);
		
		//listen to keyboard actions
		addKeyListener(this);
		
		
		//set up menu
		file.add(quit);
		menu.add(file);
		
		//panel board
		panel.add(right);
		panel.add(left);
		panel.add(down);
		panel.add(up);
		
		//set specified layout 
		this.setLayout(new BorderLayout());
		
		//add new panels to JFrame
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
		
		final JFrame frame = new EscapeRoomGameGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
	}

	
	
	
	
	// TODO: use a separate graphics class to change the default 
	// GUI look
	public void paintComponent(Graphics g) {
		
		
		g.drawImage(img, 0, 0, null);
		g.drawImage(img2, 0, 0, null);
		
		
		
		
		
	}

/*
 * (non-Javadoc)
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
 */
	@Override
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

//put decided image to go to button
imageButton1 = new JButton(image);
imageButton1.addActionListener(this);
//imageButton1.setPreferredSize(new Dimension(400, 400));
			//remove all previous objects on panel
	       	buttonPanel.removeAll();
			buttonPanel.add(imageButton1);
			
			revalidate();
			repaint();

		}
		
		if(e.getSource() == imageButton1) {
			//TODO: include the car game

			
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
		
		//include hangman game 
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
		
		//dueling game
		if(e.getSource() == imageButton3) {
			//TODO: include the third game 
			Dueling d = new Dueling();
			d.buildGUI();
			
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
			//TODO: include the master mind game 
			
		}


		
	}
	
	
	/***********************************************************************
	* method to react to key being typed
	***********************************************************************/
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			JOptionPane.showMessageDialog(null, "Returning to main "
					+ "screen");
			  // description(0);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Please hit enter");
		}
	}
	
	/***********************************************************************
	* method to react to key being pressed
	***********************************************************************/
	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			JOptionPane.showMessageDialog(null, "Returning to main "
					+ "screen");
			  // description(0);
		}
		
		else {
			JOptionPane.showMessageDialog(null, "Please hit enter");
		}
	}

	/***********************************************************************
	* method to react to key being released
	***********************************************************************/
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getKeyCode());
		System.out.println(KeyEvent.VK_ENTER);

		if(e.getKeyCode() == KeyEvent.VK_ENTER) {
			JOptionPane.showMessageDialog(this, "Returning to main "
					+ "screen");
			  // description(0);
		}
		
		else {
			JOptionPane.showMessageDialog(this, "Please hit enter");
		}
	}

	
	

	
	
	
	

	
}
