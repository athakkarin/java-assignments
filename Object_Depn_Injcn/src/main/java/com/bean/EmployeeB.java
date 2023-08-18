package com.bean;

public class EmployeeB {

private Employee employee;
	

    public void emp()
    {
    	System.out.println("Employee " + employee.getEname() + " is good.");
    }
    
    public void setEmployee(Employee employee)
    {
        System.out.println("Name of Employee: " + employee.getEname());
        this.employee = employee;
    }
}
