public interface Queue extends Collection
{
	public void enqueue(Object x);
	public Object dequeue();
	public Object getFront();
}