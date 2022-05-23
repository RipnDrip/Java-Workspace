import java.lang.*;



import java.util.*;



import java.io.*;



public class CreateShapes {	

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);



		String shapeLetter;



		int length = 0,height = 0;

		int x = 0,y = 0;



		//prompts the user to input a letter shape

		System.out.println("Enter a shape : r t h o p ");



		shapeLetter = scan.next();





		if (shapeLetter.equals("t") ||shapeLetter.equals ("h")|| shapeLetter.equals("o") ||shapeLetter.equals( "p")) {

			System.out.println("Enter a length: ");

			length = scan.nextInt();	

		}

		else if (shapeLetter.equals("r")) {

			System.out.println("Enter a length: ");

			length = scan.nextInt();

			System.out.println("Enter a Height: ");

			height = scan.nextInt();

		}

		else {

			System.out.println("Error, input valid shape.");

		}

		

		String shape = "";

		if (shapeLetter.equals("t")) {

			shape = "triangle";

		}

		if (shapeLetter.equals("h")) {

			shape = "hexagon";

		}

		if (shapeLetter.equals("o")) {

			shape = "octagon";

		}

		if (shapeLetter.equals("p")) {

			shape = "pentagon";

		}

		if (shapeLetter.equals("r")) {

			shape = "rectangle";

		}

		

		

		if (shapeLetter.equals("t") ||shapeLetter.equals ("h")||shapeLetter.equals( "p")) {

			System.out.println("Below is a " + shape + "with side lengths " + length + " *");

		}

		else if (shapeLetter.equals("o")) {

			System.out.println("Below is an " + shape + "with side lengths " + length + " *");

		}

		else if (shapeLetter.equals("r")) {

			System.out.println("Below is a " + length + " by " + height + " " + shape + " of *");

		}

	} 	// main

}	// class