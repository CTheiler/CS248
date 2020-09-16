import java.io.*;
import java.util.*;

class BSTMain
{
	
	public static void main(String [] args) throws IOException
	{
		Scanner ff=new Scanner(new FileReader("fishfile.txt"));
		int fishcount;
		fishcount=ff.nextInt();
		
		BST pan=new BST();
		
		for(int i=0; i<fishcount; i++)
		{
			pan.insert(new Fish(ff));
		}
		
		pan.print();

		System.out.println(pan.delete(new Fish("","","",7)));

		Fish f=new Fish("","","",5);
		Fish found=(Fish) pan.lookup(f);
		if(found!=null)
		  System.out.println("We found: "+found);

		System.out.println("\n Preorder:");
		pan.reset(BST.PREORDER);
		while(pan.hasNext()) { System.out.println(pan.getNext()); }

		System.out.println("\n Inorder:");
		pan.reset(BST.INORDER);
		while(pan.hasNext()) { System.out.println(pan.getNext()); }

		System.out.println("\n Postorder:");
		pan.reset(BST.POSTORDER);
		while(pan.hasNext()) { System.out.println(pan.getNext()); }
	}
}