/* Create a class named 'Member' having the following members: 

1. Data members 
2. Name 
3. Age 
4. Phone number 
5. Address 
6. Salary 

It also has a method named 'printSalary' which prints the salary of the members. 
 
 */



package assignment.modules;

public class Module_2_25_Member 
{
		private String name;
		private int age;
		private String phoneNo;
		private String address;
		private double salary;

		public Module_2_25_Member(String name, int age, String phoneNo, String address, double salary) 
		{
			this.name = name;
			this.age = age;
			this.phoneNo = phoneNo;
			this.address = address;
			this.salary = salary;
		}

		public void printSalary() 
		{
			System.out.println("Salary " + salary);
		}

		public static void main(String[] args) 
		{
			Module_2_25_Member member = new Module_2_25_Member("Ajay", 27, "9825825999", "Ahmedabad", 35000.0);
			member.printSalary();
		}
}

