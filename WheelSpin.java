/**************************************************
		Mini-project 2
		Price is right/wheel spin
***************************************************/


import java.util.Scanner;

public class WheelSpin {
	
	//play again logic
	public static void main(String[] args) {
	
		Scanner input = new Scanner(System.in);	
		String userPlay;
		boolean playAgain = true;
	
		System.out.println("Welcome to the Price is Right!\n");
		System.out.println("The player that gets the closet to 100 using 2 wheel spins is the WINNER!\n");

	
		while (playAgain) {
		
			spinWheel(input);
			System.out.print("Would you like to play again? (yes or no): ");
			userPlay = input.nextLine().toLowerCase();
			
						
			if (!userPlay.equals("yes")) {
				playAgain = false;
				System.out.println("That was fun! Run the program again to play again.");
			}			
		}	
	}

		//wheel setup and random multiple of 5
		public static int wheelAmount() {
			
			int amount = (int) (Math.random() * 20) + 1;
			return amount * 5;
		}

		
		//Game structure
		public static void spinWheel(Scanner input) {
			
			boolean[] oneHundred = new boolean[3];
			int [] score = new int[3];

			System.out.println("3 players will get 2 spins max in order to get as close to 100 as possible.\n");
			System.out.println("The wheel will contain numbers from 5 to 100; multiples of 5 are contained within.\n");
			
			
			for (int p = 0; p < 3; p++) {
				
				System.out.println("Get ready " + (p + 1) + " it is your turn!\n");
				score[p] = playerSpin(p + 1, input);
				
				if (score[p] == 100) {
					oneHundred[p] = true;
				}
			}
			
			//logic to determine winner
			boolean[] winner = new boolean[3];
			int highest = 0;
			
			for (int p = 0; p < 3; p++) {
				
				if (score[p] <= 100 && score[p] > 0) {
				
					if (score[p] > highest) {
						winner = new boolean[3];
						highest = score[p];
						winner[p] = true;
					}
					else if (score[p] == highest) {
						winner[p] = true;
					}
				}
			}

	
			//logic to approve bonus spin
			boolean bonus = false;
			
			for (int p = 0; p < 3; p++) {
			
				if (oneHundred[p]) {
					bonus = true;
					bonusSpin(p + 1, input);
					System.out.println("Player " + (p + 1) + " got one bonus spin!");
				}
			}	
					
			//showing player scores
			for (int p = 0; p < 3; p++) {
				
				if (score[p] > 100) {
					System.out.println("Player " + (p + 1) + " went over 100!");
				}
				else if (score[p] == 0) {
					System.out.println("This is not a valid score.");
				}
				else {
					System.out.println("Player " + (p + 1) + "'s score is " + score[p]);
				}
			}
				
			if (highest == 0) {
				System.out.println("Zero is invalid. Please respin.");
			}
			
			//reveals the winner
			else {
				System.out.println("Drum roll please.....\n");
				System.out.println("The winner is: ");

					try {											//
						Thread.sleep(2000);							//      I WANTED TO ADD A BIT OF DEPTH TO SEEM LIKE A REAL GAME.
					}												//		I ADDED A TIME DELAY FEATURE.
					catch (InterruptedException e) {				//
						e.printStackTrace();						//		I googled "How to add a delay in Java?" My source for this information was:
					}												//		https://sentry.io/answers/how-to-add-a-delay-in-java/#:~:text=You%20can%20use%20either%20the,an%20execution%20delay%20in%20Java.
					
				for (int p = 0; p < 3; p++) {
					if (winner[p]) {
						System.out.println("Player number " + (p + 1) + " with a score of " + highest + " out of 100!!\n");
					}
				}
			}	
		}		
			
		
		//logic for determing player's spins
		public static int playerSpin(int player, Scanner input) {
			
			int spin = 0;
			int total = 0;
			
			while (spin < 2) {
				
				System.out.println("Player " + player + " spin that wheel!!\n");
				System.out.println ("Press ENTER");
				input.nextLine();
				
				int spinNumb = wheelAmount();
				spin++;
				total += spinNumb;
				
				System.out.println("Player " + player + " spun the wheel for: " + spinNumb);
				System.out.println("Player " + player + " your total is: " + total + " out of 100.\n");
				
				if (total == 100) {
					System.out.println("Amazing you got 100 on the dot!");
					break;
				}
				if (total > 100) {
					System.out.println("Sorry you went over 100. Better luck next time.\n");
					break;
				}
				
				if (spin == 1) {
					System.out.print("Would you like to risk it and take your 2nd spin? Type yes or no: ");
					String spinAgain = input.nextLine().toLowerCase();
					
					if (!spinAgain.equals("yes")) {
						System.out.println("Bold move! Your total is: " + total);
						break;
					}
				}
			}	
			return total;
		}


		//bonus spin logic
		public static void bonusSpin(int player, Scanner input) {
			
			int spinValue = wheelAmount();
			
			System.out.println("Player " + player + " got a Bonus Spin!\n");
			System.out.println("Press ENTER to spin your Bonus!");
			input.nextLine();
			
			if (spinValue == 100) {		
				System.out.println("You hit 100 twice in a row!!! Player: " + player + "just won $25,000!!!\n");
			}
			else if (spinValue == 5 || spinValue == 15) {
				System.out.println("Player " + player + " landed on " + spinValue + "!!! They have won $15,000!!!\n");
			}
		}
	}		
			
			

			
