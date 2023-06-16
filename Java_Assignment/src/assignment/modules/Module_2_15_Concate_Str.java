// W.A.J.P to concatenate a given string to the end of another string.



package assignment.modules;

import java.util.Scanner;

public class Module_2_15_Concate_Str {

	public static void main(String[] args) {
		
		String str1;
		String str2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String 1:");
		str1 = sc.nextLine();
		
		System.out.println("Enter String 2:");
		str2 = sc.nextLine();
		
		
		System.out.println("The concated string is:");
		System.out.println(str1.concat(str2));
		
	}

}
