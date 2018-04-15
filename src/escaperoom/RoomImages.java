package escaperoom;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
/***********************************************************************
 * This class will run display the pictures of the entire game room
 * 
 * @author Atone Joryman
 * @version Winter 2018
 **********************************************************************/
public class RoomImages {
	/**images for games **/
	private ImageIcon game1;
	
	private ImageIcon game2;

	private ImageIcon game3;

	private ImageIcon game4;



	RoomImages(){
		
	}

	/*******************************************************************
	 * This method will get noticed when the mini-game wall is chosen
	 * @param game
	 * @return
	 ******************************************************************/
	public Image gameImage(String game) {
		return null;
		
	}

	/*******************************************************************
	 * Getter method for first game
	 * @return game1
	 ******************************************************************/
	public ImageIcon getGame1() {
		File pic = new File("src/image1-1.jpeg");
		
		try
		{	//use an url for the undo button
		    game1 = new ImageIcon(ImageIO.read(
		            pic));
		}
		catch(MalformedURLException mue)
		{	//error of form to frame
		    mue.printStackTrace();
		}
		catch(IOException ioe)
		{	//can't print
		    ioe.printStackTrace();
		}
		return game1;
	}
	


	/*******************************************************************
	 * Getter method for hangman game
	 * @return
	 ******************************************************************/
	public ImageIcon getGame2() {
		File pic = new File("src/image1.jpeg")	;
		
		try
		{	//use an url for the undo button
		    game2 = new ImageIcon(ImageIO.read(
		            pic));
		}
		catch(MalformedURLException mue)
		{	//error of form to frame
		    mue.printStackTrace();
		}
		catch(IOException ioe)
		{	//can't print
		    ioe.printStackTrace();
		}
		return game2;
	}


	/*******************************************************************
	 * Getter method for dueling game
	 * @return
	 ******************************************************************/
	public ImageIcon getGame3() {
		File pic = new File("src/IMG_0061.jpg");
		
		try
		{	//use an url for the undo button
		    game3 = new ImageIcon(ImageIO.read(
	            pic));
		}
		catch(MalformedURLException mue)
		{	//error of form to frame
		    mue.printStackTrace();
		}
		catch(IOException ioe)
		{	//can't print
		    ioe.printStackTrace();
		}
		return game3;
	}



	/*******************************************************************
	 * Getter method for fourth game
	 * @return
	 ******************************************************************/
	public ImageIcon getGame4() {
		File pic = new File("src/IMG_0063.jpg");
		
		try
		{	//use an url for the undo button
		    game4 = new ImageIcon(ImageIO.read(
		            pic));
		}
		catch(MalformedURLException mue)
		{	//error of form to frame
		    mue.printStackTrace();
		}
		catch(IOException ioe)
		{	//can't print
		    ioe.printStackTrace();
		}
		return game4;
	}


}
