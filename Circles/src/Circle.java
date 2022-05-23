/* Circle.java

 * Author: Terique Mick

 * Submission Date: 

 *

 * Purpose: This program holds methods that give values and information about a circle.

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

public class Circle {

	private String name;       // declare the private String instance  name

	private double radius;       // declare the private double instance  radius

	private double x;       // declare the private double instance  x

	private double y;       // declare the private double instance  y



	//Used to compare doubles.  Remember, don't compare doubles directly using ==

	public static final double THRESHOLD = 0.000000001;



	//----------------------------------------------

	// getName - returns the value of name

	//----------------------------------------------

	public String getName() {

		return name;	

	}



	//----------------------------------------------

	// getX - returns the value of x

	//----------------------------------------------

	public double getX() {

		return x;	

	}

	

	//----------------------------------------------

	// getY - returns the value of y

	//----------------------------------------------

	public double getY() {

		return y;	

	}



	//----------------------------------------------

	// getRadius - returns the value of radius

	//----------------------------------------------

	public double getRadius() {

		return radius;	

	}



	//----------------------------------------------

	// setName - assigns a new value to name

	//----------------------------------------------

	public void  setName(String name) {

		this.name = name;

	}



	//----------------------------------------------

	// setX - assigns a new value to x

	//----------------------------------------------

	public void setX(double x) {

		this.x = x; 

	}



	//----------------------------------------------

	// setY - assigns a new value to y

	//----------------------------------------------

	public void setY(double y) {

		this.y = y;	

	}





	//----------------------------------------------

	// setRadius - assigns a new value to radius

	//----------------------------------------------

	public void setRadius(double radius) {

		this.radius = Math.abs(radius);

	}



	//--------------------------------------------------------

	// area - returns the area of the circle

	//--------------------------------------------------------

	public double area() {

		double area = (Math.PI) * (radius * radius);

		return area;

	}



	//--------------------------------------------------------

	// perimeter - returns the perimeter of the circle

	//--------------------------------------------------------

	public double perimeter() {

		double perimeter = 2 * (Math.PI) * radius;

		return perimeter;

	}



	//--------------------------------------------------------

	// diameter - calculates the diameter of the circle

	//--------------------------------------------------------

	public double diameter() {

		double diameter	= radius + radius;

		return diameter;

	}





	//--------------------------------------------------------

	// isUnitCircle - return true if the radius of this circle

	//                is 1 and its center is (0,0) and false

	//      	      otherwise.

	//--------------------------------------------------------

	public boolean isUnitCircle() {

		//use this template method to compare... (Math.abs(radius - 1) < threshold) 

		if ((Math.abs(radius - 1) < THRESHOLD) && (Math.abs(x - 0) < THRESHOLD) && (Math.abs(y - 0) < THRESHOLD)) {

			return true;

		}

		else {

			return false;

		}





	}





	//--------------------------------------------------------

	// toString - return a String representation of

	//            this circle in the following format:

	//			  name: name

	//            center:(x,y)

	//            radius: r

	//--------------------------------------------------------

	public String toString() {

		return "Name: " + getName() + "\n" +

				"Center: " + "(" + getX() + "," + getY() + ")" + "\n" +

				"Radius: " + getRadius();

	}



	public boolean equals(Circle anotherCircle) {

		if (Math.abs(this.radius - anotherCircle.radius) < THRESHOLD) {

			return true;

		}

		else {

			return false;

		}

	}



	public double distance(Circle anotherCircle) {



		this.x = x;

		this.y = y;

		double x2 = anotherCircle.x;

		double y2 = anotherCircle.y;



		double xSquared = Math.pow((x-x2),2);

		double ySquared = Math.pow((y-y2),2);



		double distance = Math.sqrt((xSquared + ySquared));



		return distance;



	}





	public boolean isSmaller(Circle anotherCircle) {

		if (this.diameter() < anotherCircle.diameter()) {

			return true;

		}

		else {

			return false;

		}

	}



	public int compareTo(Circle anotherCircle) {

		if (this.diameter() > anotherCircle.diameter()) {

			return 1;

		}

		else if (this.diameter() < anotherCircle.diameter()) {

			return -1;

		}

		else {

			return 0;

		}



	}



	public boolean intersects(Circle anotherCircle) {

		if (this.distance(anotherCircle) < (this.radius + anotherCircle.radius)) {

			return true;

		}

		else {

			return false;

		}

	}



}//class

