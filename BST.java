import java.io.*;

class BST implements Collection
{
  private class treenode
  {
    public Comparable data;
    public treenode left;
    public treenode right;
  }
  treenode root;
  int count;

  public BST() 
  { 
    root=null; count=0; 
    Q=new QueueLL();
  }

  public void insert(Comparable x)
  {
    count++;
    root=inserthelp(root,x);
  }
  private treenode inserthelp(treenode r, Comparable x)
  // returns the new value of the root of this subtree (r)
  {
    // base case
    if(r==null)
    {
      treenode newnode=new treenode();
      newnode.data=x;
      newnode.left=newnode.right=null;
      return newnode;
    }
    // recursive cases
    // left subtree
    if(x.compareTo(r.data)<0)
      r.left=inserthelp(r.left,x);
    else
      r.right=inserthelp(r.right,x);
    return r;
  }

  public Comparable lookup(Comparable x)
  {
    return luh(root,x);
  }
  private Comparable luh(treenode r, Comparable x)
  {
    if(r==null) { return null; } // not in the tree!
    if(r.data.compareTo(x)==0) return r.data;
    if(x.compareTo(r.data)<0) return luh(r.left,x);
    return luh(r.right,x);
  }

  // traversal functions

  public static final int PREORDER=-1;
  public static final int INORDER=0;
  public static final int POSTORDER=1;

  private Queue Q;

  public void reset(int order)
  {
    Q.makeEmpty();
    traversal(root,order);
  }

  private void traversal(treenode r, int order)
  {
    // base case - empty
    if(r==null) return;

    // recursive case
    if(order==PREORDER) { Q.enqueue(r.data); }
    traversal(r.left,order);
    if(order==INORDER) { Q.enqueue(r.data); }
    traversal(r.right,order);
    if(order==POSTORDER) { Q.enqueue(r.data); }
  }

  public Comparable getNext() { return (Comparable) Q.dequeue(); }

  public boolean hasNext() { return !Q.isEmpty(); }

  // quick print function
  public void print() 
  { 
	printhelp(root); 
  }
  private void printhelp(treenode r)
  {
    if(r==null) return;
    printhelp(r.left);
    System.out.println(r.data);
    printhelp(r.right);
  }


  public int size() { return count; }
  public boolean isEmpty() { return root==null; }
  public boolean isFull() { return false; }
  public void makeEmpty() { root=null; count=0; }

  private Comparable deleteditem;

  public Comparable delete(Comparable x) // like lookup
  {
    deleteditem=null;
    root=deletehelp(root,x);
    return deleteditem;
  }

  private treenode deletehelp(treenode r, Comparable x)
  {
    if(r==null) return null;
    if(r.data.compareTo(x)==0) // it matches!  Delete!
    {
      deleteditem=r.data;
      count--;
      // 0 children
      if(r.left==null && r.right==null) 
        return null;
      // 1 child
      if(r.right==null) // we have a left child
        return r.left;
      if(r.left==null) // we have a right child
        return r.right;
      // 2 children!
      Comparable ios=smallest(r.right);
      Comparable deleteditem2=r.data;
      r.data=ios;
      r.right=deletehelp(r.right,ios);
      count++;
      deleteditem=deleteditem2;
      return r;
    }
    if(x.compareTo(r.data)<0) // left subtree
      r.left=deletehelp(r.left,x);
    else
      r.right=deletehelp(r.right,x);
    return r;
  }

  private Comparable smallest(treenode r)
  {
    if(r==null) return null;
    if(r.left==null) return r.data;
    return smallest(r.left);
  }





}