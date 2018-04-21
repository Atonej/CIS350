package escaperoom;

import java.awt.*;
import java.util.concurrent.*;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

/*************************************************
 * This is the reaction mini game that's a part of the escape room
 * 
 * @author Alex Bohr
 *
 *********************************************/

public class Reaction extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static boolean pass, fail;

	public void intro() {

		JOptionPane.showMessageDialog(null,
				"Ready to test your reaction time?" + "\n");
		JOptionPane.showMessageDialog(null,
				"Press the key that pops up and hit enter as fast as you can"
						+ "\n");
		JOptionPane.showMessageDialog(null,
				"Answer 10 in a row with an average of 2 seconds to escape.."
						+ "\n");
		JOptionPane.showMessageDialog(null,
				"Get an answer wrong or fail to answer " + "\n"
						+ "and your time is 2 seconds for that entry... "
						+ "\n");
	}

	public static void main(String[] arg) {
		new Reaction();
		// final JFrame frame = new R
		JOptionPane.showMessageDialog(null,
				"Congratulations. You may now move on..." + "\n");
	}

	public void playReact() {
		int attempts = 1;

		Random r = new Random();

		fail = true;
		pass = false;

		do {

			ScheduledExecutorService e = Executors
					.newScheduledThreadPool(1);
			int time = 0;
			String x = "Round " + attempts + ".." + "\n";

			if (attempts > 1) {
				JOptionPane.showInputDialog(
						"Not fast enough, get ready for " + x + "\n");
			} else {
				JOptionPane.showInputDialog(
						"Click enter to begin.." + "\n" + "\n");
			}

			if (fail == true) {

				for (int i = 0; i < 10; ++i) {

					String randLetter = Reaction.getLetter();
					String newLetter = randLetter;

					long s = System.currentTimeMillis();
					ScheduledFuture<?> f = e.schedule(
							() -> Window.getWindows()[0].dispose(), 6,
							TimeUnit.SECONDS);

					String inputLetter = JOptionPane
							.showInputDialog(x + "" + "\n"
									+ "                " + "         "
									+ " \" " + newLetter + " \" ");

					if ((newLetter).equals(inputLetter) && i == 9) {
						long t = System.currentTimeMillis() - s;
						x = "CORRECT: " + t + " milliseconds";
						time += t / 10;

						if (time <= 2000) {
							fail = false;
							pass = true;
						} else {
							fail = true;
							pass = false;
						}
					}

					else if ((newLetter).equals(inputLetter) != true
							&& i == 9) {
						long t = 3000;
						x = "INCORRECT: " + t + " milliseconds";
						time += t / 10;

						if (time <= 2000) {
							fail = false;
							pass = true;
						} else {
							fail = true;
							pass = false;
						}
					}

					else if ((newLetter).equals(inputLetter)) {
						long t = System.currentTimeMillis() - s;
						x = "CORRECT: " + t + " milliseconds" + "\n";
						time += t / 10;

					}

					else {
						long t = 3000;
						x = "INCORRECT: " + t + "milliseconds" + "\n";
						time += (t / 10);

					}

					f.cancel(true);

					try {
						Thread.sleep(r.nextInt(1700));
					} catch (InterruptedException ee) {
						ee.printStackTrace();
					}
				}
				attempts++;
				e.shutdown();
			}
			e.shutdown();
			JOptionPane.showMessageDialog(null,
					"Average Time: " + time + " milliseconds");

		} while (pass == false && fail == true);
	}

	public static String getLetter() {
		String[] alphabet = new String[] { "a", "b", "c", "d", "e", "f",
				"g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q",
				"r", "s", "t", "u", "v", "w", "x", "y", "z", "1", "2",
				"3", "4", "5", "6", "7", "8", "9" };

		String randomLetter = alphabet[(int) (Math.random()
				* alphabet.length)];
		return randomLetter;
	}
}
