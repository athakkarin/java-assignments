//Write a Java program to Take three numbers from the user and print the greatest Number.



package assignment.modules;

import java.util.Scanner;

public class Module_2_01_Greatest_No   {
	
	public static void main(String args[])
	{
		int a, b, c;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter value of a: ");
		a = sc.nextInt();
		System.out.println("Enter value of b: ");
		b = sc.nextInt();
		System.out.println("Enter value of c: ");
		c = sc.nextInt();
		
		System.out.println("The greatest number is:");
		
		if(a>b) {
			if(a>c) {
				System.out.println(a);
			}
			else {
				System.out.println(c);
			}
		}
		else {
			if(b>c) {
				System.out.println(b);
			}
			else {
				System.out.println(c);
			}
		}
	}
}