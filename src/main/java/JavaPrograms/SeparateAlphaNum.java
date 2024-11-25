package JavaPrograms;

import java.util.Scanner;


public class SeparateAlphaNum {

	public static void main(String[] args) {
		
		System.out.println("Enter the string with numerals and alphabets");
		Scanner sc= new Scanner(System.in);
	    String s =sc.nextLine();
	    String alpha="abcdefghijklmnopqrstuvwxyz";
	    String num="0123456789";

  	  String alphabets="";
  	  String numerals="";
  	  
	    
	    for( char str :s.toCharArray())
	    {
	    	String sep=String.valueOf(str);
	    
	    	if(alpha.contains(sep))
	    	{
	    	 alphabets= alphabets.concat(sep);
	    	}
	    
	    	else if (num.contains(sep)) {
	    		
	    		numerals=numerals.concat(sep);
			}
	    	
	    }
	    System.out.println("Alphabets: " + alphabets + '\n' + "Numerals: " +numerals);

	}

}
