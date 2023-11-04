/*
 * Author: Anny Zheng 
 * Date: 11/21/2021
 * Purpose: Prompt users to enter three inputs to complete a quadratic formula. Use the methods in Quadratic class to inform users if there's any discrminnat. If so, display the larger and the smaller of the two solutions.  
 */
import java.util.Scanner;
public class QuadraticTester {
	
	public static void main (String[] args) {
		
	Scanner myObj = new Scanner(System.in);//sets up the scanner for use.
	
	System.out.print("Please input your numerical value for a:  ");//Prompts user for the value of a and stores it.
	double a = myObj.nextDouble();
	
	System.out.print("Please input your numerical value for b: ");//Prompts user for the value of b and stores it. 
	double b = myObj.nextDouble();
	
	System.out.print("Please input your numerical value for c: ");//Prompts user for the value of c and stores it. 
	double c = myObj.nextDouble();
	
	Quadratic myQuadratic = new Quadratic(a,b,c); // Construct a Quadratic object.
	
	
	if (myQuadratic.hasSolutions() == false) {
		System.out.print("The discrminant is negative. There are no real solutions."); //Call the hasSolutions() method in Quadratic class to calculate the value of the discrminant. If the value is negative, tell users there're no solutions.   
	}
	else {
		System.out.println("The larger of the two solutions is:" + myQuadratic.getSoulution2());
		System.out.print("The smaller of the two solutions is:" + myQuadratic.getSoulution1()); // Call the getSolution1() and getSolution2() methods in Quadratic class; Find the larger and the smaller out of the two solutions. 
	}
	}
}
