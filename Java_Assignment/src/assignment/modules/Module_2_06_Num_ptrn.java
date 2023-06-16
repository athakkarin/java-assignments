/* Write a program in Java to display the pattern like right angle triangle with a number.


1 
12 
123 
1234 
12345


*/


package assignment.modules;

public class Module_2_06_Num_ptrn {

	public static void main(String args[]) {
		
		int n = 5;
		
		for(int i=1;i<=n;i++){
			for(int j=1;j<=i;j++){
				System.out.print(j+ " "); 
			}
			System.out.println();
		}
	}
	
}