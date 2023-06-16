/*

Create a class to print an integer and a character with two methods having the same name but different sequence of the integer and the character para-
meters. 

For example, 

if the parameters of the first method are of the form (int n, char c), 
then that of the second method will be of the form (char c, int n).
 
 */



package assignment.modules;

public class Print_Num_Char {

	public void print(int num, char ch) {

        System.out.println("Number: " + num + ", Character: " + ch);

    }

    public void print(char ch, int num) {

        System.out.println("Character: " + ch + ", Number: " + num);

    }

    public static void main(String[] args) {

    	Print_Num_Char obj = new Print_Num_Char();

        obj.print(04, 'H');
        obj.print('A', 47);

    }

}
