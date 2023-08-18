package com.bean;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table(name="Hbn_Dept")
public class DeptB {

	int did;
	String dname,loc;
	Collection<EmpB> emp;
	
	
	@Id
	@GenericGenerator(name="inc", strategy="increment")
	@GeneratedValue(generator="inc")
	public int getDid() {
		return did;
	}
	public void setDid(int did) {
		this.did = did;
	}
	
	@Column(name="DNAME")
	public String getDname() {
		return dname;
	}
	public void setDname(String dname) {
		this.dname = dname;
	}
	
	@Column(name="LOC")
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "dept")
	public Collection<EmpB> getEmp() {
		return emp;
	}
	public void setEmp(Collection<EmpB> emp) {
		this.emp = emp;
	}
	
	
}
