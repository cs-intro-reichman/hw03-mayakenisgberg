
/** 
 * Prints the calendars of all the years in the 20th century.
 */
public class Calendar {	
    // Starting the calendar on 1/1/1900
	static int dayOfMonth = 1;   
	static int month = 1;
	static int year = 1900;
	static int dayOfWeek = 2;     // 1.1.1900 was a Monday
	static int nDaysInMonth = 31; // Number of days in January
	
	/** 
	 * Prints the calendars of all the years in the 20th century. Also prints the  
	 * number of Sundays that occured on the first day of the month during this period.
	 */
	public static void main(String args[]) 
    {
	    // #feedback: use camelCase for variables names
        int checkYear= Integer.parseInt(args [0]);
        int sundayCounter=0;
	while (year<checkyear)
         {
            advance();
         }
         while	(year==checkYear)
         {
		 System.out.print(dayOfMonth+"/"+month+"/"+year);
		 if(dayOfWeek==1)
		{
			System.out.print(" Sunday");
		}
		System.out.println();
		advance();
        }
    }

	 
	
	 // Advances the date (day, month, year) and the day-of-the-week.
	 // If the month changes, sets the number of days in this month.
	 // Side effects: changes the static variables dayOfMonth, month, year, dayOfWeek, nDaysInMonth.
	 private static void advance() 
	 {
		if(month==12 && dayOfMonth==31)// if you made it to the end of the year start a new one
		{
			year++;
			month=1;
			dayOfMonth=1;
		}
		else
		{
			// #feedback: use always {} to sceope content of condtion - even when there is only one line of code.
			if (dayOfMonth==nDaysInMonth)//if you made it to the end of the month start a new one, else advance
			{
				month++;
				if (month==13) {
					month=1;
				}
				nDaysInMonth=nDaysInMonth(month, year);
				dayOfMonth=1;
			}
			else {
				dayOfMonth++;
			}
		}
		if(dayOfWeek==7)//if you made it to the end of the week, start over
			dayOfWeek=1;
		else
			dayOfWeek++;

	} 
		 
    // Returns true if the given year is a leap year, false otherwise.
	private static boolean isLeapYear(int year) {
		boolean isLeapYear=false;
		isLeapYear = ((year % 400) == 0);
		isLeapYear = isLeapYear || (((year % 4) == 0) && ((year % 100) != 0));
	 	return isLeapYear;		
	}
	 
	private static int nDaysInMonth(int month, int year)
	 {
		switch (month)
		{
			// #feedback: you might use switch here like this:
			case 4:
			case 6:
			case 9:
			case 11:
				return 30;
			case 2: 
				if (isLeapYear(year)) {
					return 29;
				}
				else {
					return 28;
				}
			default:
				return 31
		}
	}
}
