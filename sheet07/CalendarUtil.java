

public class CalendarUtil{

	public enum Months {
		JANUARY, FEBRUARY, MARCH, APRIL, MAY, JUNE, JULY, AUGUST, SEPTEMBER, OCTOBER, NOVEMBER, DECEMBER;
	}
	
	public enum Weekdays {
		SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY;
	}

	
	public static void main(String[] args) {
		
		System.out.println("Aufgabe 1 b)")
		System.out.println(getNthWeeekday(3).toString());
		System.out.println(getNthWeeekday(7).toString());
		System.out.println(getNthWeeekday(14).toString());
		
		System.out.println("Aufgabe 1 c)");
		System.out.println(isLeapYear(2020)); //true
		System.out.println(isLeapYear(2018)); //false
		System.out.println(isLeapYear(1800)); //false
		
		System.out.println("Aufgabe 1 d)");
		System.out.println(getDaysInMonth(Months.JUNE, 1941));
		System.out.println(getDaysInMonth(Months.FEBRUARY, 2018));
		System.out.println(getDaysInMonth(Months.FEBRUARY, 2020));
		System.out.println(getDaysInMonth(Months.JANUARY, 2018));
		
		System.out.println("Aufgabe 1 e)");
		System.out.println(dayInYear(1, Months.JANUARY, 2018));
		System.out.println(dayInYear(1, Months.MARCH, 2018));
		System.out.println(dayInYear(1, Months.MARCH, 2020));
		
		System.out.println("Aufgabe 1 f)");
		System.out.println(daysBetween(1, 1, 2018, 1, 1, 2018));
		System.out.println(daysBetween(1, 1, 2000, 1, 1, 2018));
		
		System.out.println("\nAufgabe 1 g)");
		System.out.println(getWeekdayFromDate(28, Months.NOVEMBER, 2018).toString());
		System.out.println(getWeekdayFromDate(16, Months.MAY, 1780).toString()); //TUESDAY
		System.out.println(getWeekdayFromDate(24, Months.APRIL, 1780).toString()); //MONDAY
		System.out.println(getWeekdayFromDate(21, Months.MAY, 2017).toString()); //SUNDAY
	}
	
	//Aufgabe b
	//returns the weekday with the given int-value%7
	public static Weekdays getNthWeeekday(int input) {
		
		return Weekdays.values()[input % 7];
	}
	
	//Aufgabe c
	//returns true if die input-year is a leap year
	public static boolean isLeapYear(int year) {

		return year%4 == 0 && year%100 != 0 || year%400 == 0;
	}
	
	//Aufgabe d
	//returns the days of the given month in the given year
	public static int getDaysInMonth(Months month, int year) {
		switch(month) {
			case JANUARY:
			case MARCH:
			case MAY:
			case JULY:
			case AUGUST:
			case OCTOBER:
			case DECEMBER:
			
				return 31;
		
			case APRIL:
			case JUNE:
			case SEPTEMBER:
			case NOVEMBER:
			
				return 30;
				
			case FEBRUARY:
				
				return isLeapYear(year) ? 29 : 28;
			
			default:
			
				return -1;
		}
		
	}
	
	//Aufgabe e
	//returns the number of the day in contrast to the whole year
	public static int dayInYear(int day, Months month, int year) {
		int dayCount = 0;
		int monthNumber = month.ordinal();
		
		for (int i = 0; i < monthNumber; i++) {
			dayCount += getDaysInMonth(Months.values()[i], year);
		}
			
		dayCount += day - 1;
		
		return dayCount;
	}

	//Aufgabe f
	//returns the number of days between each other
	public static int daysBetween(int day1, int month1, int year1, int day2, int month2, int year2) {
		Months month1AsEnum = Months.values()[month1 - 1];
		Months month2AsEnum = Months.values()[month2 - 1];
		
		int daysOfYearsBeetween = 0;
		
		if (year2 < year1) {
			
			return daysBetween(day2, month2, year2, day1, month1, year1);
		} else {
			for (int i = 0; i < year2 - year1; i++) {
				daysOfYearsBeetween += isLeapYear(year1 + i) ? 366 : 365;
			}
		}
		
		int day1InYear = dayInYear(day1, month1AsEnum, year1);
		int day2InYear = daysOfYearsBeetween + dayInYear(day2, month2AsEnum, year2);
		
		
		
		if (day2InYear - day1InYear < 0) {
			
			return daysBetween(day2, month2, year2, day1, month1, year1);
		} else {
			
			return day2InYear - day1InYear;
		}
		
	}

	//Aufgabe g
	//returns the weekday of the given Date
	public static Weekdays getWeekdayFromDate(int day, Months month, int year) {
		
		int dayIndex = daysBetween(28, 2, 1800, day, month.ordinal() + 1, year);
		
		if (year > 1800) {
			dayIndex += 4; //da 28.2.1800 Freitag war
		} else if (year == 1800) {
			if (month.ordinal() > 1) {
				dayIndex += 4; //da 28.2.1800 Freitag war
			} else {
				dayIndex %= 7;
				dayIndex = 11 - dayIndex; //da das gegebene Datum vor dem 28.2.1800 liegt wird rueckwaerts gezaehlt
			}
		} else {
			dayIndex %= 7;
			dayIndex = 11 - dayIndex; //da das gegebene Datum vor dem 28.2.1800 liegt wird rueckwaerts gezaehlt
		}
		
		return getNthWeeekday(dayIndex+1); //+1 sind KorrekturfaktorSSSS
	}

	
}




