/* W.A.J.P :-- To compare a given string to the specified character sequence. 
 
Comparing topsint.com and topsint.com: true 
Comparing Topsint.com and a topsint.com: false 

*/



package assignment.modules;

import java.util.Scanner;

public class Module_2_16_Compare_Str {

	public static void main(String[] args) {
		
		String str1;
		String str2;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter String 1:");
		str1 = sc.nextLine();
		
		System.out.println("Enter String 2:");
		str2 = sc.nextLine();
		
		boolean Equal_str =  comapreStrings(str1, str2);
		System.out.println();
		System.out.println("Both string are equal: "+Equal_str);
		
	}	
		
	public static boolean comapreStrings(String str1, String str2){
		if(str1 == null || str2 == null) {
			return false;
		}
		
		if(str1.length() != str2.length()) {
			return false;
		}
		
		for(int i=0; i<str1.length(); i++) {
			if(str1.charAt(i) != str2.charAt(i)) {
				return false;
			}
		}
		return true;	
		
	}
	
}
