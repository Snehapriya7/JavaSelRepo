package JavaPrograms;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;


import javax.imageio.ImageIO;


import helper.Utility;

public class MonitoringScreenActivities 
{

	public static void main(String[] args) throws AWTException, IOException
	{
		
		Robot r=new Robot();
		Rectangle screenRect=new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
		BufferedImage screenImage;
	      
	    
		Calendar c =Calendar.getInstance();
		
		//int sec= c.get(Calendar.SECOND);
				
		for(int i=1;i<=60;i++)
		{
			
			int sec=c.get(Calendar.SECOND);
			
			do
			{
			System.out.println(sec);
			screenImage= r.createScreenCapture(screenRect);
		    File f=new File("./Screenshots/Screenshot_"+Utility.getCurrentDateTime()+".png");
		    ImageIO.write(screenImage,"png", f);
			System.out.println("A full screenshot saved: "+f.getAbsolutePath());
			}
			while(c.get(Calendar.SECOND)!=sec+5);
		
		}
		
	}
}
