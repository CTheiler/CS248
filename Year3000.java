import java.io.*;

/**
  Driver class for The Dating Game programming assignment.
  @author Jon Sorenson
*/
public class Year3000
{

  public static void main(String [] args) throws IOException
  {
	System.out.println("Welcome to the Dating program!");
	  
    DateInterface d = new MyDate();
	DateInterface y = new MyDate();
    d.set(1,27,2019,0);
	y.set(1,27,2019,0);// sets the date to Sunday, January 27th, 2019
    while(d.getYear()<3000)
    {
      d.tomorrow();
      // un-comment the next line to help with debugging
      //System.out.println(d);
    }
	while(y.getYear()>1800 | y.getYear()==1800)
	{
		if(y.getMonth()==0 && y.getDay() == 1 && y.getYear()==1800)
			break;
		y.yesterday();
	}
    // at this point, d represents January 1, 3000
	System.out.println("The first date in the year 3000 will be: ");
    System.out.println(d);
	System.out.println("The first date in the year 1800 was: ");
	System.out.println(y);
  }
}