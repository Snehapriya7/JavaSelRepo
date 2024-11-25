package JavaPrograms;

import java.util.Scanner;


public class halfReverseString 
{

	public static void main(String[] args) 
	{
		System.out.println("Enter any string");
		Scanner sc=new Scanner(System.in);
		String str=sc.next();
		int middle=str.length()/2;
				
	/*	for(int i=str.length()-1;i>=middle;i--)
			System.out.print(str.charAt(i));
		
		for(int i=0;i<middle;i++)
			System.out.print(str.charAt(i));
			
	*/

		StringBuilder result=new StringBuilder();
		
		for(int i=str.length()-1;i>=middle;i--)
		{
			result.append(str.charAt(i));
		}
		
		result.append(str.substring(0, middle));
		System.out.println(result);
		
	}
}




