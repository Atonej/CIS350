package escaperoom;

import java.util.Random;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.event.*;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

// Change the name of this class after it has been completed
public class Dueling implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Random rand = new Random();
	boolean win, tie;
	//String instructions = "rules rules rules";
	
	JFrame frame;
	JPanel panel;
	JMenuBar menu;
	JMenu file;
	JMenuItem quit;
	JButton go;
	JTextField input;
	JTextField result;
	JTextArea rules;
	
	public void play(){
		String move = input.getText();
		String ai;
		int aiNum = rand.nextInt(3);
		if (aiNum == 0){
			ai = "Grass";
		}
		else if (aiNum == 1){
			ai = "Fire";
		}
		else if (aiNum == 2){
			ai = "Water";
		}
		else{
			ai = "Wrong";
		}
		if (move == ai){
			tie = true;
		}
		if (move == "Grass"){
			if (ai == "Fire"){
				win = false;
			}
			else if (ai == "Water"){
				win = true;
			}
		}
		if (move == "Fire"){
			if (ai == "Water"){
				win = false;
			}
			else if (ai == "Grass"){
				win = true;
			}
		}
		if (move == "Water"){
			if (ai == "Grass"){
				win = false;
			}
			else if (ai == "Fire"){
				win = true;
			}
		}
		else{
			win = true;
		}
	}
	
	public void buildGUI(){
		// Building all of our components
		menu = new JMenuBar();
		file = new JMenu("File");
		quit = new JMenuItem("quit");
		
		quit.addActionListener(this);
		file.add(quit);
		menu.add(file);
		
		go = new JButton("Attack!");
		go.addActionListener(this);
		
		input = new JTextField("");
		input.setColumns(20);
		result = new JTextField("");
		result.setColumns(20);
		rules = new JTextArea("rules");
		
		frame = new JFrame("Dueling Game");
		frame.setDefaultCloseOperation(frame.EXIT_ON_CLOSE);
		panel = new JPanel(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		
		c.gridx = 1;
		c.gridy = 1;
		panel.add(rules, c);
		
		c.gridy = 2;
		panel.add(input, c);
		
		c.gridy = 3;
		panel.add(go, c);
		
		c.gridy = 4;
		panel.add(result, c);
		
		frame.add(panel);
		
		frame.setJMenuBar(menu);
		frame.pack();
		frame.setVisible(true);
	}
	
	public void actionPerformed(ActionEvent e){
		Object w = e.getSource();
		if (w == quit){
			System.exit(1);
		}
		if (w == go){
			play();
			updateUI();
		}
	}
	
	public void updateUI(){
		if (win){
			result.setText("You did it");
		}
		else{
			result.setText("Honey, you've got a big storm coming");
		}
		if (tie){
			result.setText("Tie");
		}
	}
	
	public static void main(String[] args){
		Dueling d = new Dueling();
		d.buildGUI();
	}
	
}
