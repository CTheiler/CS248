import java.util.*;
import java.io.*;

class FileRead
{
	public static void main(String[] args) throws IOException
	{
		Scanner g;
		g=new Scanner(new FileReader("File.txt"));
		
		String line;
		line=g.nextLine();
		int n = g.nextInt();
		
		
		
		System.out.println(line + "\n" + n);
	}
}