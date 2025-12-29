/**************************************************
		Andrew Wright
		Mini-project 2
		Craps game! 2 dice win with 7 or 11. Loss with 2, 3 or 12. Other other rolls add up to the point. Keep rolling to hit point, 7 is a loss.
***************************************************/


import java.util.Scanner;

public class PlayCraps {
	
	//play again logic
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);	
		String userPlay;
		boolean playAgain = true;
	
		System.out.println("Welcome to the game of Craps!\n");
		System.out.println("If first roll hits on 7 or 11, YOU WIN!\n");
		System.out.println("If the first roll hits 2, 3 or 12, You Lose!\n");
		System.out.println("Outside of those numbers, your first roll becomes your point.\n");
		System.out.println("You will roll until you hit your Point. If you hit a 7, You Lose!\n");
	
		while (playAgain) {
		
			crapsRound(input);
			System.out.print("Would you like to play again? (yes or no): ");
			userPlay = input.nextLine().toLowerCase();
			
						
			if (!userPlay.equals("yes")) {
				playAgain = false;
				System.out.println("That was fun! Run the program again to play again.");
			}			
		}	
	}
	
	//dice roll logic
	public static int diceRoll() {
			
		return (int) (Math.random() * 6) + 1 * 2;
	}
	
	//dice roll and win and lossing numbers
	public static void crapsRound(Scanner input) {
		
		System.out.print("Press Enter for your first roll");
		input.nextLine();
		
		int die1 = diceRoll();
		int die2 = diceRoll();
		int rollTotal = die1 + die2;
		
		System.out.println("You rolled a " + die1 + " and a " + die2);
		System.out.println("Your roll total is: " + rollTotal);
			
		if (rollTotal == 7 || rollTotal == 11) {
			System.out.println("You rolled a " + die1 + " and a " + die2);
			System.out.println("Your roll total is: " + rollTotal + " You instantly win!!!\n"); 
			return;
		}
				
		if (rollTotal == 2 || rollTotal == 3 || rollTotal == 12) {
			System.out.println("You rolled a " + die1 + " and a " + die2);
			System.out.println("Your roll total is: " + rollTotal + " You Lose. Better luck next time.\n");
			return;
		}
		
		//Point roll logic
		int point = rollTotal;
		System.out.println("You need to hit your Point. If you hit a 7 you lose.");
		System.out.println("Keep rolling if neither of these numbers are hit.\n");
		System.out.println("Your Point target is: " + point);
		
		while (true) {
			
			System.out.print("Hit ENTER to roll");
			input.nextLine();
			
			die1 = diceRoll();
			die2 = diceRoll();
			rollTotal = die1 + die2;			
		
			if (rollTotal == 7) {
				System.out.println("You rolled a " + rollTotal + " Dang normally 7 is lucky! Better luck next time.\n");
				break;
			}
			else if (rollTotal == point) {
				System.out.println("You rolled a " + rollTotal + " and your Point was " + point + " You hit your point! You WIN!!!\n");
				break;
			}
			else {
				System.out.println("You rolled a " + rollTotal + " You missed your Point, but you didn't hit a 7.\n");
			}
		}	
	}		
}

