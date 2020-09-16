import java.io.*;
import java.util.*;

class QueueMain
{
	
	
	public static void main(String [] args) throws IOException
	{
		Scanner fishreader=
		  new Scanner(new FileReader("fishfile.txt"));
		int fishcount=fishreader.nextInt();
		
		Queue Q=new QueueDonut();
		
		for(int i=0; i<fishcount; i++)
		{
			Q.enqueue(new Fish(fishreader));
		}
		
		while(!Q.isEmpty())
			((Fish)Q.dequeue()).print();
	}
}