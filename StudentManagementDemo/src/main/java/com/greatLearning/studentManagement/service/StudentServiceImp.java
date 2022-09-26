package com.greatLearning.studentManagement.service;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.greatLearning.studentManagement.entity.Student;
//import com.greatlearning

@Repository
public class StudentServiceImp implements StudentService {

	private SessionFactory sessionFactory;
	private Session session;

	@Autowired
	public StudentServiceImp(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
		try {
			this.session = sessionFactory.getCurrentSession();
		} catch (HibernateException he) {
			this.session = sessionFactory.openSession();
		}
	}

	@Override
	@Transactional
	public List<Student> getAllStudents() {

		Transaction tx = session.beginTransaction();
		List<Student> students = session.createQuery("from Student").list();
		tx.commit();
		return students;
	}

	@Override
	public void save(Student student) {
		Transaction tx = session.beginTransaction();
		session.saveOrUpdate(student);
		tx.commit();
	}

	@Override
	public Student getStudentById(int id) {
		Student student = new Student();

		Transaction tx = session.beginTransaction();

		student = session.get(Student.class, id);

		tx.commit();
		return student;
	}

	@Override
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		Student student = new Student();
		Transaction tx = session.beginTransaction();

		student = session.get(Student.class, id);
		
		session.delete(student);
		tx.commit();	}

}
