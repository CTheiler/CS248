import java.util.*;
import java.io.*;

public class camper implements Comparable
{
	int age;
	String name;
	char diet;
	
	public int compareTo(Object x)
	{
		if((x) instanceof camper)
		{
			camper c;
			c=(camper)x;
			
			String tempname = c.getName();
			if(name.compareTo(tempname)<0)
				return -1;
			if(name.compareTo(tempname)==0)
				return 0;
			if(name.compareTo(tempname)>1)
				return 1;
		}
		else
		{
			System.out.println("Error: non-camper entered");
			return 0;
		}
		return 0;
	}
	
	public camper(String n, int a, char d)
	{
		age = a;
		name = n;
		diet = d;
	}
	
	public camper(Scanner input)
	{
		name = input.next();
		age = input.nextInt();
		diet = input.next().charAt(0);
	}
	
	private class node
	{
		public Comparable data;
		public node next;
	}
	
	public String getName()
	{
		return name;
	}
	
	public char getDiet()
	{
		return diet;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public void print(camper x)
	{
		System.out.println("Name : " + x.getName() + " Age: " + x.getAge() + " Diet: " + getDiet());
	}
}
