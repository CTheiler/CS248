import java.util.*;
import java.io.*;

public class LaFood
{	
	
	public static void main(String[] args) throws IOException
	{
		System.out.println("Please input the .txt file of the simulation: ");
		Scanner input = new Scanner(System.in);
		String filename = input.next();
		System.out.println("Recieved the file name, loading the simulation: \n");

		Queue q = new QueueDonut();
		Scanner g = new Scanner(new FileReader(filename));
		int count=0;
		int time = 0;
		int partysize=0;
		double totmins=0;
		double totalseated=0;
		
		while(g.hasNext())
		{
			char status = g.next().charAt(0);
			if(status == 'A')
			{	
				customer hemp = new customer(g);
				q.enqueue(hemp);
				hemp.print();
				count++;
			}
			else if (status == 'T')
			{
				customer seating = (customer)q.dequeue();
				time = g.nextInt();
				seating.printSeat(seating.getName(), time);
				partysize = seating.getSize();
				totalseated+=seating.getSize();
				totmins += partysize*(time-seating.getTime());
			}	
		}
		
		double averaget = totmins / totalseated;
		System.out.print("The average waiting time was: ");
		System.out.printf("%.2f", averaget);
		System.out.print(" minutes. \n");
		
		System.out.println("The following parties were never seated: ");
		while(!q.isEmpty())
		{
			customer unseated = (customer)q.dequeue();
			unseated.printUnSeat(unseated.getName(),unseated.getSize());
		}
		
		System.out.println("Have a nice meal!");

	}
}