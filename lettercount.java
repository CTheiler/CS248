import java.util.*;

class lettercount
{
	static int Qcount (String line)
	{
		int count = 0;
		for(int i=0; i<line.length();i++)
		{
			char current =line.charAt(i);
			if(current=='q'||current=='Q')
				count++;
		}
		return count;
			
	}
	
	static int[] AllCount(String line)
	{
		int [] count=new int[26];
		for(int i=0; i<line.length();i++)
		{
			char current = line.charAt(i);
			if('a'<=current&&'z'>=current)
			{
				count[current-'a']++;
			}
			if('A'<=current&&'Z'>=current)
			{
				count[current-'A']++;
			}
			else
			{
				
			}
		}
		return count;
	}
	
	public static void main(String[] args)
	{
		String line;
		Scanner cin = new Scanner(System.in);
		System.out.println("Please enter your message: ");
		line = cin.nextLine();
		System.out.println(line);
		System.out.println("There are " + Qcount(line) + " cue's");
		
		int [] count =AllCount(line);
		for(int i = 0; i<26; i++)
		{
			System.out.println((char)(i+'A')+" : "+count[i]);
		}
	}
}