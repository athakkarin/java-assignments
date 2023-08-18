package com.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="READER")
public class Reader {

	int readerId;
	String email, firstName, lastName; 
	Set<Subscription> subscription;
	
	
	@Id
	@GenericGenerator(name = "inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
	public int getReaderId() {
		return readerId;
	}
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	
	@Column(name="EMAIL")
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	@Column(name="FNAME")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LNAME")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@ManyToMany
	@JoinTable(name="SUBSCRIPTION_READER", joinColumns = @JoinColumn(name="READERID"), inverseJoinColumns = @JoinColumn(name="SUBSCRIPTIONID"))
	public Set<Subscription> getSubscription() {
		return subscription;
	}
	public void setSubscription(Set<Subscription> subscription) {
		this.subscription = subscription;
	}
	
	
	
	
}
