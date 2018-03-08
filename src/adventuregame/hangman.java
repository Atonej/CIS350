package adventuregame;

import java.io.IOException;

/******************************************************************
* This program will run a screen of hangman where the user guesses 
* a word
* @author Atone Joryman
* @version 2/25/2018
*******************************************************************/
public class hangman {

private char choice;	
	


	//main function to begin introduction
	void main()
	{

	    description(0); // function call to begin the rest of program

	}

	void description(int result)  //description leading into 3 choices
	{
	    //char choice;
        //Scanner scanner = new Scanner(System.in);

	    System.out.println("Welcome to the game of Hangman!");//welcome
	    System.out.println("\n_______________________________\n");
	    System.out.println("\nWritten By:\n\n");
	    System.out.println("Atone Joryman\n");
	    System.out.println("***********************");

	    System.out.println("\nYour Last Game Played:\n\n");
	    lastgame(result); //show the last game

	    System.out.println("------------------------\n\n");

	    System.out.println("Main Menu Options");
	    System.out.println("\n\n------------------------\n");
	    System.out.println("\nP:Play\n\nH:Help\n\nQ:Quit\n");
	    System.out.println("\n\n------------------------\n");
	    System.out.println("\nChoice:\t");
	    //choice = scanner.nextLine();
	    getch();

	    //choice=get(); //read choice from screen
	    //system("cls");//clear screen
	    


	    if(choice =='Q'|| choice == 'q')  //quit out the terminal
	    {
	        //system("cls");
	        System.out.println("\nPlease come again!!\n\n\n");
	        //exit(-1);
	    }
	    if(choice=='H'|| choice== 'h') //help directions
	    {
	        help_menu_main();

	    }
	    if(choice == 'P' || choice == 'p')  //play game
	    {
	    	
	        hangmanGame();

	    }
	    else   //invalid character used
	    {

	        System.out.println("\n<ERROR: Please enter a valid response>\n\n\n");
	        main();
	    }




	}
	 public int hangmanGame()  // game of hangman, enter letter and receive word
	{
	    char word[]; //point to the random word
	    word = new char[10];
	    char user[] = new char[1]; //point to user input
	    int num=0;
	    int i;
	    int j;
	    int attempt;

	    System.out.println("Welcome to the famous game of Hangman!\n");
	    System.out.println("I invite you to try and guess the word I am thinking.......\n");
	    System.out.println("You have 10 tries to be incorrect otherwise you continue into the next round and I show you the word!\n");
	    System.out.println("HINT: I happen to show a likeness to the biological life that's not humans\n");
	    System.out.println("However for each moment you are incorrect I draw a line that leads closer to a stick figure man");
	    System.out.println("\nGuess correctly you win! Guess incorrectly ten times, you get hangman!(YOU LOSE)\n\n");


	    String randWord = getword();//point the variable to the randomized word
	    String separate = randWord;

//	    while(*separate != '\0') // count number of letters in word
//	    {
//	        separate++;
//	        num++;
//	    }
	    
	    num = separate.length();
	    //separate= randWord;
	    char progress[] = new char[10]; //character arrays, progress of game and wrong characters
	    char showWrong[]= new char [10];
	    char replace[] = new char [10];

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



	//make flags for won, lost, correct & wrong guess and added guess
	    int isWon = 0, isLost = 0, correctGuess = 0, wrongGuesses = 0, added=0;

	    do
	    {

	        correctGuess = 0;
	        added =0;
	        System.out.println("\nEnter a letter: ");
	        
	        //user[0] = getch(); //get letter
	        getch();


	        for(i=0; i<num; i++) //Checking if any of the letters in the word match
	        {

	            if(randWord.charAt(i)== choice)
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

	                System.out.println("Your progress: ");
	                  for(i=0; i<num; i++)  //place revealed letters
	            {
	                System.out.println(replace[i]);
	            }
//	            int yes=1;
	//
//	            for (i = 0; i < num; i++) { // read comment by @nbro
//	    for ( j = i + 1; j < num; j++) {
//	        if (replace[i] == replace[j]) {
//	          printf("%c", replace[i]);
//	          yes=0;  // do whatever you do in case of a duplicate
//	        break;
//	        }
	//if(!yes)
	//printf("%c", replace[j]);
//	    break;
//	    }
	//
	//if(yes) {printf("%c", replace[i]); //if no duplicates
	//}
//	            }

	                if(randWord.equals(progress[i]))
	                {
	                    isWon=2;
	                    System.out.println("\n\n\nYou have won the game!"
	                    		+ "\nYour word was "+randWord+"\n\nPress any key "
	                    		+ "to return to main screen");
	                    getch();
	                    //revealWord(0);
	                    clearScreen();;
	                    //description(2);

	                    return isWon;
	                }

	                //indicate correct guess by changing flag
	                correctGuess = 1;

	            }
	        }

	        if(correctGuess !=1)
	        {

	            // use flag to indicate the guess was added to wrong guesses /

	            if(added !=1)
	            {
	                showWrong[wrongGuesses]= choice;
	                added = 1;
	            }

	            System.out.print("\nIncorrect Letters So Far: ");
	            //loop through showWrong array/
	            for(i=0; i<10; i++)
	            {
	                System.out.print(showWrong[i]+ " ");
	            }
	            System.out.println(" Wrong guess! Try again\n "
	            		+ "You made " +(wrongGuesses+1) + " wrong attempts "
	            				+ "be careful!!\n\n");
	            wrongGuesses++;//add to the wrong guess
	            wrong(wrongGuesses);//put into wrong function

	            if(wrongGuesses==10)
	            {
	                System.out.println("\nYou got hangman!\n\n "
	                		+ "Press any key to return to main screen\n"
	                		+ "");
	                getch();
	                isLost=1;
	                clearScreen();
	                description(1);


	                return isLost;
	            }
	        }

	//break out of loop if won or lost
	    }
	    while(isWon ==0 && isLost ==0);
		return -1;



	}


	void help_menu_main()
	{
	    System.out.println("If you would like to play the game hit the P character, if you do not want to play hit the Q key.\n");
	    System.out.println("This program is not key sensitive, but choose one of the 3 options shown on the main menu.\n\n");
	    System.out.println("Press any key to continue");
	    getch();
	    clearScreen();
	    main();
	}

	//receive randomized word
	String getword()
	{
	    String[] arr2 = new String[] { "crocodile", "crocodile", "crocodile", 
	    		"crocodile", "horse", "camel", "monkey", "dolphin", 
	    		"sealion", "panther" };

	    //srand(time(NULL));
	    //time_t t;
	    //srand((unsigned)time(&t));
		String randomName = arr2[(int) (Math.random() * arr2.length)];


	//return word in random spot from list
	    return randomName;
	}

	void lastgame(int result) //return the results of last game
	{
	    if(result==1)
	    {
	        System.out.println("You lost the game.\n");

	    }
	    if(result==2)
	    {
	        System.out.println("You won the game.\n");

	    }
	    if(result!=1 && result!=2)
	    {
	        System.out.println("No game was played\n");
	    }
	}

	void wrong(int attempt) //Used when guess is wrong to build the hangman
	{
	    if(attempt>0)
	    {

	        if(attempt == 1)
	        {
	            System.out.println("\t\t\t   ==============     \n");
	            System.out.println("\t\t\t   ||     |    ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }

	        if(attempt == 2)
	        {
	            System.out.println("\t\t\t   ==============     \n");
	            System.out.println("\t\t\t   ||     |    ||     \n");
	            System.out.println("\t\t\t   ||     1    ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }

	        if(attempt == 3)
	        {
	            System.out.println("\t\t\t   ==============     \n");
	            System.out.println("\t\t\t   ||     |    ||     \n");
	            System.out.println("\t\t\t   ||     1    ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||    2 2   ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ,,,,,,,,,,,,,,     \n");


	        }

	        if(attempt == 4)
	        {
	            System.out.println("\t\t\t   ==============     \n");
	            System.out.println("\t\t\t   ||     |    ||     \n");
	            System.out.println("\t\t\t   ||     1    ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||    2 2   ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||     3    ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }

	        if(attempt == 5)
	        {
	            System.out.println("\t\t\t   ==============     \n");
	            System.out.println("\t\t\t   ||     |    ||     \n");
	            System.out.println("\t\t\t   ||     1    ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||    2 2   ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||     3    ||     \n");
	            System.out.println("\t\t\t   ||    444   ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }

	        if(attempt == 6)
	        {

	            System.out.println("\t\t\t   ==============     \n");
	            System.out.println("\t\t\t   ||     |    ||     \n");
	            System.out.println("\t\t\t   ||     1    ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||    2 2   ||     \n");
	            System.out.println("\t\t\t   ||     2    ||     \n");
	            System.out.println("\t\t\t   ||     3    ||     \n");
	            System.out.println("\t\t\t   ||    444   ||     \n");
	            System.out.println("\t\t\t   ||   5 5 5  ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ||          ||     \n");
	            System.out.println("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }
	        if(attempt == 7)
	        {
	            System.out.print("\t\t\t   ==============     \n");
	            System.out.print("\t\t\t   ||     |    ||     \n");
	            System.out.print("\t\t\t   ||     1    ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||    2 2   ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||     3    ||     \n");
	            System.out.print("\t\t\t   ||    444   ||     \n");
	            System.out.print("\t\t\t   ||   5 5 5  ||     \n");
	            System.out.print("\t\t\t   ||    6 6   ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }
	        if(attempt == 8)
	        {

	            System.out.print("\t\t\t   ==============     \n");
	            System.out.print("\t\t\t   ||     |    ||     \n");
	            System.out.print("\t\t\t   ||     1    ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||    2 2   ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||     3    ||     \n");
	            System.out.print("\t\t\t   ||  5544455 ||     \n");
	            System.out.print("\t\t\t   ||  5  5  5 ||     \n");
	            System.out.print("\t\t\t   ||    6 6   ||     \n");
	            System.out.print("\t\t\t   ||   7   7  ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }
	        if(attempt == 9)
	        {
	            System.out.print("\t\t\t   ==============     \n");
	            System.out.print("\t\t\t   ||     |    ||     \n");
	            System.out.print("\t\t\t   ||     1    ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||    2 2   ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||     3    ||     \n");
	            System.out.print("\t\t\t   ||    444   ||     \n");
	            System.out.print("\t\t\t   ||  5544455 ||     \n");
	            System.out.print("\t\t\t   ||  5  5  5 ||     \n");
	            System.out.print("\t\t\t   ||   7   7  ||     \n");
	            System.out.print("\t\t\t   ||  8     8 ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ,,,,,,,,,,,,,,     \n");


	        }
	        if(attempt == 10)
	        {
	            System.out.print("\t\t\t   ==============     \n");
	            System.out.print("\t\t\t   ||     |    ||     \n");
	            System.out.print("\t\t\t   ||     1    ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||    2 2   ||     \n");
	            System.out.print("\t\t\t   ||     2    ||     \n");
	            System.out.print("\t\t\t   ||     3    ||     \n");
	            System.out.print("\t\t\t   ||    444   ||     \n");
	            System.out.print("\t\t\t   ||  5544455 ||     \n");
	            System.out.print("\t\t\t   ||  5  5  5 ||     \n");
	            System.out.print("\t\t\t   ||   7   7  ||     \n");
	            System.out.print("\t\t\t   ||  8     8 ||     \n");
	            System.out.print("\t\t\t   || 9       9||     \n");
	            System.out.print("\t\t\t   ||          ||     \n");
	            System.out.print("\t\t\t   ,,,,,,,,,,,,,,     \n");

	        }
	    }

	}
	
	
	public static void clearScreen() {  
	    System.out.print("\033[H\033[2J");  
	    System.out.flush();  
	}  
	
	private void getch() {
		try {
			choice = (char) System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
