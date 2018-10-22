package spam;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Main 
{
	public static void main(String [] args)
	{
		Hyp hyp = new Hyp();
		Test tst = new Test();
		double [] min = new double [60];
		double [] max = new double [60];
		
		try {
			BufferedReader br = new BufferedReader(new FileReader("spambase.data"));
			
			String strline = "";
			String [] starr;
			double [] narr = new double [60];
			int cnt=1;
			
			for(int i=0; i<60; i++) 
			{
				min[i]=999999999;
				max[i]=0;
			}
			
			while(strline != null)
			{
				strline = br.readLine();
				if(strline==null) break;
				starr = strline.split(",");
				
				for(int i=0; i<starr.length; i++)	
				{
					double a = Double.parseDouble(starr[i]);
					
					if((i==54|i==55)&a==0)	System.out.println("..");
					
					narr[i]=Double.parseDouble(starr[i]);
					min[i]=Math.min(min[i], narr[i]);
					max[i]=Math.max(max[i], narr[i]);
				}
			
				if(cnt++%100==0)	hyp.add(narr);
				else	tst.add(narr);
			}
		} 
		catch (Exception e) 
		{ 
			e.printStackTrace(); 
		} 
		
		//hyp.setMM(min, max);
		//tst.setMM(min, max);
		//hyp.ready();
		//tst.result(hyp);
		//tst.print();
		
	}
}