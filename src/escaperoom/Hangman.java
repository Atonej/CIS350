package escaperoom;

import java.io.IOException;

/******************************************************************
 * This program will run a screen of hangman where the user guesses 
 * a word
 * @author Atone Joryman
 * @version Winter 2018
 *******************************************************************/
public class Hangman {

	protected char choice;	
	String s = "";
	String stringChoice;

	char word[] = new char[10]; // random char
	char user[] = new char[1]; //point to user input
	int num=0;
	int i;
	int j;
	int attempt;
	String randWord;
	String separate;
	char progress[] = new char[10]; //character arrays, progress 
	//of game and wrong characters
	char showWrong[]= new char [10];
	char replace[] = new char [10];
	int isWon = 0, isLost = 0, correctGuess = 0, wrongGuesses = 0, added=0;
	/*****************************************************************
	 * constructor method to build the game
	 * @return 
	 *****************************************************************/
	public void hangmanGame()  // game of hangman, enter letter and receive word
	{
		randWord = getword();//point the variable to the randomized word
		
		separate = randWord;



		num = separate.length();
		//separate= randWord;


		System.out.println(randWord); //make sure I am randomizing words  */

		System.out.println("\nYour word is " + num +" characters long");

		//put empty spaces as wrong letters/
		for(i=0; i<10; i++)
		{
			showWrong[i] = ' ';
		}

		for(i=0; i<num+1; i++)
		{
			replace[i] = '*';//enter asteriks for empty characters

		}
		
		s = ("\t\t\t   ==============     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") +
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") + 
				("\t\t\t   ||          ||     \n") +
				("\t\t\t   ,,,,,,,,,,,,,,     \n");
	}

	/*****************************************************************
	 * method to determine whether or not you're guess was correct
	 * sets the string as hangman or as you're progress
	 * @param string
	 * @return
	 *****************************************************************/

	public boolean correctGuess(String string) {
		String holder = "";
		boolean b = false;
		correctGuess = 0;
		added = 0;
		stringChoice = string;
		choice =  string.charAt(0);
		System.out.println("\nEnter a letter: ");



		for(i=0; i<num; i++) //Checking if any of the letters in the word match
		{

			if(randWord.charAt(i) == choice)
			{
				added=1;
				System.out.println("Correct\n"); //report results

				System.out.println("\n");
				System.out.println("\t\tYou have " +wrongGuesses +
						"wrong attempts\n");

				progress[i]= choice;
			
			

				if(added ==1){ //flag if enter user character to string

					replace[i]=choice;
					added=0;

				}

				s = ("Your progress: ");
				for(i=0; i<num; i++)  //place revealed letters
				{
					s += (replace[i]);

				}
				
				holder = s.replaceFirst("Your progress: ", "");

				
			
				
				
				if(randWord.equals(holder))
				{
					System.out.println("winner");
					isWon=2;
					s = ("\n\n\nYou have won the game!"
							+ "\nYour word was "+randWord+"\n\nPress any key "
							+ "to return to main screen");
			

					//					return isWon;
				}

				//indicate correct guess by changing flag
				correctGuess = 1;
				b = true;
			}
		}

		//determind false guess
		if(correctGuess !=1)
		{

			// use flag to indicate the guess was added to wrong guesses /

			if(added !=1)
			{
				showWrong[wrongGuesses]= choice;
				added = 1;
			}

			s = ("\nIncorrect Letters So Far: ");
			//loop through showWrong array/
			for(i=0; i<10; i++)
			{
				s += (showWrong[i]+ " ");
			}
			s += (" \n Wrong guess! Try again\n "
					+ "You made " +(wrongGuesses+1) + " wrong attempts "
					+ "be careful!!\n\n");
			wrongGuesses++;//add to the wrong guess
			s += wrong(wrongGuesses);//put into wrong function

			if(wrongGuesses==10)
			{
				s = ("\nYou got hangman!\n\n "
						+ "Press any key to return to main screen\n"
						+ "");
				isLost=1;
	
			}
			b = false;
		}
		return b;
	}



	/*******************************************************************
	 * getter method receive randomized word
	 * @return the chosen word
	 ******************************************************************/
	public String getword()
	{
		String[] arr2 = new String[] { "crocodile", "crocodile", "crocodile", 
				"crocodile", "horse", "camel", "monkey", "dolphin", 
				"sealion", "panther" };


		String randomName = arr2[(int) (Math.random() * arr2.length)];


		//return word in random spot from list
		return randomName;
	}




	/*******************************************************************
	 * display the hangman of the game, incremental
	 * 
	 * @param attempt
	 ******************************************************************/
	public String wrong(int attempt) //Used when guess is wrong to build the hangman
	{
		if(attempt>0)
		{

			s = ("\t\t\t   ==============     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") +
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") + 
					("\t\t\t   ||          ||     \n") +
					("\t\t\t   ,,,,,,,,,,,,,,     \n");
			
			if(attempt == 1)
			{
				s = ("\t\t\t   ==============     \n") + 
						("\t\t\t   ||     |    ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") +
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") + 
						("\t\t\t   ||          ||     \n") +
						("\t\t\t   ,,,,,,,,,,,,,,     \n");
				System.out.println(s);

			}

			if(attempt == 2)
			{
				s = ("\t\t\t   ==============     \n")
						+("\t\t\t   ||     |    ||     \n")
						+("\t\t\t   ||     1    ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ||          ||     \n")
						+("\t\t\t   ,,,,,,,,,,,,,,     \n");

			}

			if(attempt == 3)
			{
				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");


			}

			if(attempt == 4)
			{
				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");

			}

			if(attempt == 5)
			{
				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");

			}

			if(attempt == 6)
			{

				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");

			}
			if(attempt == 7)
			{
				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");

			}
			if(attempt == 8)
			{

				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");

			}
			if(attempt == 9)
			{
				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");


			}
			if(attempt == 10)
			{
				s = ("\t\t\t   ==============     \n")
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
						+ ("\t\t\t   ,,,,,,,,,,,,,,     \n");

			}
		}
		return s;
	}

	
	/****************************************************************
	 * getter method to return the string to the gui 
	 * @return
	 *****************************************************************/
	public String getBoard() {
		return s;
	}


}