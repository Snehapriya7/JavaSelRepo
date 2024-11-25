package JavaPrograms;

import java.util.Scanner;

public class ReverseString {

	public static void main(String[] args) {
		
		
		System.out.println("Enter the string to reverse");
		Scanner sc=new Scanner(System.in);
		String s=sc.nextLine();
		String rev=" ";
		
		for(int i=s.length()-1; i>=0;i--)
		{
			rev=rev + s.charAt(i);
			
		}
		
		System.out.println("Reverse of the String: "+ rev);
		
		sc.close();

	}

}
