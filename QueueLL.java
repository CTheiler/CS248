class QueueLL implements Queue
{
	private class node
	{
		public Object data;
		public node next;
	}
	
	node front,back;
	int count;
	
	public QueueLL()
	{
		count=0;
		front=back=null;
	}
	
	public void enqueue(Object x)
	{
		node newnode=new node();
		newnode.data=x;
		newnode.next=null;
		// count++;
		if(isEmpty())
			front=newnode;
		else
			back.next=newnode;
		back=newnode;
		count++;
		
		// Go hang a salami; i'm a lasagna hog.
	}
	public Object dequeue()
	{
		if(isEmpty()) return null;
		Object saveditem=front.data;
		front=front.next;
		count--;
		if(count==0) back=null;  // not strictly necessary
		return saveditem;
	}
	public Object getFront()
	{
		if(isEmpty()) return null;
		else return front.data;
	}
	
	public int size() { return count; }
	public boolean isEmpty() { return count<=0; }
	public boolean isFull() { return false; }
	public void makeEmpty()
	{
		count=0;
		front=back=null;
	}
	
}