package JavaPrograms;

import java.util.Scanner;

public class CharOccurence {

	public static void main(String[] args) {
		System.out.println("Enter the String: ");
		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		char[] c = str.toCharArray();
		
		
		
		String temp = "";
		
	
		for (int i = 0; i < c.length; i++) 
		{
			int count = 0;
			String s = "";
			s = s + c[i];
			
			if (!temp.trim().contains(s)) 
			{
				count=1;
				for (int j = i + 1; j < c.length; j++) 
				{
					if (s.contains(str.substring(j, j + 1))) 
					{
						count = count + 1;
						temp = temp + s;
					}
				}
				System.out.println("Occurence of " + s + "=" + count);
			}
		}
      sc.close();
	}

}
