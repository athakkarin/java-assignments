/* W.A.J.P to check whether a given string ends with the contents of another string. 
 
 "Java Exercises" ends with "se"? False 
 "Java Exercise" ends with "se"? True
 
*/



package assignment.modules;

import java.util.Scanner;

public class Module_2_17_Compare_Str_End {

	public static void main(String[] args) {
		
		String str1;
		String str2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String 1:");
		str1 = sc.nextLine();
		
		System.out.println("Enter String 2:");
		str2 = sc.nextLine();
        

        String end_str;
        
        System.out.println("Enter end String:");
		end_str = sc.nextLine();
		

        boolean end1 = str1.endsWith(end_str);
        boolean end2 = str2.endsWith(end_str);

        System.out.println("\"" + str1 + "\" ends with " + "\"" + end_str + "\"? " + end1);
        System.out.println("\"" + str2 + "\" ends with " + "\"" + end_str + "\"? " + end2);
        
    }

}
