// Write a Java program to print the ASCII value of a given character. 



package assignment.modules;

import java.util.Scanner;

public class Module_2_10_Ascii_Value {

	public static void main(String[] args) {
		
		char ch;
		
		System.out.println("Enter the String :");
		Scanner sc = new Scanner(System.in);
		
		ch = sc.next().charAt(0);
		
		int a = ch;
		System.out.println("ASCII value of "+ch +" is:"+a);
		
	}

}
