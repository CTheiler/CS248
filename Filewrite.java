import java.util.*;
import java.io.*;

class Filewrite
{
	public static void main(String[] args) throws IOException
	{
		String filename ="File.txt";
		PrintWriter f;
		f=new PrintWriter(new FileWriter(filename));
		f.println("What should we say?");
		f.println("123");
		f.close();
	}
}