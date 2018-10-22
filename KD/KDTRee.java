package KD;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;

public class KDTRee 
{
	Node head=null;
	ArrayList <Node> nodes = new ArrayList<Node>();
	int NumOfD;
	int NumOfP;
	
	public void insert(Node n)
	{
		if(head==null)	head=n;
		else
		{
			head.insert(n, 0);
		}
	}
	
	public void print()
	{
		traverse(head);
	}
	
	
	private void traverse(Node n) 
	{
		n.print();	
		if(n.left!=null)	
		{
			traverse(n.left);
		}		
		if(n.right!=null)	
		{
			traverse(n.right);
		}
	}

	public static void main(String [] args) throws Exception
	{
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String strline = "";
		
		strline = br.readLine();
		String [] tmp = strline.split(",");
		int p = Integer.parseInt(tmp[0]);
		int d = Integer.parseInt(tmp[1]);
		KDTRee tree = new KDTRee();
		
		while(true)
		{
			strline = br.readLine();
			if(strline==null)	break;
			
			tmp = strline.split(",");
			double [] arr = new double[d+1];
			for(int i=0; i<d; i++)	arr[i]=Integer.parseInt(tmp[i]);
			
			tree.insert(new Node(d,arr));
		}
		
		tree.print();
	}
}
