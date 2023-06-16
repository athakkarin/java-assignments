//Write a program in Java to input 5 numbers from keyboard and find their sum and average using for loop.



package assignment.modules;

import java.util.Scanner;

public class Module_2_05_Sum_Avg {

	public static void main(String[] args) {
		
		int a,b,c,d,e;
		int sum;
		double avg;
		System.out.println("Enter 5 numbers:");
		Scanner sc = new Scanner(System.in);
		
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		e = sc.nextInt();
		
		sum = a+b+c+d+e;
		System.out.println("The sum of 5 numbers is:"+sum);
		
		avg = sum/5.0;
		System.out.println("The avg of 5 numbers:"+avg);
	}
}
