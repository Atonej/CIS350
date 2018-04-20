package escaperoom;
//import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;

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
	private ArrayList<Integer> left;
	private ArrayList<Integer> right;
	private ArrayList<Integer> forward;
	private ArrayList<Integer> backward;
//	private int lavail;
//	private int ravail;
//	private int favail;
//	private int bavail;

	private ImageIcon walk;

	private File pic;
	private File dark[];

	private boolean pass;
	protected boolean up;

	/*******************************************************************
	 * constructor method for the room images
	 ********************************************************************/
	RoomImages(){
		//determine what is a direction
		left = new ArrayList <Integer>(MAX);// {50,5,0,0,0,0,0};
		right = new  ArrayList <Integer>(MAX);//{4,30,49,52};
		forward= new ArrayList <Integer>(MAX); //{1,2,3,43};
		backward= new ArrayList <Integer>(MAX); //{23,35,37};
		
		//left.addAll(Arrays.asList(10));

		right.addAll(Arrays.asList(4,9));
		for (int i = 1; i <= 200; i++)
		{
		   forward.add(i);
		}
		//forward.addAll(Arrays.asList(1,2,3,5,6,7,8,43));
	}

	/*******************************************************************
	 * This method will get noticed when the mini-game wall is chosen
	 * @param game what game you are playing
	 * @return an image of that game
	 ******************************************************************/
	public ImageIcon gameImage(String game) {
		if(game.equals("Hangman"))
			return	getGame2();
		if(game.equals("DuelingGame"))
			return	getGame3();
		if(game.equals("Reaction"))
			return getGame1();
			
		return null;
		
	}
	
	/*******************************************************************
	 * This method will get noticed when the user is moving
	 * @param walk the direction that you are going to 
	 * @return string of the walking direction 
	 ******************************************************************/
	public String setwalkImage(int walk) {
		System.out.println(walk);
		String str= "";
		pic = null;
			condition(walk);
		for(int i = 0; i < forward.size()-1; i++ ) {
			if(walk <0) {
				return str;
			}
			if(left.contains(walk)) {
				pass =true;
				str = "left";				
			}
			else if(right.contains(walk)) {
				pass =true;
				str = "right";				

			}
			else if(forward.contains(walk)) {
				pass =true;
				str = "forward";	
				
				//backward available
				//backward.add(walk);
			}	
				
			else if(backward.contains(walk)) {
				pass =true;
				str = "backward";				

			}
		
			
			
			
//			else {
//				throw new IllegalArgumentException("Cannot find int");
//			}
			
		//int passed to increment through
		if(pass) {
		if(walk<10) {
			   pic = new File("src/00"+ Integer.toString(walk)+ ".jpg");
			}
		else if(walk<100) {
			   pic = new File("src/0"+ Integer.toString(walk) + ".jpg");
			}
		else if(walk<200){
		   pic = new File("src/"+ Integer.toString(walk) + ".jpg");
		}
		
//		else if(ravail>0) {
//			   pic = new File("src/"+ right.get(ravail) + ".jpg");
//	
//		}
			
		pass = false;
		break;
		}
		
		}
		
		
		
		
//		 if(!pic.isFile()){
//			//tell game not possible 
//			this.walk  = null;
//			return null;
//		}
		
		System.out.println(pic.getName());

		try
		{	//use an url for the undo button
		    this.walk = new ImageIcon(ImageIO.read(
		            pic));
		}
		catch(MalformedURLException mue)
		{	//error of form to frame
		    mue.printStackTrace();
			this.walk  = null;
			str = null;

		}
		catch(IOException ioe)
		{	//can't print
			this.walk  = null;
			str = null;

		    //ioe.printStackTrace();
		}
		
		return str; 
		
	}
		
	
	public ImageIcon getwalkImage() {
		//Image w = new Image(walk);
		//return walk.getImage();
		return walk;
	}

	/*********************************************************************
	 * This will show the room with the lights off
	 * @param num that image is
	 * @return image icon of the room 
	 ********************************************************************/
	public ImageIcon darkRoom(int num) {
		File pic = new File("src/DuelingGame.jpg");
		
		dark = new File[10];
		for( int i = 1; i< dark.length; i++) {
		    pic = new File("src/dark"+ Integer.toString(i) +".jpg");
		    dark[i] = pic;
		}
		try
		{	//use an url for the undo button
		    walk = new ImageIcon(ImageIO.read(
		            dark[num]));
		}
		catch(MalformedURLException mue)
		{	//error of form to frame
		    mue.printStackTrace();
		}
		catch(IOException ioe)
		{	//can't print
		    ioe.printStackTrace();
		}
		return this.walk;
	}
	
	
	/*******************************************************************
	 * gives the name of the image you need
	 * @param name of the image
	 * @return an image that you walked to 
	 ********************************************************************/
	public ImageIcon giveName(String name) {
		File pic = new File("src/"+name+".jpg");
		try {
			walk = new ImageIcon(ImageIO.read(pic));
		} catch (IOException e) {
			walk = null;
		}
		return this.walk;
	}
	
	/*********************************************************************
	 * keep up with all the conditions for the pictures
	 * @param walk attached to walking
	 ********************************************************************/
	public void condition(int walk) {
//			if(w)) {
//				favail ++;
//				forward.addAll(Arrays.asList("001","002","003","005","006","007","008","043"));
//			}
			if(walk == 19)
				
			if(walk ==10)
				left.add(11);
			if(walk == 8)
				left.add(10);
		
	}
	/*******************************************************************
	 * Getter method for first game
	 * @return game1 image of the game you hit
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
	 * @return image of the game 2
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
	 * @return image of game 3
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
	 * @return image of game 4
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