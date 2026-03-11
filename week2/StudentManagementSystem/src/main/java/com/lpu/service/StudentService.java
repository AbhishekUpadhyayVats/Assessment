package com.lpu.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.StudentDao;
import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class StudentService {
	
	@Autowired
	private StudentDao dao;
	
	@PostConstruct
	public void init() {
		System.out.println("StudentService is now ready to use");
	}
	
	public Student registerStudent(String name, int age, double marks, List<Course> courses) {
		if((age<18 || age>100)){
			throw new IllegalArgumentException("student age must be in range 18 to 100");
		}
		if(marks<0 || marks>100) {
			throw new IllegalArgumentException("student marks must be in range 0 to 100");
		}
		Student s = new Student(name, age, marks, courses);
		return dao.saveStudent(s);
	}
	
	public Student getStudent(int id) {
		Student s = dao.findStudentById(id);
		if(s==null) {
			throw new IllegalArgumentException("student NOT FOUND!!!!");
		}
		return s;
	}
	
	public void updateMarks(int id, double newMarks) {
		if(newMarks<0 || newMarks>100) throw new IllegalArgumentException("Invalid Marks");
		dao.updateStudentMarks(id, newMarks);
	}
	
	public void deleteStudent(int id) {
		dao.deleteById(id);
	}
	
	public void addingCourseToStudent(int id, Course course) {
		dao.getCourseToStudent(id, course);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("StudentService is destroyed");
	}
}
