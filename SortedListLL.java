class SortedListLL implements SortedList
{
	private class node
	{
		public Comparable data;
		public node next;
	}
	
	node head;
	int count;
	
	public SortedListLL()
	{
		head=null; 
		count=0;
	}
	
	public void insert(Comparable x)
	{
		node before,after;
		before=null;
		after=head;
		//while(after.data<x)
		while(after.data.compareTo(x)<0)
		{
			before=after;
			after=after.next;
		}
		node newnode=new node();
		newnode.data=x;
		newnode.next=after;
		before.next=newnode;
		count++;
	}
	
	public Comparable get(int pos)
	{
		if(!(pos>=0&&pos<count))
		{
			return null;
		}
		node p;
		p=head;
		for(int i=0; i<pos; i++)
		{
			p=p.next;
		}
		return p.data;
	}
	
	public Comparable delete(int pos)
	{
		if(pos<0 || pos>=count)
		{
			return null;
		}
		node before=head;
		for(int i=0; i<pos-1; i++)
		{
			before = before.next;
		}
		Comparable saveditem;
		if(pos==0)
		{
			saveditem=head.data;
			head=head.next;
		}
		else
		{
			saveditem=before.data;
			before.next=before.next.next;
		}
		count--;
		return saveditem;
	}
	public Comparable get(int pos)
	{
		if(pos<0 || pos<=count)
		{
			return null;
		}
		node p;
		p=head;
		for(int i=0; i<pos; i++)
		{
			p=p.next;
		}
		return p.data;
	}
	
	public int size()
	public boolean isEmpty()
	public boolean isFull()
	public void makeEmpty()
	
	public void reset()
	public Comparable getNext()
	public boolean hasNext()
}