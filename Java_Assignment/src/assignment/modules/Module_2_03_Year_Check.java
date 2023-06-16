package assignment.modules;

import java.util.Scanner;

public class Module_2_03_Year_Check {

	public static void main(String[] args) {
		
		int year;
		
		System.out.println("Enter the year:");
		Scanner sc = new Scanner(System.in);
		year = sc.nextInt();
		
		String size = Integer.toString(year);
		
		if(year!=0) {
			
			if(year%100==0 && year%400==0 || year%100!=0 && year%4==0) {
				System.out.println("Leap Year");
			}
			else if(size.length()<4) {
				System.out.println("pls enter valid year digit");
			}
			else {
				System.out.println("Not Leap Year");
			}
		}
		else {
			System.out.println("Year zero does not exist");
		}
	}
}
