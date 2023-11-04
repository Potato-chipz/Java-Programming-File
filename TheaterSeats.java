import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;

public class TheaterSeats {
	
	public static void main (String[] args) {
		
		final int ROW = 9;
		final int COLOUM = 10;
		System.out.println("       ---Theater Seating Chart---");
		System.out.println("       --------Seat Number--------"); 
		System.out.println("       1  2  3  4  5  6  7  8  9 10"); // print seat #s
		
		int[][] theater = {
				{10,10,10,10,10,10,10,10,10,10},
				{10,10,10,10,10,10,10,10,10,10},
				{10,10,10,10,10,10,10,10,10,10},
				{10,10,20,20,20,20,20,20,10,10},
				{10,10,20,20,20,20,20,20,10,10},
				{10,10,20,20,20,20,20,20,10,10},
				{20,20,30,30,40,40,30,30,20,20},
				{20,30,30,40,50,50,40,30,30,20},
				{30,40,50,50,50,50,50,50,40,30},
		};
		
		//print out the 2D array 
		for(int i = 0; i < ROW; i++) {
			
			for (int j = 0; j < COLOUM; j++) {
				
				if (j == 0) {
					System.out.print("row " + (ROW-i) + " "); //print row #
				}
				
				System.out.print(theater[i][j] + " ");
				
				if (j == COLOUM - 1) {
					
					System.out.println("");
				}
			}
			
		} //end to print out 2D array 	
		
		//prompt to pick either a seat, price, or quit
		
		Scanner scan = new Scanner(System.in);
		int r = 0; //int for row compare 
		int sn = 0; //int for seat # compare
		int p = 0; //for price int compare 
		
		boolean q1 = true; // s, p ,or q
		boolean q2 = true; // s->row
		boolean q3 = true; //s->seat # 
		boolean q4 = true; //p 
		boolean findP = true; //find the 1st price entered   
		
		while(q1) {
			
		System.out.println("");
		System.out.print("Please select a (s)eat, (p)rice, or (q)uit: ");
		String res = scan.next(); //response to the initial question 
		 
		q2 = true; //when q1 re-prompt. program continues
		
		//if user wants to select a seat 
		if (res.equalsIgnoreCase("s")) {
			
			while (q2) {
		
				//prompt for specific row and seat # 1-9
				System.out.print("Please slelect a row form 1 to 9. Row #: ");
				String UR = scan.next(); //user row input 
			
				q2 = false;
				q3 = true;
				
				//error trap the row # user enters 
				try { 
				
					r = Integer.parseInt(UR);
				
					// then, ask user to select a seat #, display proper info and re-prompt: wrong input or DONE
					
						if (r >= 1 && r <= 9) {
					
							while (q3) {
								System.out.print("Pick a seat number from 1 to 10: ");
								String SN = scan.next();
								
								q3 = false;
					 
								//need to error trap seat # before print...
								try {
									sn = Integer.parseInt(SN);
								
									if (sn >= 1 && sn <= 10) {
										
										if (theater[Math.abs(ROW-r)][Math.abs(sn-1)] != 0) {
											
											System.out.println("You have purhased row: " + r + ", seat: " + sn + ", the price of the ticket is: $" + theater[Math.abs(ROW-r)][Math.abs(sn-1)]);
											System.out.println("\n");
							
											theater[Math.abs(ROW-r)][Math.abs(sn-1)] = 0;
							
											//print out the update 2D array 
											System.out.println("       ---Theater Seating Chart---");
											System.out.println("       --------Seat Number--------"); 
											System.out.println("       1  2  3  4  5  6  7  8  9 10");
										
											for(int i = 0; i < ROW; i++) {
												for (int j = 0; j < COLOUM; j++) {
													if (j == 0) {
														System.out.print("row " + (ROW-i) + " ");
													}
													if (theater[i][j] == 0) {
														System.out.print(" ");
													}
													System.out.print(theater[i][j] + " ");
													if (j == COLOUM - 1) {
														System.out.println("");
													}
												}
											
											} //end to print out 2D array 
							
											q1 = true; //re-prompt s,p,q Question
										
										}
										
										//if the spot is already sold out 
										else {
											
											System.out.println("Sorry. The spot has already been purchased. Please select another one.");
											q2 = true;
											
										}
									
									}
									
									//if the seat input is an int but not (1,9)
									else {
										
										System.out.println("Invalid input. Try again.\n");
										q3 = true;
									}
								}
					
								catch (NumberFormatException e) {
									System.out.println("Please pick a seat number (integer) between 1 to 10, inclusive.");
									q3 = true;
								}
					
						  } // q3 while loop ends 
					
						} //if statement after row to select seat # ends 

						else {
					
							System.out.println("Invalid input. Try again.");
							q2 = true;
						}
				
				}
			
					//if the input for row # is not int from 1-9
					catch (NumberFormatException e) {
				
						System.out.println("The input for the row number should be an int between 1 to 9, inclusive.");
						q2 = true;
				
					}
				
			  } // while loop for q2 ends 
				
			} //all scenarios for "s" covered 
		
		else if (res.equalsIgnoreCase("p")) {
				
		  q4 = true;
		  findP = true;
		  
		  while (q4) {
			  
			System.out.print("Please enter a valid seat price (10/20/30/40/50): $");
			String vsp = scan.next();	
			
			
			//error trap s.p. as int 
			try {
				
				p = Integer.parseInt(vsp);
				
				//loop the 2D array to find the seat with a price entered 
				if (p % 10 == 0 && p >= 10 && p <= 50) {
					
					q4 = false;
					findP = true;
					int countP = 0;
					
					//count how many seats with that price 
					for (int e = 0; e < ROW; e++) {
						for (int f = 0; f < COLOUM; f++){
							if (theater[e][f] == p) {
								countP++;
							}
						}
					}
					
					//all seats of a price are sold out 
					if (countP == 0) {
							System.out.println("Sorry, all tickets for the price have sold out. Please enter another price.");
							findP = false;
							q4 = true;	
					}
					
					while (findP) {
					   	
						
						for(int c = 0; c < ROW; c++) {
							for (int d = 0; d < COLOUM; d++) {
									
									if(theater[c][d] == p && findP == true) {
										
										System.out.println("You have purchased row: " + Math.abs(ROW-c) + ", seat " + Math.abs(d+1) + ", for a price of: $" + p);
										theater[c][d] = 0; //seat is purchased 
										findP = false;
										
										System.out.println("");
										
										//print out the update 2D array 
										System.out.println("       ---Theater Seating Chart---");
										System.out.println("       --------Seat Number--------"); 
										System.out.println("       1  2  3  4  5  6  7  8  9 10");
										for(int i = 0; i < ROW; i++) {
											for (int j = 0; j < COLOUM; j++) {
												if (j == 0) {
													System.out.print("row " + (ROW-i) + " ");
												}
												if (theater[i][j] == 0) {
													System.out.print(" ");
												}
												System.out.print(theater[i][j] + " ");
												if (j == COLOUM - 1) {
													System.out.println("");
												}
											}
										} //end to print out 2D array
										
										q4 = false;
										q1 = true; //re-prompt the initial question		
										
									} //end of the if loop to locate the seat 
											 	 
							}
							
						} //nested for loop to find seat with that price 
					  
					} //findP while loop 
					
				} // if statement to find the seat 
				
				//if a valid price is not entered 
				else {
					
					System.out.println("Invalid input. Try again.");
					q4 = true;
				}
				
			}
			
			//if the price entered is not valid.
			catch(NumberFormatException e) {
				
				System.out.println("Invalid input. Try again.");
				q4 = true;
				
			}
			
		 } //while loop for q4
			
		} //all scenarios for "p" covered 
		
		else if (res.equalsIgnoreCase("q")) {
			
			System.out.println("Porgram is completed....");
			q1 = false;
			
		} //all scenarios for "q" covered 
		
		//re-prompt the initial question 
		else { 
			
			System.out.print("Invalid input. Try again.\n");
			q1 = true;
			
		}

	  } //while loop for q1 ends
			
	} //main class
	
}

