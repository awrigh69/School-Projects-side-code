/**************************************************
		Andrew Wright
		Mini-project 2
		21 Dice game
***************************************************/


import java.util.Scanner;

public class TwentyOne {
	
	//play again logic
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
				
		//dice roll logic and display
		public static void diceRoll(Scanner input) {
			
			int rollTotal = 0;
			
			while (true) {
				
				System.out.print("Press ENTER to roll!\n");
				input.nextLine();
	
				if (rollTotal < 15) {
					
					int die1 = (int) (Math.random() * 6) + 1;
					int die2 = (int) (Math.random() * 6) + 1;
					int rollOne = die1 + die2;

					System.out.println("Die 1 = " + die1);
					System.out.println("Die 2 = " + die2);
					System.out.println("Toal of 2 die = " + rollOne);
					System.out.println("Your are under the minimum required number. Keep rolling!");
				
					rollTotal += rollOne;
				}	
			
				else {

					int die3 = (int) (Math.random() * 6) + 1;
				
					System.out.println("You rolled a " + die3);
					rollTotal += die3;
					System.out.println("Your 3 roll total is: " + rollTotal);
				
				}
			
				System.out.println("Your current total from your dice rolls is: " + rollTotal);
				
				if (rollTotal == 21) {
					System.out.println("You got 21 exactly!!! You WIN!!!");
					break;
				}
				
				else if (rollTotal > 21) {
					System.out.println("You got over 21! Better luck next time.");
					break;
				}
				
				else {
					System.out.println("You did not make it over 21. Rolling again.\n");
				}	
				
			}
		}
	}

