/*
 * Author: Anny Zheng
 * Date: 02/28/2022
 * Purpose: Generate a random ArrayList, all integers add up to a sum of 45; sort the ArrayList until it's ranging 1-9, in order.  
 */

import java.util.ArrayList;
import java.util.Random;

public class BulgarianSolitaire {
	
	public static void main (String[] args) {
		
		//for comparison, ArrayList ranges 1-9
		ArrayList<Integer> compare = new ArrayList<Integer>();
			
			for (int i = 1; i <= 9; i++) {
				compare.add(i);
			}
			
		// ArrayList for configuration
			
		ArrayList<Integer> piles = new ArrayList<Integer>();
		
		int min = 1;
		int max = 45; //generate random #s 1-45
		
		//generate an ArrayList of random integer(s) from 1 to 45, inclusive
		while (max > 0) {
			int rand = (int)Math.floor(Math.random()*(max-min+1)+min);
			piles.add(rand);
			max = max-rand;
		}
		
		System.out.println("Original Array: " + piles);
		
		int trial = 0; //trial(s) of configuration
		
		
		while (compare.equals(piles) != true) {
			
			trial++;
			
			//loop to add new int at the end
			for(int i = 0; i < piles.size(); i++) {
			
				piles.set(i, piles.get(i)-1);//every int -1
					
			}
			
			piles.add(piles.size()); //add an accumulated int at the end
			
			//remove index 0
			for(int i = 0; i < piles.size(); i++) { 
				
				if (piles.get(i) == 0) {
					piles.remove(i);
					i--;
				}
				
			}
		
			System.out.println("Configuration # " + trial + " = " + piles);
		
		} //2nd while loop ends
		
		System.out.print("Program Completed...");
	
	}
	
}
