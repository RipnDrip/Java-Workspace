/*

 * RockPaperScissors.java

 * Author: 

 * Submission Date: 9/25/19

 *

 * Purpose: This program is designed as a simple game of Rock, Paper, Scissors.

 *

 * Statement of Academic Honesty:

 *

 * The following code represents my own work. I have neither

 * received nor given inappropriate assistance. I have not copied

 * or modified code from any source other than the course webpage

 * or the course textbook. I recognize that any unauthorized

 * assistance or plagiarism will be handled in accordance with

 * the University of Georgia's Academic Honesty Policy and the

 * policies of this course. I recognize that my work is based

 * on an assignment created by the Department of Computer

 * Science at the University of Georgia. Any publishing

 * or posting of source code for this project is strictly

 * prohibited unless you have written consent from the Department

 * of Computer Science at the University of Georgia.

 */

import java.util.Scanner;



public class RockPaperScissors {

	static boolean TESTING_MODE = false;

	public static void main (String[] args) {







		Scanner keyboard = new Scanner(System.in);



		//Variable declaration

		int numOfRounds = 0, userInputOfRounds, winCount = 0, lossCount = 0;







		//Asks user how many rounds to play

		System.out.println("How many rounds do you want to play?");

		userInputOfRounds = keyboard.nextInt();



		if (userInputOfRounds > 0) {



		}

		else {

			System.out.println("Invalid amount of rounds, try again.");

			System.exit(0); 

		}





		//Loop statement that allows user to input choices and determines who wins the game

		while ((userInputOfRounds != winCount) && (userInputOfRounds != lossCount))	 {

			String computerMove = ComputerOpponent.getMove();

			System.out.println("Make your move:");

			String userInput = keyboard.next();



			if ((userInput.equalsIgnoreCase("rock")) || (userInput.equalsIgnoreCase("paper")) || (userInput.equalsIgnoreCase("scissors"))) {



			}



			else {

				System.out.println("Invalid input. Please try again.");

				System.exit(0); 

			}





			//Determines win cases for user

			if ((userInput.equalsIgnoreCase("rock")) && (computerMove.equalsIgnoreCase("scissors"))) {

				System.out.println("The Computer chose scissors, so you win!");

				winCount++;

				String scoreCount = winCount + "-" + lossCount;

				System.out.println(scoreCount);

			}

			else if ((userInput.equalsIgnoreCase("paper")) && (computerMove.equalsIgnoreCase("rock"))) {

				System.out.println("The Computer chose rock, so you win!");

				winCount++;

				String scoreCount = winCount + "-" + lossCount;

				System.out.println(scoreCount);



			}	

			else if ((userInput.equalsIgnoreCase("scissors")) && (computerMove.equalsIgnoreCase("paper"))) {

				System.out.println("The Computer chose paper, so you win!");

				winCount++;

				String scoreCount = winCount + "-" + lossCount;

				System.out.println(scoreCount);

			}	



			//Determines Tie cases

			else if ((userInput.equalsIgnoreCase("paper")) && (computerMove.equalsIgnoreCase("paper"))) {

				System.out.println("Draw!");

				String scoreCount = winCount + "-" + lossCount;

				System.out.println(scoreCount);

			}	

			else if ((userInput.equalsIgnoreCase("rock")) && (computerMove.equalsIgnoreCase("rock"))) {

				System.out.println("Draw!");

				String scoreCount = winCount + "-" + lossCount;

				System.out.println(scoreCount);

			}	

			else if ((userInput.equalsIgnoreCase("scissors")) && (computerMove.equalsIgnoreCase("scissors"))) {

				System.out.println("Draw!");

				String scoreCount = winCount + "-" + lossCount;

				System.out.println(scoreCount);

			}	

			//determines user as loser

			else {

				System.out.println("Sorry, the Computer chose " + computerMove + ", so you lose...");

				lossCount++;

				String scoreCount = winCount + "-" + lossCount;

				System.out.println(scoreCount);

			}





		}//Loop for the game





		//End Game Statement

		if (winCount == userInputOfRounds) {

			System.out.println("Congratulations, You win!");

		}

		if (lossCount == userInputOfRounds) {

			System.out.println("Sorry, you lost. Better luck next time!");

		}

	} // main

}

