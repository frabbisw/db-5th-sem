package dtree;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;

public class DTree 
{
	Node head;
	public DTree()
	{
		input();
		head.construct();
	}
	public static void main(String [] args)
	{
		new DTree();
	}
	public void input()
	{
		try {
			BufferedReader br = new BufferedReader(new FileReader("spambase.data"));
			ArrayList <Row> rows = new ArrayList<Row>();
			
			String strline = "";
			String [] starr;
			double [] narr = new double [60];
			int cnt=1;
			
			while(strline != null)
			{
				strline = br.readLine();
				if(strline==null) break;
				starr = strline.split(",");
				
				for(int i=0; i<starr.length; i++)	
					narr[i]=Double.parseDouble(starr[i]);
				
				if(cnt++%10!=0)	
				{
					Row r = new Row(narr);
					rows.add(r);
				}
				else;
			}
			head = new Node(rows);
		}
		catch (Exception e) 
		{
			e.printStackTrace(); 
		}
	}
}