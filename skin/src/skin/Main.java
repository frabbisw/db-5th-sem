package skin;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Main {
	int [] skin = new int [256*256*256+1];
	int [] nonSkin = new int [256*256*256+1];
	double [] rgbStat = new double [256*256*256+1];

	public static void main(String [] args)
	{
		long tm1 = System.currentTimeMillis();
		Main A = new Main();
		A.input();
		A.createSkin();
		//A.printStat();
		long tm2 = System.currentTimeMillis();
		System.out.println("time: " + (double)(tm2-tm1)/1000);
	}
	
	private void createSkin() 
	{
		try {
			BufferedImage img = ImageIO.read(new File("/media/frabbi/EDUCATION/ibtd/b.jpg"));
			
			for(int i=0; i<img.getWidth(); i++)
				for(int j=0; j<img.getHeight(); j++)
				{
					int a = img.getRGB(i, j);
					a &= 0xffffff;
					if(rgbStat[a]<.7)	img.setRGB(i, j, -1);
				}
			
			ImageIO.write(img, "bmp", new File("/media/frabbi/EDUCATION/ibtd/me2.bmp"));
					
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void printStat() 
	{
		for(int i=0; i<=255*255*255; i++)	System.out.println(rgbStat[i]);
	}


	private void input() 
	{
		int cnt=0;
		
		File picFolder = new File("/media/frabbi/EDUCATION/ibtd/Photo");
		File skinFolder = new File("/media/frabbi/EDUCATION/ibtd/Skin");
		File [] skinFiles = skinFolder.listFiles();
		
		
		for(File f1 : skinFiles)
		{
			if(f1.getName().endsWith(".bmp"))
			{
				File f2 = new File(picFolder.getAbsolutePath()+"/"+f1.getName().replace(".bmp", ".jpg"));
				
				try {
					final BufferedImage imgSkin = ImageIO.read(f1);
					final BufferedImage imgPic = ImageIO.read(f2);
			
					System.out.println(++cnt);
					count(imgSkin, imgPic);
				}
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		}
		for(int i=0; i<=255*255*255; i++)	rgbStat[i]=(double)skin[i]/(double)nonSkin[i];
	}
	
	private void count(BufferedImage imgSkin, BufferedImage imgPic)
	{
		for(int i=0; i<imgSkin.getWidth(); i++)
			for(int j=0; j<imgPic.getHeight(); j++)
				{
					int a = imgSkin.getRGB(i, j);
					
					if(a==-1)	nonSkin[imgPic.getRGB(i, j)&0xffffff]++;
					else		skin[a&0xffffff]++;
				}
	}
}
