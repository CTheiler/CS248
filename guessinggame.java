import java.util.*;
import java.io.*;

import java.util.*;

class guessinggame
{
	static boolean checkGuess(int guessed, int findme, String[] insults)
	{
		Random randi = new Random();
		int RandInsult = randi.nextInt(5);
		if (guessed==findme)
		{
			System.out.println("You win!!");
			return true;
		}
		else if (guessed<findme)
		{
			System.out.println("Too low, " + insults[RandInsult]);
			return false;
		}
		else if (guessed>findme)
		{
			System.out.println("Too high, " + insults[RandInsult]);
			return false;
		}
		return false;
			
	}
	
	public static void main(String[] args)
	{
		String[] insults = new String[5];
		insults[0]="Stoopid head";
		insults[1]="Elbow nose";
		insults[2]="Dummy Boi";
		insults[3]="Dimwit";
		insults[4]="Bozo";
		
		char yes = 'y';
		char cont = ' ';

		Random randi = new Random();
		int findme = randi.nextInt(100);
		Scanner cin = new Scanner(System.in);
		int guessed = 0;

		while (cont != 'n')
		{
			System.out.println("Enter your guess: ");
			guessed=cin.nextInt();
			if (checkGuess(guessed,findme,insults)==true)
			{
				System.out.println("Congratulations, you won the game! If you would like to play again enter 'y'. If not, enter 'n'");
				cont = cin.next().charAt(0);
				if (cont == yes)
				{
					findme = randi.nextInt(100);
				}
			}			
		}
	}
}