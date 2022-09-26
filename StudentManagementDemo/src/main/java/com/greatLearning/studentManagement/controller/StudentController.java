package com.greatLearning.studentManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.greatLearning.studentManagement.entity.Student;
import com.greatLearning.studentManagement.service.StudentService;

@Controller
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	@RequestMapping("/list")
	public String listStudents(Model theModel) {

		List<Student> theStudents = studentService.getAllStudents();

		theModel.addAttribute("Students", theStudents);

		return "student-list";
	}

	@RequestMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {

		Student theStudent = new Student();

		theModel.addAttribute("student", theStudent);

		return "Student-form";
	}

	@RequestMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("id") int theId, Model theModel) {

		Student theStudent = studentService.getStudentById(theId);

		theModel.addAttribute("student", theStudent);

		return "Student-form";
	}

	@PostMapping("/save")
	public String save(@RequestParam("id") int id, @RequestParam("name") String name,
			@RequestParam("department") String department, @RequestParam("country") String country) {

		Student theStudent;

		if (id != 0) {

			theStudent = studentService.getStudentById(id);
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);
		}

		else {
			
			theStudent = new Student();
			theStudent.setName(name);
			theStudent.setDepartment(department);
			theStudent.setCountry(country);

		}
		studentService.save(theStudent);

		return "redirect:/student/list";
	}
	
	
	@RequestMapping("/delete")
	public String delete(@RequestParam("id") int theId) {

		
		studentService.deleteById(theId);

		return "redirect:/student/list";
	}
}
