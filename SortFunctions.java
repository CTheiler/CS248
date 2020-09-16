import java.util.*;
import java.io.*;

/* author @Jon Sorenson */
class SortFunctions
{
	public static void bubble(Comparable [] list)
  {
    for(int pass=0; pass<list.length; pass++)
    {
      boolean issorted=true;
      for(int i=0; i<list.length-1; i++)
        //if(list[i]>list[i+1]) swap(list,i,i+1);
        if(list[i].compareTo(list[i+1])>0) 
        {
          swap(list,i,i+1);
          issorted=false;
        }
      if(issorted) return;
    }
  }

  // *** Selection Sort Functions

  public static void selection(Comparable [] list)
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

  private static void swap(Object [] list, int x, int y)
  {
    Object temp;
    temp=list[x];
    list[x]=list[y];
    list[y]=temp;
  }

  private static int findmax(Comparable [] list, int last)
  {
    int maxpos=0;
    for(int i=1; i<=last; i++)
      //if(list[maxpos]<list[i]) maxpos=i;
      if(list[maxpos].compareTo(list[i])<0) maxpos=i;
    return maxpos;
  }

  // *** Insertion Sort

  public static void insertion(Comparable [] list)
  {
    for(int toinsert=1; toinsert<list.length; toinsert++)
    {
      Comparable item=list[toinsert];
      int i;
      for(i=toinsert-1; i>=0; i--)
      {
        if(item.compareTo(list[i])<0)
        //if(item<list[i])
          list[i+1]=list[i];
        else
        {
          list[i+1]=item;
          break;
        }
      }
      if(i<0) list[0]=item;
/*
      // printing for illustration purposes
      System.out.println();
      for(int j=0; j<=toinsert; j++) System.out.println(list[j]);
*/
    }
  }

  // *** Shellsort Functions

  public static void insertion(Comparable [] list, int offset, int gap)
  {
    for(int toinsert=offset+gap; toinsert<list.length; toinsert+=gap)
    {
      Comparable item=list[toinsert];
      int i;
      for(i=toinsert-gap; i>=0; i-=gap)
      {
        if(item.compareTo(list[i])<0)
        //if(item<list[i])
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

  public static void shell(Comparable [] list)
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
  
  // *** Quicksort Functions

  public static void quick(Comparable [] list)
  {
    quickhelp(list,0,list.length-1);
  }

  private static void quickhelp(Comparable [] list, int start, int stop)
  {
    // base cases
    if(stop<=start) // length 0 or 1
      return;
    if(start+1==stop) // length 2
    {
      if(list[start].compareTo(list[stop])>0)
        swap(list,start,stop);
      return;
    }

    // recursive case
    int pivotpos=partition(list,start,stop);
    quickhelp(list,start,pivotpos-1);
    quickhelp(list,pivotpos+1,stop);
  }

  private static int partition(Comparable [] list, int start, int stop)
  {
    Comparable pivot=list[stop];
    int big=start;
    for(int i=start; i<stop; i++)
    {
      if(list[i].compareTo(pivot)<0)
      {
        swap(list,big,i);
        big++;
      }
    }
    swap(list,stop,big);
    return big;
  }

  // *** Merge Sort Functions

  public static void merge(Comparable [] list)
  {
    mergehelp(list,0,list.length-1);
  }

  private static void mergehelp(Comparable [] list, int start, int stop)
  {
    // base cases
    if(stop<=start) // length 0 or 1
      return;
    if(start+1==stop) // length 2
    {
      if(list[start].compareTo(list[stop])>0)
        swap(list,start,stop);
      return;
    }

    // recursive case
    int mid=(start+stop)/2;
    mergehelp(list,start,mid);
    mergehelp(list,mid+1,stop);
    domerge(list,start,mid,stop);
  }

  private static void domerge(Comparable [] list, int start, int mid, int stop)
  {
    Comparable [] A=new Comparable[stop-start+1];
    int left=start;
    int right=mid+1;
    for(int i=0; i<A.length; i++)
    {
      // pull from the left if (1) the right is empty, or
      // (2) the left is not empty AND the left item is smaller
      if(right>stop || (left<=mid && list[left].compareTo(list[right])<=0))
        A[i]=list[left++];
      else
        A[i]=list[right++];
    }
    // copy back to list[]
    for(int i=0; i<A.length; i++)
      list[start+i]=A[i];
  }

}
			