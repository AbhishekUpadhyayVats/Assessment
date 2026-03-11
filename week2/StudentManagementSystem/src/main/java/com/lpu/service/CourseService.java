package com.lpu.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.dao.CourseDao;
import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class CourseService {
	
	@Autowired
	private CourseDao dao;

	@PostConstruct
	public void init() {
		System.out.println("CourseService is now ready to use");
	}
	public Course registerCourse(String name, String trainer, List<Student> students) {
		if((name==null)){
			throw new IllegalArgumentException("Name Field is Empty");
		}
		if(trainer==null) {
			throw new IllegalArgumentException("No Trainer Assigned to Student");
		}
		Course c = new Course(name, trainer,students);
		return dao.saveCourse(c);
	}
	
	public Course getCourse(int id) {
		Course c = dao.findCourseById(id);
		if(c==null) {
			throw new IllegalArgumentException("course NOT FOUND!!!!");
		}
		return c;
	}
	
	public void updateTrainer(int id, String newTrainer) {
		if(newTrainer==null) throw new IllegalArgumentException("No New Trainer");
		dao.updateCourseTrainer(id, newTrainer);
	}
	
	public void deleteTrainer(int id) {
		dao.deleteById(id);
	}
	
	public void addingStudentToCourse(int id, Student student) {
		dao.getStudentToCourse(id, student);
	}
	
	@PreDestroy
	public void destroy() {
		System.out.println("CourseService is destroying");
	}
}
