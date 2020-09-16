import java.util.*;
import java.time.LocalDateTime;

/** 
	Method Implementation class for the dating program assignment
	@author Colin Theiler 
*/
public class MyDate implements DateInterface
{
	//creates the integers date, dow, month & year
	int date;
	int dow;
	int month;
	int year;
	
	
	public int getDay()
	{
		//@return the date
		return date;
	}
  
	public int getDow()
	{
		//@return the date of the week
		return dow;
	}
  
	public int getMonth()
	{
		//@return the month
		return month;
	}
  
	public int getYear()
	{
		//@return the year
	   return year;
	}
	
	//Sets the values of date, dow, month and year to the inputted values
	public void set(int m, int d, int y, int w)
	{
		//I subtracted one from the month to comply with the String Arrays in my print function
		m--;
		date=d;
		dow=w;
		month=m;
		year=y;
	}
	
	/** moves the date forward by exactly one day */
	public void tomorrow()
	{
		//I made date of the week separate from the month, year and date because it is independent of those values
		dow++;
		if (dow>6)
		{
			dow=0;
		}
		
		//Advances the year if the month is December and the date is 31
		if(month==11 && date==31)
		{
			date=1;
			month=0;
			year++;
		}
		/*
			If the year is divisible by 4, it is a leap year. This if statement will move the month to march if it is
			February and the date is the 29th
		*/
		else if(month==1 && date==29 && year%4==0)
		{
			date=1;
			month++;
		}
		//This function handles february on a non-leap year
		else if (month==1 && date==28 && year%4!=0)
		{
			month++;
			date=1;
		}
		/*
			Tests if the month is April, June, September or November (the months with 30 days) and will advance the month
			if the date is 30
		*/
		else if(month==3 | month==5 | month==8 | month==10 && date==30)
		{
			date=1;
			month++;
		}
		/*
			At this point the only case that is left is if the month has 31 days. This else if statement tests if the date
			is 31 and advance the month if so
		*/
		else if(date==31)
		{
			date=1;
			month++;
		}
		//Advances the date
		else
			date++;
	
	}
	
	//function that allows for the ability to print an object
	public String toString()
	{
		//Creates String arrays that store the names of all the months and days of the week
		String[] days={"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
		String[] months={"January", "February", "March", "April", "May", "June", "July", "August",
		"September", "October", "November", "December"};
		
		return days[dow]+", "+months[month]+" "+date+", "+year;
	}
	
	/* moves the date backwords by exactly one */
	public void yesterday()
	{
		dow--;
		if(dow<0)
		{
			dow=6;
		}
		
		if(month==0 && date==1)
		{
			month=11;
			date=31;
			year--;
		}
		else if(month == 4 | month == 6 | month == 8 | month == 10 && date==1)
		{
			month--;
			date=30;
		}
		else if (month == 2 && year%4==0 && date==1)
		{
			month = 1;
			date=29;
			if(year!=2000 && year%100==0)
			{
				month=1;
				date=28;
			}
		}
		else if(month == 2 && year%4!=0 && date==1)
		{
			month=1;
			date=28;
		}
		else if(date==1)
		{
			month--;
			date=31;
		}
		else
			date--;
	}
  }