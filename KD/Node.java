package KD;

public class Node implements Comparable<Node>
{
	public double [] values = new double[100];
	int numOfD;
	Node left=null;
	Node right=null;
	
	public Node(int numOfD, double [] values)
	{
		this.numOfD=numOfD;
		for(int i=0; i<numOfD; i++)
			this.values[i]=values[i];
	}
	
	public void insert(Node n, int dim)
	{
		if(n.get(dim)<this.get(dim))
		{
			if(left==null)	left=n;
			else left.insert(n, (dim+1)%numOfD);
		}
		else
		{
			if(right==null)	right=n;
			else	right.insert(n, (dim+1)%numOfD);
		}
	}
	
	public double get(int index)
	{
		return values[index];
	}
	
	public void print()
	{
		for(int i=0; i<numOfD; i++)
			System.out.print(get(i)+" ");
		System.out.println();
	}
	
	@Override
	public int compareTo(Node o) 
	{
		// TODO Auto-generated method stub
		return 0;
	}
}
