/*
 * Author: Anny Zheng
 * Date: 01/13/2022
 * Purpose: Find the word (if has one) that an user requests in a string input (at least 30 characters). Find its first occurrence and how many times it exists. 
 */
import java.util.Scanner;
public class TargetWord {
	
	public static void main (String[] args) {
		
		boolean prompt = true; //prompt user to enter a sentence
		boolean first = true;
		int count = 0; //number of times the target word appears
		String input = ""; //upper case of the string input
		String search = "";//upper case of the target word input
		String copy = "";//to find the first occurrence
		
		while(prompt) { //when program runs
		Scanner scanner = new Scanner(System.in);//store user string input
		System.out.print("Please enter a sentence with at least 30 characters: ");
		String str = scanner.nextLine(); //string entered
		input = str.toUpperCase();//so case doesn't matter 
		copy = input;//a copy of string 
		
		if (str.length() >= 30) { //if the sentence has more than 30 characters
			
			prompt = false;//program won't re-generate unless user say 'yes'
			System.out.print("The word that you're looking for: ");
			String target = scanner.next();//store target word 
			search = target.toUpperCase();//so case doesn't matter
			
			if(input.contains(search)) { //if the string has the target word
			
			//check the whole string for the target word 
			while(target.length() <= input.length()) {
				
				
				if (input.contains(" ")) { //if the original or the updated string has the target word
					
				int space = input.indexOf(" ");
				String part = input.substring(0,space);//based on the location of the space, search target word in a limited range before the space
				
				if (part.contains(search)) { //'search' is the upper-case version of 'target'; check if the newly update string includes the target word 
					
					
					if( (space - search.length()) == 0  && input.indexOf(search) == 0) { // if the target word is not within another word
					
					count ++;
					input = input.substring(space + 1);//sentence is cut short
					
					if(first) { 
						int other = copy.indexOf(input); 
						System.out.println("The first occurrence of the word ' " + target + " ' is at index: " + (other-1-search.length())); //1st occurrence of the target word
						first = false;
					}
					}
					else {
						input = input.substring(space + 1);//if the target word is within a word, ignore and move on; sentence is cut short
					}
		
				}
				else { //if target word is not found, move on; sentence is cut short
					input = input.substring(space + 1);	
				}
				}
				
				else { //word search has ended, display proper information, ask user if want to re-run the program
					if (input.contains(search)) {
						count++; //if the target word is at the end of the string
					}
					input = ""; 
					System.out.println("The target word has appeared " + count + " times.");//display how many times the target word occurs
					System.out.println("");//create a line
					System.out.println("Do you want the program to run again? Enter 'yes' to continue or anything else to stop the program."); //prompt users if want to run the program again
					String runAgain = scanner.next();
					
					//initialize variables, program runs again
					if(runAgain.equalsIgnoreCase("yes")) {
						prompt = true;
						first = true;
						count = 0;//reset count to 0
					}
					else {
						System.out.print("Program has been terminated."); //program ends
					}
				}
			}
			}
			
			//when the target word is not found in the initial string entered
			else { 
				System.out.println("The target word is not found in the sentence.");
				System.out.println("Do you want the program to run again? Enter 'yes' to continue or anything else to stop the program."); //loops starts
				String runAgain = scanner.next();//ask users if want to run the program again 
				
				//initialize variables, program runs again
				if(runAgain.equalsIgnoreCase("yes")) {
					prompt = true;
					first = true;
					count = 0;//reset count to 0
				}
				else {
					System.out.print("Program has been terminated.");//program ends
				}
			}
		}
		
		//sentence does not have 30 characters, re-prompt the question
		else {
			System.out.println("The sentence has less than 30 characters. Try again.");
			prompt = true; 
		}
		}
		
	}
}
