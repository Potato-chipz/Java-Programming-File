/*
 * Author: Anny Zheng 
 * Date: 12/16/2021
 * Purpose: Prompt users to enter an integer greater than 2, and find the prime numbers from 2 up to the integer entered; contains proper error trapping when the input is not a valid integer
 */
import java.util.Scanner;
public class PrimeNumbers {

	public static void main (String args[]) {
		
		Scanner scanner = new Scanner (System.in); // set up a scanner for user input
		boolean decision = true; //user wants to run the program, 'false' means an user doesn't want the program to run
		String gatherPrime = ""; // output of prime numbers starting from 2 up to the integer entered
		
		String answer = "";// user's answer to continue the program or not 
		
		boolean isNumber = false; // check if user input is an integer, initially set it to 'false'
		int ip = 0; //initialize user input to 0
	
		
		boolean askQuestion = true;// the question will be prompted when the program first runs, then set to 'false' until user wants the program to run again, and the question will be prompted again; 'true' means question will be asked
		
		boolean integerG2 = true; // assume the integer entered is greater than 2
		

		while (decision) { //while an user wants the program to run
		
		if (askQuestion || isNumber || !(integerG2)) { //question will be prompted when an user wants to enter another integer input; or if the input is not an integer and that the user needs to re-enter; or if the integer entered is not greater than 2
		System.out.println("Please enter an integer that is greater than 2: ");
		askQuestion = false; // question won't be prompted again without user saying 'yes'
		}
		
		// user input
		String limit = scanner.next();
		
		//test if the input is an integer greater than 2
		try {
			ip = Integer.parseInt(limit); // the initialized input value is set to user input, which is an integer
			isNumber = true; //input is an integer, program continues to check if it's greater than 2
			
			if (ip > 2) { //integer input is greater than 2, program continues to find prime numbers
				integerG2 = true; 
			}
			if (ip <= 2) { //if input is an integer smaller than or equal to 2, program loops back to ask user to re-enter a valid input
				System.out.println("Invalid input because the integer enterd is not greater than 2. ");
				askQuestion = true;
				isNumber = false;
				integerG2 = false; //input not an integer greater than 2
			}
			
			if (integerG2) { //when input is an integer greater than 2, program continues to find prime numbers
			for(int num = 2; num <= ip; num++) { // the first for loop is going to go through numbers form 2 to the integer entered
				int numberOfFactors = 0;  //initialize numbers of factors to 0
				for (int factor = 1; factor <= num; factor++) { // the second for loop is going to calculate how many factors an integer has, starting from integer 2, up to the integer entered
					if (num % factor == 0 ) { // check if an integer is divisible by a whole number (that is less than or equal to the integer)  
						numberOfFactors++; // then the number of factors increased by 1
					}
				}
				if (numberOfFactors == 2) { //if an integer only has 2 factors, it's a prime number and will be added to a string (which will then be printed) 
				gatherPrime += num + " ";
				}
			}
			
			System.out.println("The prime numbers from 2 to " + limit + " are: " + gatherPrime ); //print prime numbers 
			
			
			System.out.println(""); //create a new line
			
			//Ask user if he/she wants to run the program again
			System.out.println("Do you want to enter a differnet integer that is greater than 2? Enter 'yes' to continue or anything else to exit: ");
			answer = scanner.next(); // user can answer 'yes' or 'no'
			}
			
			if (answer.equalsIgnoreCase("Yes")) { // program continues
				decision = true;
				askQuestion = true;
				gatherPrime = "";
			}
			else { // program ends
				decision = false;
				System.out.println("The program has ended."); 
				gatherPrime = "";
			}
		}
		
		catch (NumberFormatException e) { //when input is not an integer or less than 2, user will be notified and asked to enter a valid input
			System.out.print("Invalid input. ");
			isNumber = false;
			askQuestion = true;
		}
		
		
	}
	}
}
