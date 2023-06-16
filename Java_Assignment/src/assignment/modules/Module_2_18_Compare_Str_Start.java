/* W.A.J.P to check whether a given string starts with the contents of another string. 

Red is favorite color. Starts with Red? True 
Orange is also my favorite color. Starts with Red? False I3.
 
 */



package assignment.modules;

import java.util.Scanner;

public class Module_2_18_Compare_Str_Start {

	public static void main(String[] args) {
		
		String str1;
		String str2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String 1:");
		str1 = sc.nextLine();
		
		System.out.println("Enter String 2:");
		str2 = sc.nextLine();
        

        String start_str;
        
        System.out.println("Enter end String:");
		start_str = sc.nextLine();
		

        boolean start1 = str1.startsWith(start_str);
        boolean start2 = str2.startsWith(start_str);

        System.out.println("\"" + str1 + "\" starts with " + "\"" + start_str + "\"? " + start1);
        System.out.println("\"" + str2 + "\" starts with " + "\"" + start_str + "\"? " + start2);
        
	}

}
