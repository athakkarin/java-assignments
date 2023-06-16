/* Write a Java program that accepts an integer (n) and computes the value of n+nn+nnn. 
 
Input number: 5 
 
Output :
 
5 + 55 + 555 
 
 */



package assignment.modules;

import java.util.Scanner;

public class Module_2_11_Integer_N {

	public static void main(String[] args) {

		int n;
		
		System.out.println("Enter the number:");
		
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		
		System.out.printf("%d + %d%d + %d%d%d \n",n, n, n, n, n, n);
		
	}

}