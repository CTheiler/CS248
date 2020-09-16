import java.util.*;
import java.io.*;

class rot13
{
	static String encrypt(String line)
	{
		String coded="";
		for(int i=0; i<line.length(); i++)
		{
			char letter=line.charAt(i);
			if('a'<=letter && letter<='z')
			{
				letter=(char)((int)letter+13);
				if (letter>'z')
					letter=(char)((int)letter-26);
			}
			if('A'<=letter && letter<='Z')
			{
				letter=(char)((int)letter+13);
				if (letter>'Z')
					letter=(char)((int)letter-26);
			}
			coded=coded+letter;
		}
		return coded;
	}
	
	public static void main(String[] args) throws IOException
	{
		String infile, outfile;
		
		Scanner cin=new Scanner(System.in);
		System.out.println("Enter input file name->");
		infile=cin.next();
		System.out.println("Enter output file name ->");
		outfile=cin.next();
		
		Scanner in=new Scanner(new FileReader(infile));
		PrintWriter out=new PrintWriter(new FileWriter(outfile));
		
		while(in.hasNext())
		{
			String line;
			line = in.nextLine();
			line = encrypt(line);
			out.println(line);
		}
		out.close();
	}
}