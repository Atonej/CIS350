package escaperoom;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class HangmanTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testWrong1() {
		Hangman h = new Hangman();
		h.wrong(1);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong2() {
		Hangman h = new Hangman();
		h.wrong(2);
		assertEquals(h.getBoard(),
				(("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n")));
	}

	@Test
	public void testWrong3() {
		Hangman h = new Hangman();
		h.wrong(3);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong4() {
		Hangman h = new Hangman();
		h.wrong(4);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||     3    ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong5() {
		Hangman h = new Hangman();
		h.wrong(5);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||     3    ||     \n")
						+ ("\t\t\t   ||    444   ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong6() {
		Hangman h = new Hangman();
		h.wrong(6);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||     3    ||     \n")
						+ ("\t\t\t   ||    444   ||     \n")
						+ ("\t\t\t   ||   5 5 5  ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong7() {
		Hangman h = new Hangman();
		h.wrong(7);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||     3    ||     \n")
						+ ("\t\t\t   ||    444   ||     \n")
						+ ("\t\t\t   ||   5 5 5  ||     \n")
						+ ("\t\t\t   ||    6 6   ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong8() {
		Hangman h = new Hangman();
		h.wrong(8);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||     3    ||     \n")
						+ ("\t\t\t   ||  5544455 ||     \n")
						+ ("\t\t\t   ||  5  5  5 ||     \n")
						+ ("\t\t\t   ||    6 6   ||     \n")
						+ ("\t\t\t   ||   7   7  ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong9() {
		Hangman h = new Hangman();
		h.wrong(9);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||     3    ||     \n")
						+ ("\t\t\t   ||    444   ||     \n")
						+ ("\t\t\t   ||  5544455 ||     \n")
						+ ("\t\t\t   ||  5  5  5 ||     \n")
						+ ("\t\t\t   ||   7   7  ||     \n")
						+ ("\t\t\t   ||  8     8 ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testWrong10() {
		Hangman h = new Hangman();
		h.wrong(10);
		assertEquals(h.getBoard(),
				("\t\t\t   ==============     \n")
						+ ("\t\t\t   ||     |    ||     \n")
						+ ("\t\t\t   ||     1    ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||    2 2   ||     \n")
						+ ("\t\t\t   ||     2    ||     \n")
						+ ("\t\t\t   ||     3    ||     \n")
						+ ("\t\t\t   ||    444   ||     \n")
						+ ("\t\t\t   ||  5544455 ||     \n")
						+ ("\t\t\t   ||  5  5  5 ||     \n")
						+ ("\t\t\t   ||   7   7  ||     \n")
						+ ("\t\t\t   ||  8     8 ||     \n")
						+ ("\t\t\t   || 9       9||     \n")
						+ ("\t\t\t   ||          ||     \n")
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n"));
	}

	@Test
	public void testHangman() {
		Hangman h = new Hangman();
		h.hangmanGame();
		assertNotNull(h.getBoard());

	}

	@Test
	public void testRandWord() {
		Hangman h = new Hangman();
		h.hangmanGame();
		assertNotNull(h.getword());
	}

	@Test
	public void testCorrectGuess() {
		Hangman h = new Hangman();
		h.hangmanGame();
		h.setRandword("monkey");
		assertTrue(h.correctGuess("e"));
	}

	@Test
	public void testWrongGuess() {
		Hangman h = new Hangman();
		h.hangmanGame();
		assertFalse(h.correctGuess("z"));
	}

	@Test
	public void test10wrong() {
		Hangman h = new Hangman();
		h.hangmanGame();
		h.correctGuess("z");
		h.correctGuess("b");
		h.correctGuess("f");
		h.correctGuess("g");
		h.correctGuess("j");
		h.correctGuess("q");
		h.correctGuess("t");
		h.correctGuess("u");
		h.correctGuess("v");
		h.correctGuess("x");
		assertEquals(h.getBoard(), ("\nYou got hangman!\n\n "
				+ "Press any key to return to main screen\n" + ""));

	}

}