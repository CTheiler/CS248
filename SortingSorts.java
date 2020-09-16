import java.io.*;
import java.util.*;

class SortingSorts
{
	//sets an array equal to another array of the same size
	public static void setArray(Integer[] arr1, Integer[] arr2)
	{
		for(int i=0; i<arr1.length; i++)
		{
			arr2[i] = arr1[i];
		}
	}
	
	public static void bubble(Integer [] list)
  {
    for(int pass=0; pass<list.length; pass++)
    {
      boolean issorted=true;
      for(int i=0; i<list.length-1; i++)
        //if(list[i]>list[i+1]) swap(list,i,i+1);
        if(list[i]>list[i+1]) 
        {
          swap(list,i,i+1);
          issorted=false;
        }
      if(issorted) return;
    }
  }
  private static void swap(Integer [] list, int x, int y)
  {
    Integer temp;
    temp=list[x];
    list[x]=list[y];
    list[y]=temp;
  }
  private static int findmax(Integer [] list, int last)
  {
    int maxpos=0;
    for(int i=1; i<=last; i++)
      //if(list[maxpos]<list[i]) maxpos=i;
      if(list[maxpos]<list[i]) maxpos=i;
    return maxpos;
  }
  public static void selection(Integer [] list)
  {
    //repeat
    //  find the max
    //  swap to the end
    for(int last=list.length-1; last>0; last--)
    {
       int maxpos=findmax(list,last);
       swap(list,maxpos,last);
    }
  }
  public static void insertion(Integer [] list)
  {
    for(int toinsert=1; toinsert<list.length; toinsert++)
    {
      Integer item=list[toinsert];
      int i;
      for(i=toinsert-1; i>=0; i--)
      {
        if(item<list[i])
        //if(item<list[i])
          list[i+1]=list[i];
        else
        {
          list[i+1]=item;
          break;
        }
      }
      if(i<0) list[0]=item;
    }
  }
  public static void insertion(Integer [] list, int offset, int gap)
  {
    for(int toinsert=offset+gap; toinsert<list.length; toinsert+=gap)
    {
      Integer item=list[toinsert];
      int i;
      for(i=toinsert-gap; i>=0; i-=gap)
      {
        if(item<list[i])
          list[i+gap]=list[i];
        else
        {
          list[i+gap]=item;
          break;
        }
      }
      if(i<0) list[offset]=item;
    }
  }
  public static void shell(Integer [] list)
  {
    int gap=list.length/5;
    while(gap>1)
    {
      for(int offset=0; offset<gap; offset++)
        insertion(list,offset,gap);
      gap=(int)(gap/2.2);
    }
    insertion(list); // gap=1 pass
  }
  public static void quick(Integer [] list)
  {
    quickhelp(list,0,list.length-1);
  }

  private static void quickhelp(Integer [] list, int start, int stop)
  {
    // base cases
    if(stop<=start) // length 0 or 1
      return;
    if(start+1==stop) // length 2
    {
      if(list[start]>list[stop])
        swap(list,start,stop);
      return;
    }
  }

	
	public static void main(String[] args) throws IOException
	{
		Random randi = new Random();
		
		Scanner cin = new Scanner(System.in);
		System.out.println("What size of random array would you like?");
		int size = cin.nextInt();
		Integer [] rand;
		rand = new Integer[size];
		Integer [] holder;
		holder = new Integer[size];
		for(int i=0; i<rand.length; i++)
		{
			Integer randInt = ((int)(rand.length*Math.random()));
			rand[i] = randInt;
		}
		setArray(rand, holder);
		
		if(rand.length<=100)
		{
			System.out.println("Array before sort: ");
			for(int i=0; i<rand.length; i++)
			{
				System.out.print(rand[i] + " ");
			}
		}
		
		int time1 = (int)System.currentTimeMillis();
		bubble(holder);
		int time2 = (int)System.currentTimeMillis();
		int runtime = time2 - time1;
		System.out.println();
		System.out.println("Sort 1 (Bubble) is finished");
		
		if(rand.length<=100)
		{
			System.out.println("Array after sort: ");
			for(int i=0; i<rand.length; i++)
			{
				System.out.print(holder[i] + " ");
			}
		}
		System.out.println("Bubble Sort Run time- " + runtime);
		
		setArray(rand, holder);
		
		time1 = (int)System.currentTimeMillis();
		quick(holder);
		time2 = (int)System.currentTimeMillis();
		runtime = time2 - time1;
		System.out.println();
		System.out.println("Sort 1 (Quick) is finished");
		
		if(rand.length<=100)
		{
			System.out.println("Array after sort: ");
			for(int i=0; i<rand.length; i++)
			{
				System.out.print(holder[i] + " ");
			}
		}
		System.out.println("Quick sort Run time- " + runtime);
		
		time1=0;
		time2=0;
		
		time1 = (int)System.currentTimeMillis();
		selection(holder);
		time2 = (int)System.currentTimeMillis();
		runtime = time2 - time1;
		System.out.println();
		System.out.println("Sort 3 (Selection) is finished");
		
		if(rand.length<=100)
		{
			System.out.println("Array after sort: ");
			for(int i=0; i<rand.length; i++)
			{
				System.out.print(holder[i] + " ");
			}
		}
		System.out.println("Selection Sort Run time- " + runtime);
		
		time1=0;
		time2=0;
		
		time1 = (int)System.currentTimeMillis();
		insertion(holder);
		time2 = (int)System.currentTimeMillis();
		runtime = time2 - time1;
		System.out.println();
		System.out.println("Sort 4 (Insertion) is finished");
		
		if(rand.length<=100)
		{
			System.out.println("Array after sort: ");
			for(int i=0; i<rand.length; i++)
			{
				System.out.print(holder[i] + " ");
			}
		}
		
		System.out.println("Insertion Sort Run time- " + runtime);
		
		time1=0;
		time2=0;
		
		time1 = (int)System.currentTimeMillis();
		shell(holder);
		time2 = (int)System.currentTimeMillis();
		runtime = time2 - time1;
		System.out.println();
		System.out.println("Sort 5 (Shell) is finished");
		
		if(rand.length<=100)
		{
			System.out.println("Array after sort: ");
			for(int i=0; i<rand.length; i++)
			{
				System.out.print(holder[i] + " ");
			}
		}

		System.out.println("Shell Sort Run time- " + runtime);

	}
}