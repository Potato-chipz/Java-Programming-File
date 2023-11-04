/*
 * Date: 09/25/2021
 * Programmer: AnnyZheng
 * Purpose: To calculate the area and the perimeter of a rectangle.
 */
import java.util.Scanner;

public class RectangleTester {
	
	public static void main (String args[]) {

		float length, width, area, perimeter;
		
		//Create scanner class object
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		
		//Input width and length of the rectangle
		System.out.print("Enter length of the rectangle: ");
		length = in.nextFloat();
		
		System.out.print("Enter width of rectangle: ");
		width = in.nextFloat();
		
		//Calculate perimeter of rectangle
		perimeter = 2 * (length + width);
		
		//Calculate area of rectangle
		area = length * width;
		
		//Print perimeter and area of rectangle 
		System.out.println("Perimeter of the rectangle is " + perimeter + " ft");
		System.out.println("Area of the rectangle is "+ area + " ft^2");
		
	}
		}
