package dtree;

import java.util.ArrayList;

public class Node 
{
	ArrayList <Row> rows;
	double entropy;
	int size;
	Node left, right;
	
	public Node(ArrayList <Row> list)
	{
		this.rows=list;
		size=list.size();
		calEntropy();
	}
	
	private void calEntropy()
	{
		double x=0,n=rows.size(),a,b;
		for(int i=0; i<rows.size(); i++)
		{
			x += (rows.get(i).decision);
		}
		double y=rows.size()-x;
		
		if(x==0)	a=.00001;
		else	a=x/n*Math.log(x/n)/Math.log(2);
		if(y==0)	b=.00001;
		else	b=y/n*Math.log(y/n)/Math.log(2);
		entropy=-1*(a + b);
	}
	
	public double getEntropy()
	{
		return entropy;
	}
	
	public double infoGain(int cn, double vl)
	{
		ArrayList<Row>leftList=new ArrayList<Row>();
		ArrayList<Row>rightList=new ArrayList<Row>();
		
		for(int i=0; i<rows.size(); i++)
		{
			if(rows.get(i).get(cn)<vl)	leftList.add(rows.get(i));
			else	rightList.add(rows.get(i));
		}
		
		left = new Node(leftList);
		right = new Node(rightList);
		
		System.out.println(left.size+" "+right.size);
		System.out.println(entropy+" "+left.entropy+" "+right.entropy);
		
		return (entropy-left.getEntropy()-right.getEntropy());
	}
	
	public void split(int cn, double vl)
	{
		ArrayList<Row>leftList=new ArrayList<Row>();
		ArrayList<Row>rightList=new ArrayList<Row>();
		
		for(int i=0; i<rows.size(); i++)
		{
			if(rows.get(i).get(cn)<vl)	leftList.add(rows.get(i));
			else	rightList.add(rows.get(i));
		}
		
		left = new Node(leftList);
		right = new Node(rightList);
		
		left.construct();
		right.construct();
	}
	
	public void construct()
	{
		double max=0,tmp,cn,vl;
		int cnt=0;
		
		/*
		for(int j=0; j<rows.size(); j++)
		{
			for(int i=0; i<rows.get(j).size; i++)
			{
				tmp=infoGain(i, rows.get(j).get(i));
				System.out.println(j + " " + i +" "+tmp);
			}
		}
		*/
	}
}