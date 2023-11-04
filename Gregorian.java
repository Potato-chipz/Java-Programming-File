/*
 * Date: 09/29/2021
 * Programmer: Anny Zheng 
 * Purpose: To describe day and date through using the Gregorian Calendar. 
 */
import java.util.GregorianCalendar;
import java.util.Calendar;


public class Gregorian {

	public static void main(String[] args) {
		
		String daysOfWeek = "1 is Sunday, 2 is Monday, 3 is Tuesday, 4 is Wednesday, 5 is Thursday, 6 is Friday, 7 is Saturday."; //initialize a string that tells days of the week
		GregorianCalendar cal = new GregorianCalendar(2021, GregorianCalendar.SEPTEMBER, 29);//Today's date
		GregorianCalendar myBirthday = new GregorianCalendar(2003, GregorianCalendar.DECEMBER, 9);//My birthday
		
		System.out.println(daysOfWeek + "\n");//Display what the days of the week stand for. 1 is Sunday...7 is Saturday.
		
		int todayDayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int todayMonth = cal.get(Calendar.MONTH);
		int todayMonth1 = todayMonth + 1;
		int thisYear = cal.get(Calendar.YEAR);
		int todayWeekday = cal.get(Calendar.DAY_OF_WEEK);
		//Find today's date and corresponding day of the week. 
		
		System.out.println("Today's date is: " + thisYear + "/" + todayMonth1 + "/" + todayDayOfMonth);
		System.out.println("The corresponding day of the week is: " + todayWeekday + "\n");
		//Display today's date and the corresponding day of the week. 
		
		cal.add(Calendar.DAY_OF_MONTH,100);//Now cal is 100 days from today 
		
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		int month = cal.get(Calendar.MONTH);
		int month1 = month + 1;
		int year = cal.get(Calendar.YEAR);
		int weekday = cal.get(Calendar.DAY_OF_WEEK);
		//Find the date 100 days from today and its day of the week.
		
		System.out.println("Date 100 days from today: " + year + "/" + month1 + "/" + dayOfMonth);
		System.out.println("The corresponding day of the week is: " + weekday + "\n");
		//Display the date 100 days from today and its day of the week.
		
		int bdDayOfMonth = myBirthday.get(Calendar.DAY_OF_MONTH);
		int bdMonth = myBirthday.get(Calendar.MONTH);
		int bdMonth1 = bdMonth + 1;
		int bdYear = myBirthday.get(Calendar.YEAR);
		int bdWeekday = myBirthday.get(Calendar.DAY_OF_WEEK);
		//Find my birthday date and its corresponding day of the week.
		
		System.out.println("The date of my birthday is: " + bdYear + "/" + bdMonth1 + "/" + bdDayOfMonth);
		System.out.println("The corresponding day of the week is: " + bdWeekday + "\n" );
		//Display the date of my birthday and the corresponding day of the week. 
		
		myBirthday.add(Calendar.DAY_OF_MONTH,10000);//Now the myBirthday, a new birthday date, is 10000 days from my original date of birth.  
		
		int newBdDayOfMonth = myBirthday.get(Calendar.DAY_OF_MONTH);
		int newBdMonth = myBirthday.get(Calendar.MONTH);
		int newBdMonth1 = newBdMonth + 1;
		int newBdYear = myBirthday.get(Calendar.YEAR);
		int newBdWeekday = myBirthday.get(Calendar.DAY_OF_WEEK);
		//Find the date 10000 days from my birthday and its day of the week.
		
		System.out.println("The date 10000 from my birthday is: " + newBdYear + "/" + newBdMonth1 + "/" + newBdDayOfMonth);
		System.out.println("The corresponding day of the week is: " + newBdWeekday );
		//Display the date 10000 from my birthday and the corresponding day of the week. 
	}
	
}
