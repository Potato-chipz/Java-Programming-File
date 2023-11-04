/*
 * Author: Anny Zheng 
 * Date: 10/19/2021
 * Purpose: Prompt an employee for information in order to calculate his or her weekly pay.  
 */
import java.util.Scanner;
public class EmployeeSalary {
	
	public static void main (String[] args) {
		
		double weeklyWage; //initialize a numerical variable called 'weeklyWage' to represent an employee's weekly wage
		
		Scanner myObj = new Scanner(System.in); //sets up a scanner for use. 
		
		System.out.print("Please enter your name: "); //prompts an employee to enter his or her name, and the program saves the name
		String name = myObj.nextLine();
		
		System.out.print("Please enter your hourly wage (in number): "); //prompts an employee to enter his or her hourly wage, and stores the value 
		double hourlyWage = myObj.nextDouble();
		
		
		System.out.print("What is your total regular hours worked, please enter a number (the maximum is 40): "); //prompts an employee to enter his or her total regular hours worked, and stores the value
		double totalRegularHour = myObj.nextDouble();
		
		System.out.print("If you have worked more than 40 hours this week, how many hours did you work overtime? If NOT please enter 0. \nYour response : "); //prompts an employee to enter any excess hours he or she works, and stores the value
		double overtimeHour = myObj.nextDouble();
		
		weeklyWage = (hourlyWage * totalRegularHour + (overtimeHour * (1.5 * hourlyWage))); //to calculate the total weekly income based on the information an employee enters 
		
		
		System.out.print("Based on your information entered, your weekly salary is: " + weeklyWage); // display to the console the employee's total weekly pay
	
	}

}
