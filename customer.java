import java.util.*;
import java.io.*;

public class customer
{
	char status;
	int time;
	int size;
	String name;
	
	public static int count = 0;
	
	public customer(char s, int t, int si, String n)
	{
		status = s;
		time = t;
		size = si;
		name = n;
	}
	
	public String getName() 
	{ 
		return name; 
	}
	/** @return the species of the fish */
	public int getTime() 
	{ 
		return time; 
	}
	/** @return the color of the fish */
	public int getSize() 
	{ 
		return size; 
	}
	/** @return the number of fins */
	public char getStatus() 
	{ 
		return status; 
	}
	
	public void print()
	{
		System.out.println("Please wait at the bar, \n party " + name + " of size " + size );
	}
	
	public void printSeat(String name, int time)
	{
		System.out.println("Table for " + name + "! (time " + time + ")");
	}
	
	public void printUnSeat(String name, int size)
	{
		System.out.println("Party: " + name + " of size " + size + " people.");
	}
	
	public customer(Scanner input)
	{
		time = input.nextInt();
		size = input.nextInt();
		name = input.nextLine();
	}
}
