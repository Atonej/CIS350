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

	private static final int MAX =200 ;
	private int left[];
	private ImageIcon right[];
	private ImageIcon forward[];
	private ImageIcon backward[];

	private ImageIcon walk;

	private File pic;

	RoomImages(){
		//determine what is a direction
		left = new int[MAX];
		right = new ImageIcon[MAX];
		forward= new ImageIcon[MAX];
		backward= new ImageIcon[MAX];
		
	}

	/*******************************************************************
	 * This method will get noticed when the mini-game wall is chosen
	 * @param game
	 * @return
	 ******************************************************************/
	public ImageIcon gameImage(String game) {
		if(game.equals("Hangman"))
			return	getGame2();
		if(game.equals("DuelingGame"))
			return	getGame1();
			
		return null;
		
	}
	
	/*******************************************************************
	 * This method will get noticed when the user is moving
	 * @param walk
	 * @return
	 ******************************************************************/
	public void setwalkImage(int walk) {
		
		pic = null;
		//int passed to increment through
		if(walk <10) {
			   pic = new File("src/00"+ Integer.toString(walk) + ".jpg");
			}
		else if(walk <100) {
			   pic = new File("src/0"+ Integer.toString(walk) + ".jpg");
			}
		else if(walk <200) {
		   pic = new File("src/"+ Integer.toString(walk) + ".jpg");
		}
		
		
		else if(!pic.isFile()){
			//tell game not possible 
			this.walk  = null;
			return;
		}
		
		System.out.println(pic.getName());

		try
		{	//use an url for the undo button
		    this.walk = new ImageIcon(ImageIO.read(
		            pic));
		}
		catch(MalformedURLException mue)
		{	//error of form to frame
		    //mue.printStackTrace();
			this.walk  = null;

		}
		catch(IOException ioe)
		{	//can't print
		    ioe.printStackTrace();
		}
		
	}
	
	public ImageIcon getwalkImage() {
		//Image w = new Image(walk);
		//return walk.getImage();
		return walk;
	}

	public ImageIcon darkRoom() {
		File pic = new File("src/DuelingGame.jpg");
		
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
	 * Getter method for first game
	 * @return game1
	 ******************************************************************/
	public ImageIcon getGame1() {
File pic = new File("src/064.jpg");
		
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
	 * Getter method for hangman game
	 * @return
	 ******************************************************************/
	public ImageIcon getGame2() {
		File pic = new File("src/Hangman.jpg")	;
		
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
		
		
File pic = new File("src/DuelingGame.jpg");
		
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
	 * Getter method for fourth game
	 * @return
	 ******************************************************************/
	public ImageIcon getGame4() {
		File pic = new File("src/077.jpg");
		
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
