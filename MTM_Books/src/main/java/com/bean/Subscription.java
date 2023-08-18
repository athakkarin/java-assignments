package com.bean;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="SUBSCRIPTION")
public class Subscription {

	int  subscriptionId;
	String subscriptionName;
	Set<Reader> readers;
	
	@Id
	@GenericGenerator(name = "inc",strategy = "increment")
	@GeneratedValue(generator = "inc")
	public int getSubscriptionId() {
		return subscriptionId;
	}
	public void setSubscriptionId(int subscriptionId) {
		this.subscriptionId = subscriptionId;
	}
	
	@Column(name="SNAME")
	public String getSubscriptionName() {
		return subscriptionName;
	}
	public void setSubscriptionName(String subscriptionName) {
		this.subscriptionName = subscriptionName;
	}
	
	@ManyToMany(mappedBy = "subscription")
	public Set<Reader> getReaders() {
		return readers;
	}
	public void setReaders(Set<Reader> readers) {
		this.readers = readers;
	}
	
	

}
