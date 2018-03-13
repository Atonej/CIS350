package adventuregame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;

public class DialogHangman extends JDialog implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JButton play;
	private JButton help;
	private JButton quit;
	
	private JPanel dialog;

	DialogHangman(){
		dialog = new JPanel();
		
		play = new JButton("Play");
		help = new JButton("Help");
		quit = new JButton("Quit");
		
		play.addActionListener(this);
		help.addActionListener(this);
		quit.addActionListener(this);
		
		dialog.add(play);
		dialog.add(help);
		dialog.add(quit);
		
		
		add(dialog);
		setSize(500,500);
		setVisible(true);
		setResizable(true);

	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
