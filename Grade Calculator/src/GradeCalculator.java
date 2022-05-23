/*

 * GradeCalculator.java

 * Author: Terique Mick

 * Submission Date: 9/16/19

 *

 * Purpose: This program is used to determine the grades necessary to pass a course.

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



public class GradeCalculator {



	public static void main (String[] args) {



		Scanner keyboard = new Scanner(System.in);

		//Variable declaration

		double exam1Weight, exam2Weight, finalExamWeight;

		double labWeight, projWeight, participationWeight, quizWeight;

		double userTotalWeight, initialTotalWeight,calculatedTotalWeight = 0;

		double exam1Grade = 0, exam2Grade = 0, finalExamGrade = 0;

		double labGrade = 0,projGrade = 0, participationGrade = 0, quizGrade = 0;

		double currentAvgGrade, sumOfWeightAndScore = 0;

		double minGradeValue = 0;

		char outGrade = 0;



		

		

		

		//Grading Scale

		System.out.println("A    90 - 100\r\n" + 

				"B    80 - 89\r\n" + 

				"C    70 - 79\r\n" + 

				"D    60 - 69\r\n" + 

				"F    below 60");

		

		

		

		

		

		//User enters desired grade and determines minimum value score 

		System.out.print("What grade do you want to achieve?");

		String minimumGradeScale = keyboard.next();



		if (minimumGradeScale.equalsIgnoreCase("a")) {

			minGradeValue = 90;

		}

		else if (minimumGradeScale.equalsIgnoreCase("b")) {

			minGradeValue = 80;



		}

		else if (minimumGradeScale.equalsIgnoreCase("c")) {

			minGradeValue = 70;



		}

		else if (minimumGradeScale.equalsIgnoreCase("d")) {

			minGradeValue = 60;

		}

		else {

			System.out.println("Invalid grade input.");

			System.exit(0);

		}





		//User inputs weight values

		System.out.println("Enter Percentage weights:");



		exam1Weight = keyboard.nextDouble();

		exam2Weight = keyboard.nextDouble();

		finalExamWeight = keyboard.nextDouble();

		labWeight = keyboard.nextDouble();

		projWeight = keyboard.nextInt();

		participationWeight = keyboard.nextDouble();

		quizWeight = keyboard.nextDouble();

		userTotalWeight = exam1Weight + exam2Weight + finalExamWeight + labWeight + projWeight + participationWeight + quizWeight;

		initialTotalWeight = 100;



		//statement to ensure acceptable weight value totals

		if (userTotalWeight != 100)  {

			System.out.print("Total weight amount does not equal 100");

			System.exit(0);

		}

		else {



		}













		//Outputs user weight values

		//System.out.println("Exam 1: " + exam1Weight);

		//System.out.println("Exam 2: " + exam2Weight);

		//System.out.println("Final Exam: " + finalExamWeight);

		//System.out.println("Labs: " + labWeight);

		//System.out.println("Projects: " + projWeight);

		//System.out.println("Attendance: " + attendanceWeight);

		//System.out.println("Quizzes: " + quizWeight);







		//Asks user if particular grade is known

		System.out.println("Do you know your Exam 1 grade?");



		String userConfirmation = keyboard.next();



		if (userConfirmation.equalsIgnoreCase("yes") || userConfirmation.equalsIgnoreCase("y")) {

			System.out.println("Enter your Exam 1 grade");

			exam1Grade = keyboard.nextDouble();

			calculatedTotalWeight = exam1Weight;

			sumOfWeightAndScore = ((exam1Grade * exam1Weight));

		}



		//If user does not know Exam 1 grade

		else { 





			//Asks user if particular grade is known



			System.out.println("Do you know your Lab average grade?");

			String userConfirmation4 = keyboard.next();	



			if (userConfirmation4.equalsIgnoreCase("yes") || userConfirmation4.equalsIgnoreCase("y")) {

				System.out.println("Enter your Lab grade");

				labGrade = keyboard.nextDouble();

				calculatedTotalWeight = labWeight;

				sumOfWeightAndScore = labGrade * labWeight;

			}

			else {



			}









			//Asks user if particular grade is known



			System.out.println("Do you know your Project grade?");

			String userConfirmation5 = keyboard.next();	



			if (userConfirmation5.equalsIgnoreCase("yes") || userConfirmation5.equalsIgnoreCase("y")) {

				System.out.println("Enter your Project grade");

				projGrade = keyboard.nextDouble();

				calculatedTotalWeight = labWeight + projWeight;



				sumOfWeightAndScore = (labGrade * labWeight)  + (projGrade * projWeight);

			}

			else {



			}







			//Asks user if particular grade is known



			System.out.println("Do you know your Participation grade?");

			String userConfirmation6 = keyboard.next();	



			if (userConfirmation6.equalsIgnoreCase("yes") || userConfirmation6.equalsIgnoreCase("y")) {

				System.out.println("Enter your Participation grade");

				participationGrade = keyboard.nextDouble();

				calculatedTotalWeight = labWeight + projWeight + participationWeight;



				sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

						(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

						(participationGrade * participationWeight) + (projGrade * projWeight));		

			}

			else {



			}









			//Asks user if particular grade is known



			System.out.println("Do you know your Quiz grade?");

			String userConfirmation7 = keyboard.next();	





			if (userConfirmation7.equalsIgnoreCase("yes") || userConfirmation7.equalsIgnoreCase("y")) {

				System.out.println("Enter your Quiz grade");

				quizGrade = keyboard.nextDouble();

				calculatedTotalWeight = labWeight + projWeight + participationWeight + quizWeight;



				sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

						(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

						(participationGrade * participationWeight) + (projGrade * projWeight) + 

						(quizGrade * quizWeight));		

			}



			else  {



			}











			//System.out.println(sumOfWeightAndScore);

			//System.out.println(calculatedTotalWeight);







			//Formula to determine user's current grade

			currentAvgGrade = (sumOfWeightAndScore/ (calculatedTotalWeight));





			//Outputs current grade

			System.out.printf("Your current grade is: %.2f \n " , currentAvgGrade);







			//Outputs letter grade based on current grade

			if ((currentAvgGrade <= 100) && (currentAvgGrade >= 90)) {

				outGrade = 'A';

			}

			else if ((currentAvgGrade < 90) && (currentAvgGrade >= 80)) {

				outGrade = 'B';

			}

			else if ((currentAvgGrade < 80) && (currentAvgGrade >= 70)) {

				outGrade = 'C';	

			}

			else if ((currentAvgGrade < 70) && (currentAvgGrade > 60)) {

				outGrade = 'D';

			}

			else if ((currentAvgGrade <= 60) && (currentAvgGrade >= 0)) {

				outGrade = 'F';

			}

			else {



				System.out.println("Invalid grade input. Try again");

				System.exit(0);

			}

			System.out.println("Your grade is: " + outGrade);





			//More variable declarations

			double AvgToGradeValue;

			String desiredLetterGrade = minimumGradeScale.toUpperCase();



			//Calculates sum of all weights multiplied by score

			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

					(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

					(participationGrade * participationWeight) + (projGrade * projWeight) + 

					(quizGrade * quizWeight));



			//Calculate value needed to reach desired grade

			AvgToGradeValue = ((((100 * minGradeValue) - sumOfWeightAndScore))/((100 - calculatedTotalWeight)));



			//determines if grade will be achieved no matter what 

			if (currentAvgGrade > minGradeValue) {

				System.out.println("Your will receive a " + desiredLetterGrade + " no matter what" );

				System.exit(0);

			}

			else {



			}





			//Determines if it is possible to achieve grade

			if (AvgToGradeValue > 100) {

				System.out.println("Sorry you cannot recieve an " + desiredLetterGrade + " in this course");



			}

			else if ((AvgToGradeValue < 100) && (AvgToGradeValue > 0)) {

				System.out.printf("You must score an average greater than or equal to %.2f \nin the remaining graded items to receive a %s in this course", AvgToGradeValue, desiredLetterGrade); 

			}

			else {

				System.out.println("Congrats!!! you received the " + outGrade + " that you wanted!" );

			}

			System.exit(0);

		}







		//Asks user if particular grade is known		

		System.out.println("Do you know your Exam 2 grade?");

		String userConfirmation2 = keyboard.next();	



		if (userConfirmation2.equalsIgnoreCase("yes") || userConfirmation2.equalsIgnoreCase("y")) {

			System.out.println("Enter your Exam 2 grade");

			exam2Grade = keyboard.nextDouble();

			calculatedTotalWeight =  exam1Weight + exam2Weight;

			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight));



		}

		//If user does not know Exam 2 grade

		else  {





			//Asks user if particular grade is known



			System.out.println("Do you know your Lab average grade?");

			String userConfirmation4 = keyboard.next();	



			if (userConfirmation4.equalsIgnoreCase("yes") || userConfirmation4.equalsIgnoreCase("y")) {

				System.out.println("Enter your Lab grade");

				labGrade = keyboard.nextDouble();

				calculatedTotalWeight = exam1Weight + labWeight;

				sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + (finalExamGrade * finalExamWeight) + (labGrade * labWeight));

			}

			else {



			}









			//Asks user if particular grade is known



			System.out.println("Do you know your Project grade?");

			String userConfirmation5 = keyboard.next();	



			if (userConfirmation5.equalsIgnoreCase("yes") || userConfirmation5.equalsIgnoreCase("y")) {

				System.out.println("Enter your Project grade");

				projGrade = keyboard.nextDouble();

				calculatedTotalWeight = exam1Weight + labWeight + projWeight;



				sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

						(finalExamGrade * finalExamWeight) + (labGrade * labWeight)  + (projGrade * projWeight));

			}

			else {



			}







			//Asks user if particular grade is known



			System.out.println("Do you know your Participation grade?");

			String userConfirmation6 = keyboard.next();	



			if (userConfirmation6.equalsIgnoreCase("yes") || userConfirmation6.equalsIgnoreCase("y")) {

				System.out.println("Enter your Participation grade");

				participationGrade = keyboard.nextDouble();

				calculatedTotalWeight = exam1Weight + labWeight + projWeight + participationWeight;



				sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

						(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

						(participationGrade * participationWeight) + (projGrade * projWeight));		

			}

			else {



			}









			//Asks user if particular grade is known



			System.out.println("Do you know your Quiz grade?");

			String userConfirmation7 = keyboard.next();	





			if (userConfirmation7.equalsIgnoreCase("yes") || userConfirmation7.equalsIgnoreCase("y")) {

				System.out.println("Enter your Quiz grade");

				quizGrade = keyboard.nextDouble();

				calculatedTotalWeight = (exam1Weight + labWeight + projWeight + participationWeight + quizWeight);



				sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

						(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

						(participationGrade * participationWeight) + (projGrade * projWeight) + 

						(quizGrade * quizWeight));		

			}



			else  {



			}











			//System.out.println(sumOfWeightAndScore);

			//System.out.println(calculatedTotalWeight);





			//Formula to determine user's current grade	

			currentAvgGrade = (sumOfWeightAndScore/ (calculatedTotalWeight));





			//Outputs current grade

			System.out.printf("Your current grade is: %.2f \n " , currentAvgGrade);







			//Outputs letter grade based on current grade

			if ((currentAvgGrade <= 100) && (currentAvgGrade >= 90)) {

				outGrade = 'A';

			}

			else if ((currentAvgGrade < 90) && (currentAvgGrade >= 80)) {

				outGrade = 'B';

			}

			else if ((currentAvgGrade < 80) && (currentAvgGrade >= 70)) {

				outGrade = 'C';	

			}

			else if ((currentAvgGrade < 70) && (currentAvgGrade > 60)) {

				outGrade = 'D';

			}

			else if ((currentAvgGrade <= 60) && (currentAvgGrade >= 0)) {

				outGrade = 'F';

			}

			else {



				System.out.println("Invalid grade input. Try again");

				System.exit(0);

			}

			System.out.println("Your grade is: " + outGrade);





			//More variable declarations

			double AvgToGradeValue;

			String desiredLetterGrade = minimumGradeScale.toUpperCase();



			//Calculates sum of all weights multiplied by score

			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

					(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

					(participationGrade * participationWeight) + (projGrade * projWeight) + 

					(quizGrade * quizWeight));



			//Calculate value needed to reach desired grade

			AvgToGradeValue = ((((100 * minGradeValue) - sumOfWeightAndScore))/((100 - calculatedTotalWeight)));



			//determines if grade will be achieved no matter what 

			if (currentAvgGrade > minGradeValue) {

				System.out.println("Your will receive a " + desiredLetterGrade + " no matter what" );

				System.exit(0);

			}

			else {



			}





			//Determines if it is possible to achieve grade

			if (AvgToGradeValue > 100) {

				System.out.println("Sorry you cannot recieve an " + desiredLetterGrade + " in this course");



			}

			else if ((AvgToGradeValue < 100) && (AvgToGradeValue > 0)) {

				System.out.printf("You must score an average greater than or equal to %.2f \nin the remaining graded items to receive a %s in this course", AvgToGradeValue, desiredLetterGrade); 

			}

			else {

				System.out.println("Congrats!!! you received the " + outGrade + " that you wanted!" );

			}

			System.exit(0);



		}









		//Asks user if particular grade is known



		System.out.println("Do you know your Final Exam grade?");

		String userConfirmation3 = keyboard.next();	



		if (userConfirmation3.equalsIgnoreCase("yes") || userConfirmation3.equalsIgnoreCase("y")) {

			System.out.println("Enter your Final Exam grade");

			finalExamGrade = keyboard.nextDouble();

			calculatedTotalWeight = exam1Weight + exam2Weight + finalExamWeight;

			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + (finalExamGrade * finalExamWeight));



		}

		else  {

			calculatedTotalWeight = exam1Weight + exam2Weight;

		}







		//Asks user if particular grade is known



		System.out.println("Do you know your Lab average grade?");

		String userConfirmation4 = keyboard.next();	



		if (userConfirmation4.equalsIgnoreCase("yes") || userConfirmation4.equalsIgnoreCase("y")) {

			System.out.println("Enter your Lab grade");

			labGrade = keyboard.nextDouble();

			calculatedTotalWeight = exam1Weight + exam2Weight + finalExamWeight + labWeight;

			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + (finalExamGrade * finalExamWeight) + (labGrade * labWeight));

		}

		else  {

			calculatedTotalWeight = exam1Weight + exam2Weight + finalExamWeight;



		}









		//Asks user if particular grade is known



		System.out.println("Do you know your Project grade?");

		String userConfirmation5 = keyboard.next();	



		if (userConfirmation5.equalsIgnoreCase("yes") || userConfirmation5.equalsIgnoreCase("y")) {

			System.out.println("Enter your Project grade");

			projGrade = keyboard.nextDouble();

			calculatedTotalWeight = exam1Weight + exam2Weight + finalExamWeight + labWeight + projWeight;



			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

					(finalExamGrade * finalExamWeight) + (labGrade * labWeight)  + (projGrade * projWeight));

		}

		else  {

			calculatedTotalWeight = exam1Weight + exam2Weight + finalExamWeight + labWeight;



		}







		//Asks user if particular grade is known



		System.out.println("Do you know your Participation grade?");

		String userConfirmation6 = keyboard.next();	



		if (userConfirmation6.equalsIgnoreCase("yes") || userConfirmation6.equalsIgnoreCase("y")) {

			System.out.println("Enter your Participation grade");

			participationGrade = keyboard.nextDouble();

			calculatedTotalWeight = exam1Weight + exam2Weight + finalExamWeight + labWeight + projWeight + participationWeight;



			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

					(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

					(participationGrade * participationWeight) + (projGrade * projWeight));		

		}

		else  {

			calculatedTotalWeight = exam1Weight + exam2Weight + finalExamWeight + labWeight + projWeight;



		}









		//Asks user if particular grade is known



		System.out.println("Do you know your Quiz grade?");

		String userConfirmation7 = keyboard.next();	





		if (userConfirmation7.equalsIgnoreCase("yes") || userConfirmation7.equalsIgnoreCase("y")) {

			System.out.println("Enter your Quiz grade");

			quizGrade = keyboard.nextDouble();

			calculatedTotalWeight = (exam1Weight + exam2Weight + finalExamWeight + labWeight + projWeight + participationWeight + quizWeight);



			sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

					(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

					(participationGrade * participationWeight) + (projGrade * projWeight) + 

					(quizGrade * quizWeight));		

		}



		else  {

			calculatedTotalWeight = (exam1Weight + exam2Weight + finalExamWeight + labWeight + projWeight + participationWeight);



		}





		if (userConfirmation4.equalsIgnoreCase("yes") || userConfirmation4.equalsIgnoreCase("y")){

		}

		else {

			calculatedTotalWeight -= labWeight ;

		}

		if (userConfirmation5.equalsIgnoreCase("yes") || userConfirmation5.equalsIgnoreCase("y")) {

		}

		else {

			calculatedTotalWeight -= projWeight; 

		}

		if (userConfirmation6.equalsIgnoreCase("yes") || userConfirmation6.equalsIgnoreCase("y")) {

		}

		else {

			calculatedTotalWeight -= participationGrade;

		}







		//System.out.println(sumOfWeightAndScore);

		//System.out.println(calculatedTotalWeight);





		//Formula to determine user's current grade

		currentAvgGrade = (sumOfWeightAndScore/ (calculatedTotalWeight));





		//Outputs current grade

		System.out.printf("Your current grade is: %.2f \n " , currentAvgGrade);







		//Outputs letter grade based on current grade

		if ((currentAvgGrade <= 100) && (currentAvgGrade >= 90)) {

			outGrade = 'A';

		}

		else if ((currentAvgGrade < 90) && (currentAvgGrade >= 80)) {

			outGrade = 'B';

		}

		else if ((currentAvgGrade < 80) && (currentAvgGrade >= 70)) {

			outGrade = 'C';	

		}

		else if ((currentAvgGrade < 70) && (currentAvgGrade > 60)) {

			outGrade = 'D';

		}

		else if ((currentAvgGrade <= 60) && (currentAvgGrade >= 0)) {

			outGrade = 'F';

		}

		else {



			System.out.println("Invalid grade input. Try again");

			System.exit(0);

		}

		System.out.println("Your grade is: " + outGrade);





		//More variable declarations

		double AvgToGradeValue;

		String desiredLetterGrade = minimumGradeScale.toUpperCase();



		//Calculates sum of all weights multiplied by score

		sumOfWeightAndScore = ((exam1Grade * exam1Weight) + (exam2Grade * exam2Weight) + 

				(finalExamGrade * finalExamWeight) + (labGrade * labWeight) + 

				(participationGrade * participationWeight) + (projGrade * projWeight) + 

				(quizGrade * quizWeight));



		//Calculate value needed to reach desired grade

		AvgToGradeValue = ((((100 * minGradeValue) - sumOfWeightAndScore))/((100 - calculatedTotalWeight)));



		//determines if grade will be achieved no matter what 

		if (currentAvgGrade > minGradeValue) {

			System.out.println("Your will receive a " + desiredLetterGrade + " no matter what" );

			System.exit(0);

		}

		else {



		}





		//Determines if it is possible to achieve grade

		if (AvgToGradeValue > 100) {

			System.out.println("Sorry you cannot recieve an " + desiredLetterGrade + " in this course");



		}

		else if ((AvgToGradeValue < 100) && (AvgToGradeValue > 0)) {

			System.out.printf("You must score an average greater than or equal to %.2f \nin the remaining graded items to receive a %s in this course", AvgToGradeValue, desiredLetterGrade); 

		}

		else {

			System.out.println("Congrats!!! you received the " + outGrade + " that you wanted!" );

		}



	}

}