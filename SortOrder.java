/*
 * Author: Anny Zheng 
 * Date: 12/01/2021
 * Purpose: Prompt users to enter three strings and arrange them in lexicographically order.
 */
import java.util.Scanner;
public class SortOrder {

	public static void main(String[] args) {
	
		Scanner myObj = new Scanner (System.in); // set up a scanner 
		System.out.print("Please enter 3 strings. Each string followed by the enter key and starts with a capital letter:\n");
		String a = myObj.nextLine();
		String b = myObj.nextLine();
		String c = myObj.nextLine(); //prompt an user to input three strings and store them 
		
		//if a is the fist out of the three strings, compared the other two and arrange them in lexicographically order 
		if (a.compareTo(b) < 0 && a.compareTo(c) < 0) {
			if (b.compareTo(c) < 0) {
			System.out.print(a + "\n" + b + "\n" + c);
			}
			else if (b.compareTo(c) > 0){ 
			System.out.print(a + "\n" + c + "\n" + b);	
			}
		} 
		//if b is the first out of the three strings, compared the other two and arrange them in lexicographically order 
		else if (b.compareTo(a) < 0 && b.compareTo(c) < 0) {
			if (a.compareTo(c) < 0) {
			System.out.print(b + "\n" + a + "\n" + c);
			}
			else if (a.compareTo(c) > 0) {
			System.out.print(b + "\n" + c + "\n" + a);
			}
			
		}
		//if c is the first out of the three strings, compared the other two and arrange them in lexicographically order 
		else if (c.compareTo(a) < 0 && c.compareTo(b) < 0) {
			if (a.compareTo(b) < 0) {
			System.out.print(c + "\n" + a + "\n" + b);
			}
			else if (a.compareTo(b) > 0) {
			System.out.print(c + "\n" + b + "\n" + a); 
			}
		}
	}
}
