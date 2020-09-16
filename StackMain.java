import java.io.*;
import java.util.*;

class StackMain
{
	
	
	public static void main(String [] args) throws IOException
	{
		Scanner fishreader=
		  new Scanner(new FileReader("fishfile.txt"));
		int fishcount=fishreader.nextInt();
		
		Stack S=new StackLL();
		
		for(int i=0; i<fishcount; i++)
		{
			S.push(new Fish(fishreader));
		}
		
		while(!S.isEmpty())
			((Fish)S.pop()).print();
	}
}