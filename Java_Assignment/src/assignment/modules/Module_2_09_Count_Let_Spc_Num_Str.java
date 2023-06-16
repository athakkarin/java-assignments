// Write a Java program to count the letters, spaces, numbers and other characters of an input string.



package assignment.modules;

import java.util.Scanner;

public class Module_2_09_Count_Let_Spc_Num_Str {

	public static void main(String[] args) {
		
		String str;
		System.out.println("Enter the string: ");
		Scanner sc = new Scanner(System.in);
		str = sc.nextLine();
		
		char ch[] = str.toCharArray();
		int letters=0, spaces=0, numbers=0, others=0;
		
		for(int i=0; i<str.length(); i++) 
		{
			
			if(Character.isLetter(ch[i])) {
				letters++;
			}
			else if(Character.isSpaceChar(ch[i])) {
				spaces++;
			}
			else if(Character.isDigit(ch[i])) {
				numbers++;
			}
			else {
				others++;
			}
			
		}
		System.out.println("The string is:"+str);
		System.out.println("No of letters:"+letters);
		System.out.println("No of spaces:"+spaces);
		System.out.println("No of digits:"+numbers);
		System.out.println("The others:"+others);
		
	}
	
}