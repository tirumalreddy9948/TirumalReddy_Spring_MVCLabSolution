package com.greatLearning.studentManagement.service;

import java.util.List;

import com.greatLearning.studentManagement.entity.Student;

public interface StudentService {
	
	public List<Student> getAllStudents();
	public void save(Student student);
	
	public Student getStudentById(int id);

	public void deleteById(int id);
}
