/* W.A.J.P :-- to get the character at the given index within the String. Original String = Tops Technologies! The character at position 0 is T, The 
character at position 10 is o
 */



package assignment.modules;

public class Module_2_14_Index_Of_String {

	public static void main(String[] args) {
		
		String str = "Tops Technologies!";
		System.out.println("Given String : " + str);
		System.out.println();
		
		int a = str.charAt(0);
		int b = str.charAt(10);
		
		System.out.println("The Character at Position 0 is " +(char)a);           
		System.out.println("The Character at Position 10 is " +(char)b);
	}

}
