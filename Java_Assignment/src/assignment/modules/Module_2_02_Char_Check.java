/*Write a Java program that takes the user to provide a single character from the alphabet. Print Vowel or Consonant, depending on the user input. If 
the user input is not a letter (between a and z or A and Z), or is a string of length > 1, print an error message.
*/



package assignment.modules;

import java.util.Scanner;

public class Module_2_02_Char_Check {

	public static void main(String[] args) {
		
		 Scanner sc = new Scanner(System.in);

	     System.out.print("Please Provide single character from the alphabet: ");
	     String str = sc.next();

	        if (str.length() == 1 && Character.isAlphabetic(str.charAt(0))) {
	        	
	            char ch = Character.toLowerCase(str.charAt(0));
	            
	            if (ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u') {
	                System.out.println("Vowel");
	            } 
	            
	            else {
	                System.out.println("Consonant");
	            }
	        } 
	        
	        else {
	            System.out.println("Error");
	        }
	        
	    }
}
