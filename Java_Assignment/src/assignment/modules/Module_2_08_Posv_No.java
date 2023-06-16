//  Write a Java program that reads a positive integer and count the number of digits the number. 



package assignment.modules;

import java.util.Scanner;

public class Module_2_08_Posv_No {

	public static void main(String[] args) {
		
		System.out.println("Enter the number:");
		Scanner sc = new Scanner(System.in);
		
		int n;
		n = sc.nextInt();
		
		String size = Integer.toString(n);
		
		System.out.println("Number of digits:"+size.length());
		
	}

}
