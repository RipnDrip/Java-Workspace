/* CircleTester.java

 * Author: Terique Mick

 * Submission Date: 10/17/19

 *

 * Purpose: This program execute methods that give values and information about a circle in the Class "Circle.java".

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

public class CircleTester {

	public static final double THRESHOLD = 0.000000001;



	public static void main(String[] args) {



		Circle circle1 = new Circle();

		Circle circle2 = new Circle();

		circle1.setName("Circle 1");

		circle1.setX(2.0);

		circle1.setY(2.0);

		circle1.setRadius(2);

		

		

		circle2.setName("Circle 2");

		circle2.setX(3.0);

		circle2.setY(3.0);

		circle2.setRadius(3);

		System.out.println("circle1 = "+ circle1);

		System.out.println("circle2 = "+ circle2);



		// If the method setRadius is implemented correctly,

		// a call to setRadius with a negative number

		// will not change the value of the circle's radius.

		//

		circle1.setRadius(-2.0); 



		//This is a unit test.  It is best to have tests output pass or fail instead of just a bunch of values.

		//Notice how the double comparison is done

		if(Math.abs(2-circle1.getRadius()) < THRESHOLD)

			System.out.println("PASSED: Set Radius");

		else

			System.out.println("FAILED: Set Radius");



		//

		// Reset the center of circle1 (-3.0,4.0)

		//

		//circle1.setX(-3.0);

		//circle1.setY(4.0);



		

		// print circle1 characteristics (center and radius), use a statement similar 

		// to the previous println statements. Note that is not necessary to call

		//the method toString, why?



		// set the circle2 radius to 5.3

		

		circle1.setRadius(5.3);



		// print circle2 characteristics (center and radius), use a statement similar to the first and

		// second println statements



		// print circle1 diameter, area and perimeter

		System.out.println("\nThe diameter of Circle 1 is:" + circle1.diameter());

		System.out.println("The area of Circle 1 is:" + circle1.area());

		System.out.println("The perimeter of Circle 1 is:" + circle1.perimeter());





		// print circle2 diameter, area and perimeter

		System.out.println("\nThe diameter of Circle 2 is:" + circle2.diameter());

		System.out.println("The area of Circle 2 is:" + circle2.area());

		System.out.println("The perimeter of Circle 2 is:" + circle2.perimeter());





		// display whether circle1 is a unit circle

		System.out.println("\nIs Circle 1 a Unit Circle? True or False? " + circle1.isUnitCircle());



		// display whether circle2 is a unit circle

		System.out.println("Is Circle 2 a Unit Circle? True or False? " + circle2.isUnitCircle());

		// your additional tests should be placed below here.  Make sure to include at least 2-3 test cases

		// for each method you write.  It is best to write proper unit tests which print pass, fail for each

		// test instead of just dumping values to the screen.





		System.out.println("\nIs Circle 1 and 2 equal? True or False? " + circle1.equals(circle2));

		System.out.println("Is Circle 1 larger than, smaller than, or equal to Circle 2? " + circle1.compareTo(circle2));



		System.out.println("The distance between Circle 1 and 2 is: " + circle1.distance(circle2));

		System.out.println("Does Circle 1 and 2 intersect? True or False?: " + circle1.intersects(circle2));





		//unit testing for setName and getName

		circle1.setName("Test");

		if (circle1.getName().equalsIgnoreCase("TeSt")) {

			System.out.println("PASSED: Name Test");

		}

		else {

			System.out.println("FAILED: Name Test");

		}



		circle2.setName("Other Test");

		if (circle2.getName().equalsIgnoreCase("other TEST")) {

			System.out.println("PASSED: Name Test");

		}

		else {

			System.out.println("FAILED: Name Test");

		}



		circle1.setName("Last Test");

		if (circle1.getName().equalsIgnoreCase("LAst TeSt")) {

			System.out.println("PASSED: Name Test");

		}

		else {

			System.out.println("FAILED: Name Test");

		}





		//Unit testing for setX and getX

		circle1.setX(-3.5);

		if (Math.abs(-3.5-circle1.getX()) < THRESHOLD) {

			System.out.println("\nPASSED: setX and getX Test");

		}

		else {

			System.out.println("\nFAILED: setX and getX Test");

		}





		circle2.setX(-5.5);

		if (Math.abs(-5.5-circle2.getX()) < THRESHOLD) {

			System.out.println("PASSED: setX and getX Test");

		}

		else {

			System.out.println("FAILED: setX and getX Test");

		}



		circle1.setX(4.0);

		if (Math.abs(4.0-circle1.getX()) < THRESHOLD) {

			System.out.println("PASSED: setX and getX Test");

		}

		else {

			System.out.println("FAILED: setX and getX Test");

		}









		//Unit testing for setY and getY

		circle1.setY(-4.5);

		if (Math.abs(-4.5-circle1.getY()) < THRESHOLD) {

			System.out.println("\nPASSED: setY and getY Test");

		}

		else {

			System.out.println("\nFAILED: setY and getY Test");

		}





		circle2.setY(-8.5);

		if (Math.abs(-8.5-circle2.getY()) < THRESHOLD) {

			System.out.println("PASSED: setY and getY Test");

		}

		else {

			System.out.println("FAILED: setY and getY Test");

		}



		circle1.setY(7.0);

		if (Math.abs(7.0-circle1.getY()) < THRESHOLD) {

			System.out.println("PASSED: setY and getY Test");

		}

		else {

			System.out.println("FAILED: setY and getY Test");

		}









		//unit testing for diameter

		circle1.setRadius(2);

		if (Math.abs(4-circle1.diameter()) < THRESHOLD) {

			System.out.println("\nPASSED: Diameter Test");

		}

		else {

			System.out.println("\nFAILED: Diameter Test");

		}

		circle1.setRadius(4);

		if (Math.abs(8-circle1.diameter()) < THRESHOLD) {

			System.out.println("PASSED: Diameter Test");

		}

		else {

			System.out.println("FAILED: Diameter Test");

		}



		circle1.setRadius(-3.5);

		if (Math.abs(7-circle1.diameter()) < THRESHOLD) {

			System.out.println("PASSED: Diameter Test");

		}

		else {

			System.out.println("FAILED: Diameter Test");

		}



		//unit testing for Perimeter

		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(3.0);

		circle2.setRadius(1);



		double perimeterValue = circle1.perimeter();

		double perimeterValue2 =circle2.perimeter();



		if (Math.abs(perimeterValue-circle1.perimeter()) < THRESHOLD) {

			System.out.println("\nPASSED: perimeter Test");

		}

		else {

			System.out.println("\nFAILED: perimeter Test");

		}



		if (Math.abs(perimeterValue2-circle2.perimeter()) < THRESHOLD) {

			System.out.println("PASSED: perimeter Test");

		}

		else {

			System.out.println("FAILED: perimeter Test");

		}



		circle1.setX(3.0);

		circle1.setY(4.0);

		circle1.setRadius(1);

		perimeterValue = circle1.perimeter();

		if (Math.abs(perimeterValue-circle1.perimeter()) < THRESHOLD) {

			System.out.println("PASSED: perimeter Test");

		}

		else {

			System.out.println("FAILED: perimeter Test");

		}





		//unit testing for Area

		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(3.0);

		circle2.setRadius(1);



		double areavalue = circle1.area();

		double areaValue2 =circle2.area();







		if (Math.abs(areavalue-circle1.area()) < THRESHOLD) {

			System.out.println("\nPASSED: area Test");

		}

		else {

			System.out.println("\nFAILED: area Test");

		}



		if (Math.abs(areaValue2-circle2.area()) < THRESHOLD) {

			System.out.println("PASSED: area Test");

		}

		else {

			System.out.println("FAILED: area Test");

		}



		circle1.setX(3.0);

		circle1.setY(4.0);

		circle1.setRadius(1);

		double areaValue = circle1.area();

		if (Math.abs(areaValue-circle1.area()) < THRESHOLD) {

			System.out.println("PASSED: area Test");

		}

		else {

			System.out.println("FAILED: area Test");

		}



		//unit testing for Equals 

		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(1.0);

		circle2.setRadius(4);





		if (circle1.distance(circle2) < (circle1.getRadius() + circle2.getRadius()))  {

			System.out.println("\nPASSED: Equals Test");

		}

		else if (circle2.equals(circle1)) {

			System.out.println("PASSED: Equals Test (Circle 2 equals Circle 1)");

		}

		else {

			System.out.println("\nFAILED: Equals Test");

		}



		circle1.setX(3.0);

		circle1.setY(4.0);

		circle1.setRadius(3);



		circle2.setX(3.0);

		circle2.setY(4.0);

		circle2.setRadius(3);





		if (circle1.equals(circle2))  {

			System.out.println("PASSED: Equals Test");

		}

		else if (circle2.equals(circle1)) {

			System.out.println("PASSED: Equals Test (Circle 2 equals Circle 1)");

		}

		else {

			System.out.println("FAILED: Equals Test");

		}



		circle1.setX(2.0);

		circle1.setY(3.0);

		circle1.setRadius(2);



		circle2.setX(2.0);

		circle2.setY(5.0);

		circle2.setRadius(4);





		if (circle1.distance(circle2) < (circle1.getRadius() + circle2.getRadius()))  {

			System.out.println("PASSED: Equals Test");

		}

		else {

			System.out.println("FAILED: Equals Test");

		}



		//unit testing for Distance

		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(3.0);

		circle2.setRadius(1);



		double distanceValue = circle1.distance(circle2);

		double distanceValue2 = circle2.distance(circle1);



		if (Math.abs(distanceValue-circle1.distance(circle2)) < THRESHOLD) {

			System.out.println("\nPASSED: distance Test");

		}

		else {

			System.out.println("\nFAILED: distance Test");

		}



		if (Math.abs(distanceValue2-circle2.distance(circle1)) < THRESHOLD) {

			System.out.println("PASSED: distance Test");

		}

		else {

			System.out.println("FAILED: distance Test");

		}



		circle1.setX(3.0);

		circle1.setY(4.0);

		circle1.setRadius(1);

		perimeterValue = circle1.distance(circle2);

		if (Math.abs(perimeterValue-circle1.distance(circle2)) < THRESHOLD) {

			System.out.println("PASSED: distance Test");

		}

		else {

			System.out.println("FAILED: distance Test");

		}





		//unit testing for isSmaller(Circle anotherCircle)

		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(3.0);

		circle2.setRadius(4);





		double diameterValue = circle1.diameter();

		double diameterValue2 =circle2.diameter();







		if (circle1.diameter() < circle2.diameter()) {

			System.out.println("\nPASSED: Is Smaller Test");

		}

		else {

			System.out.println("\nFAILED: Is Smaller Test");

		}



		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(3.0);

		circle2.setRadius(4);



		if (circle2.diameter() < circle1.diameter()) {

			System.out.println("PASSED:  Is Smaller Test");

		}

		else if (circle2.diameter() - circle1.diameter() < THRESHOLD) {

			System.out.println("FAILED:  Is Smaller Test (Values are equal)");

		}

		else if ((circle2.diameter() - circle1.diameter()) < THRESHOLD) {

			System.out.println("FAILED:  Is Smaller Test (Values are equal)");

		}

		else {

			System.out.println("FAILED:  Is Smaller Test (Circle 2 is Larger) ");

		}



		circle1.setX(3.0);

		circle1.setY(4.0);

		circle1.setRadius(3);



		circle2.setX(3.0);

		circle2.setY(4.0);

		circle2.setRadius(3);

		if (circle1.diameter() < circle2.diameter()) {

			System.out.println("PASSED:  Is Smaller Test");

		}

		else if ((circle1.diameter() - circle2.diameter()) < THRESHOLD) {

			System.out.println("FAILED:  Is Smaller Test (Values are equal)");

		}

		else if ((circle2.diameter() - circle1.diameter()) < THRESHOLD) {

			System.out.println("FAILED:  Is Smaller Test (Values are equal)");

		}

		else {

			System.out.println("FAILED:  Is Smaller Test");

		}



		//unit testing for compareTo(Circle anotherCircle)

		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(3.0);

		circle2.setRadius(2);







		if (circle1.compareTo(circle2) > 0 ) {

			System.out.println("\nPASSED: Compare To Test");

		}

		else if (circle1.compareTo(circle2) < 0 ){

			System.out.println("\nPASSED: Compare To Test (Circle 1 is smaller than Circle 2)");

		}



		else if (circle1.compareTo(circle2) == 0) {

			System.out.println("\nPASSED: Compare To Test (Circle 1 is equal to Circle 2)");

		}

		else {

			System.out.println("\nFAILED: Input not valid");

		}







		circle1.setX(3.0);

		circle1.setY(4.0);

		circle1.setRadius(1);



		circle2.setX(1.0);

		circle2.setY(3.0);

		circle2.setRadius(2);



		if (circle1.compareTo(circle2) > 0 ) {

			System.out.println("PASSED: Compare To Test (Circle 1 is larger than Circle 2)");

		}

		else if (circle1.compareTo(circle2) < 0 ){

			System.out.println("PASSED: Compare To Test (Circle 1 is smaller than Circle 2)");

		}



		else if (circle1.compareTo(circle2) == 0) {

			System.out.println("PASSED: Compare To Test (Circle 1 is equal to Circle 2)");

		}

		else {

			System.out.println("FAILED: Input not valid");

		}



		circle1.setX(2.0);

		circle1.setY(3.0);

		circle1.setRadius(4);



		circle2.setX(2.0);

		circle2.setY(35.0);

		circle2.setRadius(2);



		if (circle1.compareTo(circle2) > 0 ) {

			System.out.println("PASSED: Compare To Test (Circle 1 is larger than Circle 2)");

		}

		else if (circle1.compareTo(circle2) < 0 ){

			System.out.println("PASSED: Compare To Test (Circle 1 is smaller than Circle 2)");

		}



		else if (circle1.compareTo(circle2) == 0) {

			System.out.println("\nPASSED: Compare To Test (Circle 1 is equal to Circle 2)");

		}

		else {

			System.out.println("FAILED: Input not valid");

		}



		//unit testing for intersects(Circle anotherCircle)

		circle1.setX(-3.0);

		circle1.setY(5.0);

		circle1.setRadius(2);



		circle2.setX(1.0);

		circle2.setY(1.0);

		circle2.setRadius(4);





		if (circle1.distance(circle2) < (circle1.getRadius() + circle2.getRadius()))  {

			System.out.println("\nPASSED: Intersect Test");

		}

		else {

			System.out.println("\nFAILED: Intersect Test");

		}



		circle1.setX(3.0);

		circle1.setY(4.0);

		circle1.setRadius(3);



		circle2.setX(3.0);

		circle2.setY(4.0);

		circle2.setRadius(3);





		if (circle1.distance(circle2) < (circle1.getRadius() + circle2.getRadius()))  {

			System.out.println("PASSED: Intersect Test");

		}

		else {

			System.out.println("FAILED: Intersect Test");

		}



		circle1.setX(2.0);

		circle1.setY(3.0);

		circle1.setRadius(2);



		circle2.setX(2.0);

		circle2.setY(5.0);

		circle2.setRadius(4);





		if (circle1.distance(circle2) < (circle1.getRadius() + circle2.getRadius()))  {

			System.out.println("PASSED: Intersect Test");

		}

		else {

			System.out.println("FAILED: Intersect Test");

		}





	} // main

} // circleTester

