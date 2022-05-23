/*

 * StarGraph.java

 * Author: Terique Mick

 * Submission Date: 3/8/19

 *

 * Purpose: This program is designed to use arrays and loops to calculate y-values and display them on a graph.

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

public class StarGraph {

	public static void main (String[] args) {

		Scanner keyboard = new Scanner(System.in);

		//variables

		double minValueOfX, incrementOfX;

		int sizeOfN, index;



		//Input for array size

		System.out.println("Please enter the number of x values to process:");

		sizeOfN = keyboard.nextInt();



		if (sizeOfN <= 0) {

			System.out.println("Number of X values must be greater than 0. Try again.");

			System.exit(0);

		}

		else {



		}

		

		//Input for minimum X value

		System.out.println("Enter the minimum value of X:");

		minValueOfX = keyboard.nextDouble();



		

		

		//Input for Increment value of X

		System.out.println("Enter the amount to increment X:");

		incrementOfX = keyboard.nextDouble();



		if (incrementOfX <= 0) {

			System.out.println("Increment of X values must be greater than 0. Try again.");

			System.exit(0);

		}



		else {



		}





	

		

		

		

		

		//X-array

		double[] xArray = new double [sizeOfN];



		System.out.println("Here are the X-values:");



		for (index = 0; index < xArray.length; index++) {

			xArray[index] = minValueOfX + (incrementOfX *index);

			System.out.printf("\n%.3f" ,xArray[index]);

		}









		

		//Y-array

		double[] yArray = new double [sizeOfN];



		System.out.println("\nHere are the y-values:");



		for (index = 0; index < yArray.length; index++) {

			yArray[index] = 20.0 * Math.abs(Math.sin(xArray[index]));;

			System.out.printf("\n%.3f" ,yArray[index]);

		}





		

		

		//correct output format for X and Y values

		System.out.println("\nHere are both values:");

		for (index = 0; index < xArray.length; index++) {

			System.out.printf("\nx: %.3f   y: %.3f" ,xArray[index], yArray[index]);

		}		

		

		

		

		//Graph

		System.out.println("\nGraph:");



		for (index = 0; index < sizeOfN; index++) {

			System.out.print(":");

			for(int yIndex = 0; yIndex < yArray[index]-1; yIndex++) {

				System.out.print("*");

			}

			System.out.println("");

		}



	}//main

}//class

