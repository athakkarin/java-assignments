/* W.A.J.P to find all interleaving of given strings. 

The given strings are: WX YZ 
The interleaving strings are: YWZX WYZX YWXZ WXYZ YZWX WYXZ

 */



package assignment.modules;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Inter_Leave_Str {

	public static void allInterleavings(String res, String alph1, String alph2, Set < String > out) {

		if(alph1.length() == 0 && alph2.length() == 0) {
			out.add(res);
			return;
		}
		
		if (alph1.length() > 0) {
			 allInterleavings(res + alph1.charAt(0), alph1.substring(1), alph2, out);
		}
		
		if (alph2.length() > 0) {
			 allInterleavings(res + alph2.charAt(0), alph1, alph2.substring(1), out);
		}
	}

	public static void main(String[] args) {
		
			String alph1;
			String alph2;
					
			Scanner sc = new Scanner(System.in);
					
			System.out.println("Enter String 1:");
			alph1 = sc.nextLine();
					
			System.out.println("Enter String 2:");
			alph2 = sc.nextLine();
				
			System.out.println("The given strings are: " + alph1 + "  " + alph2);
			System.out.println("The interleavings strings are: ");
				
			Set < String > out = new HashSet < > ();
			allInterleavings("", alph1, alph2, out);

			out.stream().forEach(System.out::println);
			
	}

}
