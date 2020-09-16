public class StackArray implements Stack, Collection
{
	int top;
	Object [] items;
	
	public StackArray(int maxSize)
	{
		top=-1;
		items=new Object[maxSize];
	}
	public StackArray()
	{
		this(100);
	}
	
	public void push(Object x)
	{
		if(isFull()) return;
		items[++top]=x;
	}
	public Object pop()
	{
		if(isEmpty()) return null;
		top--;
		return items[top+1];
	}
	public Object getTop()
	{
		if(isEmpty()) return null;
		else return items[top];
	}
	public int size() { return top+1; }
	public boolean isEmpty() { return size()<=0; }
	public boolean isFull() { return top>=items.length-1; }
	public void makeEmpty() { top=-1; }
}