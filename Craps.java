/**************************************************
		Andrew Wright
		Mini-project 2
		Craps game! 2 dice win with 7 or 11. Loss with 2, 3 or 12. Other other rolls add up to the point. Keep rolling to hit point, 7 is a loss.
***************************************************/


import java.util.Scanner;

public class Craps {
	
	
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);	
		String userPlay;
		boolean playAgain = true;
	
		System.out.println("Welcome to the game of 21!\n");
		System.out.println("If your first roll of 2 die is 15 or higher, you get to roll 1 die at to try to get 21.");

	
		while (playAgain) {
		
			diceRoll(input);
			System.out.print("Would you like to play again? (yes or no): ");
			userPlay = input.nextLine().toLowerCase();
			
						
			if (!userPlay.equals("yes")) {
				playAgain = false;
				System.out.println("That was fun! Run the program again to play again.");
			}			
		}	
	}