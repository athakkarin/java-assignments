/* 
 
Create a class named 'Print Number' to print various numbers of different data types by creating different methods with the same name 'printn' and 
having a parameter for each data type.

 */



package assignment.modules;

public class Print_Num {

	     void printn(int i)
	     {
	          System.out.println(i);
	     }
	     
	     void printn(int i ,float f)
	     {
	          System.out.println(i +" "+ f);
	     }
	      
	     void printn(int i, float f, char c)  
	     {
	         System.out.println(i + " "+f+" "+c);
	     }
	     
	     void printn(int i, float f, char c, double d)  
	     {
	         System.out.println(i + " "+f+" "+c+ " "+d);
	     }
	    
	     public static void main(String args[])
	     {
	     
	    	 Print_Num obj = new Print_Num();
	    	 obj.printn(4);
	    	 obj.printn(4,1);
	    	 obj.printn(4,1,'n');
	       	 obj.printn(4,1,'n',11);
	       	 
	     }
	   
}
