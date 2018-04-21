package escaperoom;

import java.util.*;

/*
    A game of Mastermind.

    @author Henry McDonough
    @version 04-14-2018
 */
public class Mastermind {
	public static final int MASTERMIND_SIZE = 6;
	public static final int NUM_SYMBOLS = 8;

	/* An array containing the secret the player must guess. */
	private ArrayList<Character> secret;

	private int correct;
	private int partially_correct;
	private int guesses_used;

	/*
	 * Constructor for singleton mastermind object.
	 * 
	 * @return nothing
	 */
	public Mastermind() {
		Random rand = new Random();
		char nextSym;

		secret = new ArrayList<Character>();

		while (secret.size() < MASTERMIND_SIZE) {
			nextSym = "abcdefghijklm".charAt(rand.nextInt(NUM_SYMBOLS));
			if (secret.size() == 0 || !secret.contains(nextSym)) {
				secret.add(nextSym);
			}
		}

		java.util.Collections.shuffle(secret);
	}

	/*
	 * Takes a sequence of integers and returns whether or not it matches the
	 * secret.
	 * 
	 * @param guess some sequence of integers
	 * 
	 * @return whether or not it matches the secret
	 */
	public boolean guess(String guess) {
		guesses_used++;
		int correct = 0;
		int partially_correct = 0;
		this.correct = correct;
		this.partially_correct = partially_correct;

		for (int i = 0; i < MASTERMIND_SIZE; i++) {
			for (int j = 0; j < MASTERMIND_SIZE; j++) {
				if (i != j && guess.charAt(i) == guess.charAt(j)) {
					return false; /* All symbols must be unique! */
				}
			}

			if (guess.charAt(i) == secret.get(i)) {
				correct++;
			} else {
				for (int j = 0; j < MASTERMIND_SIZE; j++) {
					if (secret.get(j) == guess.charAt(i)) {
						partially_correct++;
					}
				}
			}
		}

		this.correct = correct;
		this.partially_correct = partially_correct;

		return correct == MASTERMIND_SIZE;
	}

	/*
	 * Prints report based on the number of correct and partially correct
	 * 
	 * @param a message
	 */
	private void report(String guess) {
		String report = "Guess: " + guess;

		report += " (" + this.correct + " correct, " + partially_correct
				+ " partially correct)";

		System.out.println(report);
	}

	/* plays the game */
	private static void playGame() {
		Mastermind game = new Mastermind();
		System.out.println("Guess the code!");
		String input;

		Scanner scan = new Scanner(System.in);

		boolean skip = false;
		do {
			input = scan.nextLine();
			if (input.length() < MASTERMIND_SIZE) {
				input += "________";
			}

			input = input.substring(0, MASTERMIND_SIZE);
			for (int i = 0; i < input.length(); i++) {
				for (int j = 0; j < input.length(); j++) {
					if (input.charAt(i) == input.charAt(j) && i != j
							&& input.charAt(j) != '_') {
						System.out.println(
								"No repeated symbols, please!");
						skip = true;
						break;
					}
				}

				if (skip) {
					break;
				}
			}

			if (!skip) {
				game.guess(input);
				game.report(input);
			}

			skip = false;
		} while (!game.guess(input));

		System.out.println("You guess the code in " + game.guesses_used
				+ " guesses.");
	}

	public static void main(String[] args) {
		Mastermind.playGame();
	}
}
