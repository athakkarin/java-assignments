// Write a Java program to print numbers between 1 to 100 which are divisible by 3, 5 and by both.



package assignment.modules;

public class Module_2_13_Div_By_Odd_No {

	public static void main(String[] args) {
		
		System.out.println("Number divisible by 3:");
		
		for(int i=1; i<=100; i++) {
			if(i%3==0) {
				System.out.print(i+", ");
			}
			
		}
		
		System.out.println();
		System.out.println("Numbers divisible by 5:");
		
		for(int i=1; i<=100; i++) {
			if(i%5==0) {
				System.out.print(i+", ");
			}
			
		}
		
		System.out.println();
		System.out.println("Number divisible by 3 & 5:");
		
		for(int i=1; i<=100; i++) {
			if(i%3==0 && i%5==0) {
				System.out.print(i+", ");
			}
			
		}
		
	}

}
