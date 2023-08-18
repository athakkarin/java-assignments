package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.User;

public class UserDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	
	@Transactional
	public void signupUser(User u) {
		this.hibernateTemplate.save(u);
	}
	
	public static boolean checkEmail(String email) {
		return checkEmail(email);
	}
	
	public static User loginUser(String email) {
		User u = null;
		return u;
	}
	
	public List<User> getUserById(int id) {
		return hibernateTemplate.loadAll(User.class);
	}
	
	
}
