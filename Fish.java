import java.util.*;
/** @author Jon */
public class Fish implements Comparable
{
	// data members (variables)
	String name;
	String species;
	String color;
	int fins;
	
	public static int count=0;
	
	// member functions
	
	// constructor
	/** @param n name of the fish
	    @param s species of the fish
		@param c color of the fish (as a String)
		@param f the number of fins */
	public Fish(String n, String s, String c, int f)
	{
		name=n;
		species=s;
		color=c;
		fins=f;
		count++;
	}
	
	public Fish(Scanner confusion)
	{
		name=confusion.next();
		species=confusion.next();
		color=confusion.next();
		fins=confusion.nextInt();
		count++;
	}
	
	// accessors
	public void print()
	{
		System.out.println("Fish: name="+name+" species="
		  + species + " color="+color+ " #fins="+fins);
	}
	
	/** @return the name of the fish */
	public String getName() { return name; }
	/** @return the species of the fish */
	public String getSpecies() { return species; }
	/** @return the color of the fish */
	public String getColor() { return color; }
	/** @return the number of fins */
	public int getFins() { return fins; }
	
	public int compareTo(Object x)
	{
		if(x instanceof Fish)
		{
			Fish f;
			f=(Fish)x;
			// by # of fins
			if(fins<f.getFins()) return -1;
			if(fins==f.getFins()) return 0;
			return 1;
			// by species in alphabetical order
			// return species.compareTo(f.getSpecies());
		}
		else
		{
			System.out.println("Error: can't compare to non-Fish.");
			System.exit(1);
			return 0;  // only to make the compiler happy
		}
	}
	
	// mutator
	
	public void sharkAttack()
	{
		if(fins>0) fins--;
	}
	
	/** causes the fish to grow a fin due to toxic waste */
	public void toxicWaste()
	{
		fins++;
	}	
}