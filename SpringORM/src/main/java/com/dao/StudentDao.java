package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.StudentB;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;

	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}

	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void insertStudent(StudentB s)
	{
		this.hibernateTemplate.saveOrUpdate(s);
	}
	public List<StudentB> getAllStudent() {
		return hibernateTemplate.loadAll(StudentB.class);
	}
	public StudentB getStudent(int id) {
		return hibernateTemplate.get(StudentB.class, id);
	}
	@Transactional
	public void deleteStudent(int id) {
		StudentB s=hibernateTemplate.get(StudentB.class, id);
		hibernateTemplate.delete(s);
	}
}
