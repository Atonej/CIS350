package escaperoom;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;




/***********************************************************************
 * This GUI class is the source for the runnable game that accesses
 * a room and a 4 mini games. 
 * 
 * @author Atone Joryman
 * @version Winter 2018
 *
 **********************************************************************/
public class EscapeRoomGameGUI extends JFrame implements ActionListener,
KeyListener, Runnable{
	
	
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

	private JButton backward;
	
	/** FORWARD directional button on panel **/
	private JButton forward;
	
	/** panel interface **/ 
	private JPanel panel;
	
	/** panel for buttons **/
	private JPanel buttonPanel;

	
	/**image instead of a button*/
	private RoomImages image;
	
	/** include all the graphics **/
	private MyGraphics graphic;
	
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

	private int x=1;

	private int y=1;

	private int xDirection;

	private int yDirection;

	private boolean game;

	private Image dbImage;

	private Graphics dbg;

	private JLabel label;

	private boolean dark;
	
	/*******************************************************************
	 * This constructor sets up the GUI for the escape room
	 * 
	 ******************************************************************/
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
		backward = new JButton("backward");
		forward = new JButton("forward");
		quit = new JMenuItem("Quit");
		file = new JMenu("File");
		
		menu = new JMenuBar();
		
		image = new RoomImages();
		graphic = new MyGraphics();
		
		//empty buttons
//		imageButton1 = new JButton();
//		imageButton2 = new JButton();
//		imageButton3 = new JButton();
//		imageButton4 = new JButton();
		
		//make sure there are action listeners for buttons
		right.addActionListener(this);
		left.addActionListener(this);
		backward.addActionListener(this);
		forward.addActionListener(this);
		
//		imageButton1.addActionListener(this);
//		imageButton2.addActionListener(this);
//		imageButton3.addActionListener(this);
//		imageButton4.addActionListener(this);

		
		//listen to keyboard actions
		addKeyListener(this);
		
		
		//set up menu
		file.add(quit);
		menu.add(file);
		
		//panel board
		panel.add(right);
		panel.add(left);
		panel.add(backward);
		panel.add(forward);
		
		//set specified layout 
		this.setLayout(new BorderLayout());
		this.setBackground(Color.BLUE);
		
		//add new panels to JFrame
		this.add(menu, BorderLayout.NORTH);
		this.add(panel, BorderLayout.SOUTH);
		this.add(buttonPanel, BorderLayout.CENTER);
		//this.add(graphic);
		//add(file);
		
		//allows use of keystrokes
		setFocusable(true);
		setVisible(true);
		setSize(800,700);
		
		
	}
	
	@Override
	public void run(){
        try{
            while(true){
                move();
                Thread.sleep(10);
            }
        }catch(Exception e){
            System.out.println("Uh-oh, something went wrong!.");
        }
    }

    private void move() {
        x += xDirection;
        y += yDirection;
        
    }

     public void setXDirection(int xdir) {
            this.xDirection += xdir;
        }

        public void setYDirection(int ydir) {
            this.yDirection += ydir;
        }
        
        
//        public void paint(Graphics g){
//            dbImage = createImage(getWidth(), getHeight());
//            dbg = dbImage.getGraphics();
//            paintComponent(dbg);
//            g.drawImage(dbImage, 0, 0, this);   
//
//        }

//        public void paintComponent(Graphics g){
//            //g.setColor(Color.red);
//            //g.fillRect(200, 190, 12, 20);
//            g.drawImage(image.getwalkImage(), 0, 0, this);
//            g.setColor(Color.red);
//
//
//
//            repaint();
//        }
	
	/***********************************************************************
	 * This main class will start up the GUI inside the program
	 **********************************************************************/
	public static void main (String[] args) {
		//new mainPanel();
		
		final JFrame frame = new EscapeRoomGameGUI();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		frame.setVisible(true);
		
//		SwingUtilities.invokeLater(new Runnable() {
//
//			@Override
//			public void run() { //make visible
//				frame.setVisible(true);
//			}
//		});
//	
	}

	
	
	
	


