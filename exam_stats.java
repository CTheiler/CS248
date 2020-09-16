import java.io.*;
import java.util.*;

/* @author Colin */

class exam_stats
{
	static void lettergrade(double grades[], int A, int B, int C, int D, int F)
	{
		for(int i=0; i<grades.length; i++)
		{
			if(grades[i]<60)
				F++;
			if(grades[i]>=60 && grades[i]<70)
				D++;
			if(grades[i]>=70 && grades[i]<80)
				C++;
			if(grades[i]>=80 && grades[i]<90)
				B++;
			if(grades[i]>=90)
				A++;
		}
		System.out.println("\nNumber of Scores per Letter grade \n A: "+A+"\n B: "+B
		+"\n C: "+C+"\n D: "+D+"\n F: "+F);
	}
	
	//I got this from my github from high school
	public static void SelSort(double grades[], int pos)
    {
        //If the position has passed the array length
        if (pos >= grades.length)
        {
        	//Return Nothing, but breaks the loop
        	return;
        }
        
        //Set the position of the minimum value to the position for the Selection Sort
        int minpos = pos;
        
        //Creates a for loop comparing the array at i to the position of the minimum value
        for ( int i = pos; i < grades.length; i++ )
        {
        	//If the array at i is less than the array at the minimum's position
            if (grades[i] < grades[minpos] )
            {
            	//Sets the new position for minimum to i
                minpos = i;
            }

        }
		//Sets a temporary value to the value at the beginning position
        double temp = grades[pos];
        //Sets the value at the starting position of the array to the minimum value in the array found through the for loop
        grades[pos] = grades[minpos];
        //Swaps the array's starting position value with the position that the minimum value was at
        grades[minpos] = temp;
        //Calls upon the function but increases the position 
        SelSort(grades, pos + 1);
	}
	
	static void findMedian(double grades[])
	{
		for(int i=0; i<grades.length; i++)
		{
			System.out.println(grades[i]);
		}
		double median;
		if(grades.length%2==0)
		{
			
			int temp = (grades.length-1)/2;
			double holder = grades[temp];
			temp++;
			double holder2 = grades[temp];
			median = (holder + holder2)/2;
		}
		else
		{
			int temp = grades.length/2;
			temp++;
			median = grades[temp];
		}
		System.out.println("The median is: " + median);
	}
	
	static double gradecalc(double grades[], double minimum, double maximum)
	{
		double total = 0;
		for(int i=0; i<grades.length; i++)
		{
			total += grades[i];
			if(grades[i]<minimum)
				minimum=grades[i];
			if(grades[i]>maximum)
				maximum=grades[i];
		}
		double average;
		average=total/grades.length;
		
		System.out.println("Minimum Score: " + minimum+ "\n Maximum Score: " + 
		maximum + "\n Average Score: " + average);
		
		return average;
	}
		
	public static void main(String[] args) throws IOException
	{
		System.out.println("~~~~ Welcome to the Exam Grade Helper! ~~~");
		
		int scores;
		int A =0, B=0, C=0, D=0, F=0;
		
		Scanner cin = new Scanner(System.in);
		System.out.println("Enter input file name->");
		String infile;
		infile=cin.next();
		
		Scanner g;
		g=new Scanner(new FileReader(infile));
		int i=0;
		int size = g.nextInt();
		double[] grades = new double[size];
		
		while(g.hasNext())
		{
			grades[i]= g.nextDouble();
			i++;
		}
		
		SelSort(grades, 0);		
		lettergrade(grades, A,B,C,D,F);
		
		double minimum = 100;
		double maximum = 0;
		int grade_count = grades.length;
		double  avg_grade = gradecalc(grades, minimum, maximum);
		findMedian(grades);

		System.out.println("There are " +grade_count+ " grades in the gradebook");
	}
}
		