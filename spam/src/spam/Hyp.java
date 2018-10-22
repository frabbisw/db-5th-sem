package spam;

public class Hyp 
{
	double [][] elm;
	int n=0;
	int [][] countS;
	int [][] countH;
	double [] min;
	double [] max;
	int rng=50;
	double thresh = 1;
	public Hyp()
	{
		elm = new double [5000][60];
		countS = new int [1002][60];
		countH = new int [1002][60];
		min = new double [60];
		max = new double [60];
	}
	public void add(double [] ext)
	{
		for(int i=0; i<58; i++)	elm[n][i]=ext[i];
		n++;
	}
	public void print()
	{
		System.out.println(n);
		/*for(int i=0; i<n; i++)	
		{
			for(int j=0; j<58; j++)
				System.out.print(elm[i][j]+" ");
			System.out.println();
		}*/
	}
	public void setMM(double [] min, double [] max)
	{
		this.min = min;
		this.max=max;
	}
	public void ready()
	{
		for(int i=0; i<n; i++)
		{
			for(int j=0; j<57; j++)
			{
				int a = (int)Math.round((elm[i][j]-min[j])/(max[j]-min[j])*rng);
				if(elm[i][57]==1)	countS[a][j]++;
				else	countH[a][j]++;
			}
		}
		
		int right=0, wrong=0, g=0;
			
		for(int i=0; i<n; i++)
		{
			double cmp=1;
			int s=0,h=0;
			for(int j=0; j<57; j++)
			{
				int a = (int)Math.round((elm[i][j]-min[j])/(max[j]-min[j])*rng);				
				cmp *= ((double)(countS[a][j])/(double)(countH[a][j]));
			}
			
			if(cmp>=thresh & elm[i][57]==0)	thresh*=2;
			else if(cmp<thresh & elm[i][57]==1)	thresh*=.5;
					
			if(cmp>=thresh & elm[i][57]==0)	wrong++;
			else if(cmp<thresh & elm[i][57]==1)	wrong++;
			else right++;
		}
		System.out.println(thresh);
		//System.out.println("Accuracy: "+100*(double)right/(wrong+right)+"%");
	}
}
