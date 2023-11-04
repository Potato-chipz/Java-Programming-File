/*
 * Author: Anny Zheng
 * Date: 03/05/2022
 * Purpose: Prompts an user for the number of die tosses to generate, mark the (first) longest run, ask for re-prompt. 
 */

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class LongestRun {
	
	public static void main (String[] args) {
		
		Scanner scan = new Scanner(System.in); //scanner for user input
		int a = 0;//user input as an integer  
		
		boolean retry = true; 
		
		int longestStreak = 1;
		int temStreak = 1; //for comparison
		
		int LRS = 0; //longest runs start
		int CRS = 0; //current run start, in case if 2nd index represents the longest streak
		
		while (retry) {  //initially ask & re-prompt
			
			System.out.println("How may die tosses would you like to generate? Please enter an integer between 10 and 30, inclusive.");
			System.out.print("Your response: ");
			String trial = scan.next(); //#s of tie tosses
		
			retry = false; //no re-prompt
		
			//error check if input is an int b/t 1-30
			try {
				
				a = Integer.parseInt(trial);
			
				ArrayList<Integer> list = new ArrayList<Integer>();
			
				if (a <= 30 && a >= 10) {

					int min = 0;
					int max = 6;
				
					//simulate trial - 1 #s of die tosses
					for (int i = 0; i <= a-1; i++) {
						int rand = (int) Math.floor(Math.random()*(max-min+1)+min); //randomly generates number 10 t0 30, inclusive
						list.add(rand);
					}
				
					//find the # in the first longest streak & streak length
					for (int p = 0; p < list.size(); p++) {
						
					
						if (p != 0 && list.get(p)==list.get(p-1)) { //if the next int is = the previous
							
							temStreak++;
							
							//new longest streak appears
							if (temStreak > longestStreak) {
								longestStreak = temStreak;
								LRS = CRS; //set LRS to previous p, where the so-far longest streak starts 
							}	
						
						}
					
						else {
							temStreak = 1; //new streak, not necessary the longest
							CRS = p; //restart the CRS index, p for new start 
						}
					
					}
					
			
					
					//print the ideal list
					for(int e = 0; e < LRS; e++) {
						System.out.print(list.get(e) + " ");
					}
					System.out.print("( ");
					for(int f = LRS; f < (LRS + longestStreak); f++) {
						System.out.print(list.get(f) + " ");
					}
					System.out.print(") ");
					for(int g = LRS + longestStreak; g < list.size(); g++) {
						System.out.print(list.get(g) + " ");
					}
					System.out.println(""); // create an empty line 
					
				
					//Ask user to run the program again or not 
					System.out.print("\nDo you want to run the program again? Enter 'Y' to continue or anything else to stop. \nYour response: ");
					String again = scan.next();
				
					if(again.equalsIgnoreCase("Y")) {
						System.out.println(""); // empty line
						longestStreak = 0;
						a = 0; //# of die toss
						LRS = 0;
						CRS = 1;
						retry = true; //reset values
					}
					else {
						System.out.println("Program is completed...");
					}
					
				
				} //10-30 if statement ends
			
				else { //re-prompt the question & reset values
					System.out.println("Invalid Input. Try again.\n");
					longestStreak = 0;
					a = 0; 
					LRS = 0;
					CRS = 1;
					retry = true;
				}
			
			}
		
			catch (NumberFormatException e) { //re-prompt the question & reset values
				System.out.println("Invalid Input. Try again.\n");
				longestStreak = 0;
				a = 0; 
				LRS = 0;
				CRS = 1;
				retry = true;
			}
		
		
	 	
		} //while loop ends 
		
		
	}
	
}

