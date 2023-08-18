package com.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.bean.StudentBean;

public class StudentDao {

	private HibernateTemplate hibernateTemplate;
	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	@Transactional
	public void insert(StudentBean s) {
		hibernateTemplate.saveOrUpdate(s);
	}
	@Transactional
	public List<StudentBean> getAllStudent() {
		return hibernateTemplate.loadAll(StudentBean.class);
	}
	@Transactional
	public StudentBean getStudent(int id) {
		return hibernateTemplate.get(StudentBean.class, id);
	}
	@Transactional
	public void deleteStudent(int id) {
		StudentBean s=hibernateTemplate.get(StudentBean.class, id);
		hibernateTemplate.delete(s);
	}
	
}
