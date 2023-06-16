/*

Create a class to print the area of a square and a rectangle. The class has two methods with the same name but different number of parameters. The 
method for printing area of a rectangle has two parameters which are length and breadth respectively while the other method for printing area of the 
square has one parameter which is side of square.

 */



package assignment.modules;
	
class area_S_Q
{
		void area(int l, int b)
		{
			System.out.println("The area of rectangle is:"+ (l*b));
		}

		void area(int l)
	    {
			System.out.println("The area of rectangle is:"+ (l*l));
	    }
		
}

public class Print_AOS_AOR{
	
	public static void main(String[] args) 
	{
		area_S_Q asr = new area_S_Q();
		asr.area(5,6);
		asr.area(5);
	} 
	
}