/*
 * (non-Javadoc)
 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
 */
	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == right) {
			//use an url for the undo button
			

//put decided image to go to button
imageButton1 = new JButton(image.getGame1());
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
			

			imageButton2 = new JButton(image.gameImage("Hangman"));
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
		
		
		if(e.getSource() == backward) {
			
			imageButton3 = new JButton(image.gameImage("DuelingGame"));
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
			DuelingGame d = new DuelingGame();
			d.buildGUI();
			
		}
		
		
		if(e.getSource() == forward) {
			
			imageButton4 = new JButton(image.getGame4());
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
	
	
	/*******************************************************************
	* method to react to key being typed must implement/no code needed
	*******************************************************************/
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
	
	/***********************************************************************
	* method to react to key being pressed must implement/no code needed
	***********************************************************************/
	@Override
	public void keyPressed(KeyEvent e) {
	
	}

	/***********************************************************************
	* method to react to key being released
	***********************************************************************/
	@Override
	public void keyReleased(KeyEvent e) {
		
		//hint to self check to see if key is still listening
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			
			if(game) {
			imageButton1 = new JButton(image.getGame1());
			imageButton1.addActionListener(this);
			imageButton1.setFocusable(false);

		       
			buttonPanel.removeAll();
			buttonPanel.add(imageButton1);
			
			}
			
			else if(!dark) {
				setXDirection(-1);
				image.setwalkImage(yDirection);
				if(image.getwalkImage() == null) {
					JOptionPane.showMessageDialog(this, "Cannot Go Left");
					return;
				}
				label = new JLabel(image.getwalkImage());
				buttonPanel.removeAll();
				buttonPanel.add(label);

				}
						
						revalidate();
						repaint();			
		}  if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			
			if(game) {
			imageButton2 = new JButton(image.gameImage("Hangman"));
			imageButton2.addActionListener(this);
			imageButton2.setFocusable(false);

   
			buttonPanel.removeAll();
			buttonPanel.add(imageButton2);
			}
			
			else if(!dark) {
				setXDirection(+1);
				image.setwalkImage(yDirection);
				if(image.getwalkImage() == null) {
					JOptionPane.showMessageDialog(this, "Cannot Go Right");
					return;
				}
				label = new JLabel(image.getwalkImage());
				buttonPanel.removeAll();
				buttonPanel.add(label);

				}	
						
						revalidate();
						repaint();
			
		}  
		//backwards
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			
			if(game) {
			imageButton3 = new JButton(image.gameImage("DuelingGame"));
			imageButton3.addActionListener(this);
			imageButton3.setFocusable(false);

   
			buttonPanel.removeAll();
			buttonPanel.add(imageButton3);
			}
			else if(!dark) {
			setYDirection(-1);
			image.setwalkImage(yDirection);
			if(image.getwalkImage() == null) {
				JOptionPane.showMessageDialog(this, "Cannot Go Backward");
				return;
			}
			label = new JLabel(image.getwalkImage());
			buttonPanel.removeAll();
			buttonPanel.add(label);

			}			
						revalidate();
						repaint();
			
		}  
		//forward
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			
			if(game) {
			imageButton4 = new JButton(image.getGame4());
			imageButton4.addActionListener(this);
			imageButton4.setFocusable(false);

			
			buttonPanel.removeAll();
			buttonPanel.add(imageButton4);
			}
			
			else if(!dark) {
			setYDirection(+1);
			//System.out.println("before: " + yDirection);
			image.setwalkImage(yDirection);
			if(image.getwalkImage() == null) {
				JOptionPane.showMessageDialog(this, "Cannot Go Forward");
				return;
			}
			label = new JLabel(image.getwalkImage());
			buttonPanel.removeAll();
			buttonPanel.add(label);

			}			
						revalidate();
						repaint();
			
		}
	}

	
}
