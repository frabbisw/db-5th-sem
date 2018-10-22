package spam;

public class Test 
{
	double [][] elm;
	double [] min;
	double [] max;
	int n=0;
	double thresh = .000000000037254;
	//double thresh = .000000007450580596923828;
	public Test()
	{
		elm = new double [5000][60];
	}
	public void add(double [] ext)
	{
		for(int i=0; i<58; i++)	elm[n][i]=ext[i];
		n++;
	}
	public void print()
	{
		//System.out.println(n);
		for(int i=0; i<n; i++)	
		{
			for(int j=0; j<58; j++)
				System.out.print(elm[i][j]+" ");
			System.out.println();
		}
	}
	public void setMM(double [] min, double [] max)
	{
		this.min = min;
		this.max=max;
	}
	public void result(Hyp hyp)
	{
		int right=0, wrong=0, rng=hyp.rng;
		int g=0;
		this.thresh=hyp.thresh;
		
		for(int i=0; i<n; i++)
		{
			double cmp=1;
			int s=0,h=0;
			for(int j=0; j<57; j++)
			{
				int a = (int)Math.round((elm[i][j]-min[j])/(max[j]-min[j])*rng);
				
				if(hyp.countS[a][j]>hyp.countH[a][j])	s++;
				else h++;
				cmp *= ((double)(hyp.countS[a][j])/(double)(hyp.countH[a][j]));
				
				
				
			}
			
			//if(cmp>=thresh & elm[i][57]==0)	thresh*=2;
			//else if(cmp<thresh & elm[i][57]==1)	thresh*=.5;
			
			//System.out.println(s+" "+h);
			
			//if(s>h)	cmp=2;
			//else cmp=.5;
			
			//System.out.println(j);
			
			if(cmp<thresh)	System.out.println(0+" "+elm[i][57]);
			else if(cmp>=thresh)			System.out.println(1+" "+elm[i][57]);
			
			//System.out.println(cmp);
			
			if(cmp>=thresh & elm[i][57]==0)	wrong++;
			else if(cmp<thresh & elm[i][57]==1)	wrong++;
			else right++;
		}
		//System.out.println(thresh);
		System.out.println("Accuracy: "+100*(double)right/(wrong+right)+"%");
		System.out.println(right+" "+wrong);
		//System.out.println(right+" "+wrong);
		/*for(int i=0; i<=rng; i++)
		{	
			for(int j=0; j<57; j++)
				System.out.print(hyp.countS[i][j]+"/"+hyp.countH[i][j]+" ");
			System.out.println();
		}*/
		
	}
}