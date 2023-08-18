package com.bean;

public class Employee {

	public String name;
	public String city;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	@Override
	public String toString() {
		return "Employee : [name=" +name+ ", city=" +city+ "]";
	}
	
	
}
