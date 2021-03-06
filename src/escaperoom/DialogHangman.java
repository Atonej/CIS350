package escaperoom;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

//import javax.sound.sampled.AudioFormat;
//import javax.sound.sampled.AudioInputStream;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JEditorPane;
//import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

/***
 * This Dialog class will run the hangman mini-game
 * 
 * @author Atone Joryman
 * @version Winter 2018
 */
public class DialogHangman extends JDialog
		implements ActionListener, KeyListener {

	/** for using files **/
	private static final long serialVersionUID = 1L;

	/** options on main menu **/
	private JButton play;
	private JButton help;
	private JButton quit;
	private JButton enter;

	/** hold information of game **/
	private JEditorPane description;
	private JEditorPane descriptionGuess;

	/** panel for dialog **/
	private JPanel dialog;
	private JPanel correctGuess;

	/** panel for all information **/
	private JPanel info;

	/** base code **/
	private Hangman hangman;

	/** display for input **/
	private JLabel input;

	/** allow for input entry **/
	private JTextField entry;

	/** check for entry **/
	// private boolean enter;

	/******************************************************************
	 * Constructor for the dialog game that sets up the interface
	 ******************************************************************/
	DialogHangman() {

		// declaring
		dialog = new JPanel();
		correctGuess = new JPanel();
		info = new JPanel();
		hangman = new Hangman();

		// which button
		play = new JButton("Play");
		help = new JButton("Help");
		quit = new JButton("Quit");
		enter = new JButton("Enter");

		description = new JEditorPane();
		descriptionGuess = new JEditorPane();
		input = new JLabel("Enter Here");
		entry = new JTextField("Enter");

		play.addActionListener(this);
		help.addActionListener(this);
		quit.addActionListener(this);
		enter.addActionListener(this);

		addKeyListener(this);

		// add to dialog part of the frame
		dialog.add(play);
		dialog.add(help);
		dialog.add(quit);
		dialog.add(enter);

		// add to JFrame
		add(dialog, BorderLayout.SOUTH);
		add(info, BorderLayout.CENTER);
		add(correctGuess, BorderLayout.EAST);

		// display description
		description(0);

		// addKeyListener(this);
		// set window
		setSize(700, 700);
		setVisible(true);
		setResizable(true);
		setFocusable(true);
		help.setFocusable(false);
		play.setFocusable(false);

		// AudioInputStream audioInputStream =
		// AudioSystem.getAudioInputStream(soundFile.wav file);
		// AudioInputStream audioInputStream2 =
		// AudioSystem.getAudioInputStream(soundFile2.wav file);
		// AudioFormat audioFormat = audioInputStream.getFormat();
		// AudioFormat audioFormat2 = audioInputStream2.getFormat();

		entry.addKeyListener(new KeyListener() {

			@Override
			public void keyPressed(KeyEvent arg0) {

				if (arg0.getKeyCode() == 69) {
					hangman.correctGuess(entry.getText());
					if (hangman.correctGuess(entry.getText()) == false)
						description.setText(hangman.getBoard());
					else
						descriptionGuess.setText(hangman.getBoard());
				}

			}

			/*******************************************************************
			 * method to react to key being typed must implement/no code needed
			 *******************************************************************/
			@Override
			public void keyReleased(KeyEvent arg0) {
			}

			/*******************************************************************
			 * method to react to key being typed must implement/no code needed
			 *******************************************************************/
			@Override
			public void keyTyped(KeyEvent arg0) {
			}

		}

		);

	}

	/**********************************************************************
	 * the method will get current game information then display main menu and
	 * options
	 * 
	 * @param result
	 *            number attached to hangman
	 ********************************************************************/
	public void description(int result) // description leading into 3 choices
	{
		// char choice;
		// Scanner scanner = new Scanner(System.in);

		String last = lastgame(result); // show the last game

		description.setText("Welcome to the game of Hangman!"
				+ "\n_______________________________\n"
				+ "\nFrom the People who put you in \nthis room\n"
				+ "***********************"
				+ "\nYour Last Game Played:\n\n" + last
				+ "------------------------\n\n"
				+ "Main Menu Options are" + " below " + ""
				+ "\n\n------------------------\n");
		// choice = scanner.nextLine();

		// add data into info panel
		info.add(input);
		info.add(entry);

		descriptionGuess.setText("Take a guess!");

		correctGuess.add(descriptionGuess);

		// TODO not actually empty with text already inside
		if (entry.getText().isEmpty()) // invalid character used
		{

			JOptionPane.showMessageDialog(null, "\n<ERROR: Please enter"
					+ " a valid response>\n\n\n");
			// main();
		}
		// not text that should be edited
		description.setEditable(false);
		description.setPreferredSize(new Dimension(300, 500));

		descriptionGuess.setEditable(false);
		descriptionGuess.setPreferredSize(new Dimension(300, 500));

		info.add(description);

	}

	/*********************************************************************
	 * This method will catch the last game occured
	 * 
	 * @param result
	 *            attached to the last game
	 * @return string if you won or not
	 ********************************************************************/
	public String lastgame(int result) // return the results of last game
	{
		if (result == 1) {
			return ("You lost the game.\n");

		} else if (result == 2) {
			return "You won the game.\n";

		} else {
			return "No game was played\n";
		}
	}

	/*******************************************************************
	 * display the help description
	 ******************************************************************/
	public void help_menu_main() {
		description.setText("If you would like to play the game hit the"
				+ " P character, if you do not want to play hit the Q "
				+ "key.\n" + "This program is not key sensitive, but "
				+ "choose one of the 3 options shown on the main menu."
				+ "\n\n" + "Press any key to continue");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == play) {
			// play game

			hangman.hangmanGame();
			description.setText(hangman.getBoard());

		}

		if (e.getSource() == enter) {
			hangman.correctGuess(entry.getText());
			if (hangman.correctGuess(entry.getText()) == false)
				description.setText(hangman.getBoard());
			else
				descriptionGuess.setText(hangman.getBoard());
		}

		// help button
		if (e.getSource() == help) {
			// help directions
			// reset the screen by removing elements on panel
			// info.removeAll();

			help_menu_main();

		}

		// quit button
		if (e.getSource() == quit) {
			// quit out the console

			// system("cls");
			// clearScreen();
			description.setText("\nPlease come again!!\n\n\n");
			// close dialog
			dispose();

		}

	}

	/**********************************************************************
	 * main method to run this dialog alone
	 ********************************************************************/
	public static void main() {
		JDialog d = new DialogHangman();
		d.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		d.setResizable(true);
	}

	/*******************************************************************
	 * method to react to key being pressed
	 * 
	 * @param arg0
	 *            being the key event
	 *******************************************************************/
	@Override
	public void keyPressed(KeyEvent arg0) {

		if (arg0.getKeyCode() == 80) {
			hangman.hangmanGame();
			description.setText(hangman.getBoard());
		}
		if (arg0.getKeyCode() == 72) {
			help_menu_main();
		}
		if (arg0.getKeyCode() == 81) {
			description.setText("\nPlease come again!!\n\n\n");
			// close dialog
			dispose();
		}
		if (arg0.isMetaDown()) {
			if (arg0.getKeyCode() == 90) {
				hangman.hangmanGame();
				description.setText("Welcome to the game of Hangman!"
						+ "\n_______________________________\n"
						+ "\nFrom the People who put you in \nthis room\n"
						+ "***********************"
						+ "------------------------\n\n"
						+ "Main Menu Options are" + " below " + ""
						+ "\n\n------------------------\n");
			}
		}

	}

	/*******************************************************************
	 * method to react to key being typed must implement/no code needed
	 * 
	 * @param e
	 *            being the key event
	 *******************************************************************/
	@Override
	public void keyTyped(KeyEvent e) {
		// not used

	}

	/*******************************************************************
	 * method to react to key being typed must implement/no code needed
	 * 
	 * @param e
	 *            being the key event
	 *******************************************************************/
	@Override
	public void keyReleased(KeyEvent e) {
		// not used

	}

}