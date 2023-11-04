/*
 * Date: 09/25/2021
 * Programmer: AnnyZheng
 * Purpose: To replace letters with symbols, a with @, i with !, and s with $.
 */
public class ReplaceTester {
	
	public static void main(String[] args) {
		
		String str = "I like Mississippi the best among all states in America because the Mississippi river is pretty cool. Mississippi has the best flavor of ice cream I have ever had in my life."; //To initialize a string that has 30 characters.
		String str1 = str;
		String str2 = str1;
		String str3 = str2;
		
		str = str.toLowerCase();
		System.out.println("Orginal string is: " + str);
		
		str1 = str.replace('a', '@');
		str2 = str1.replace('i', '!');
		str3 = str2.replace('s', '$');
		
		System.out.print("The modified string is: " + str3);	
		
	}
}