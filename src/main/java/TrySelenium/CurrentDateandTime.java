package TrySelenium;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CurrentDateandTime {

	public static void main(String[] args) {
		
		Date currentDate=new Date();
		//System.out.println(d);
		
		SimpleDateFormat myDateFormat=new SimpleDateFormat("HH_mm_ss_dd_MM_yyyy");
		String  date=myDateFormat.format(currentDate);
		System.out.println(date);
	
		
	
				
				
		
	}

}
