package com.lpu.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.lpu.entity.Course;
import com.lpu.entity.Student;
import com.lpu.service.CourseService;
import com.lpu.service.StudentService;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

public class StudentCourseController {		
	public StudentCourseController() {
		System.out.println("StudentCourseController bean created");
	}
	
	@PostConstruct
	public void init() {
		System.out.println("bean initialised");
	}

	@Autowired
    private StudentService studentService;
	
	@Autowired
    private CourseService courseService;

    public static void main(String[] args) {
    	AnnotationConfigApplicationContext acac = new AnnotationConfigApplicationContext(MyConfig.class);
    	
    	StudentCourseController scc =  acac.getBean(StudentCourseController.class);
    
    	 Course course1 = scc.courseService.registerCourse(
                 "Java", "Rahul Sir", new ArrayList<>());
         Course course2 = scc.courseService.registerCourse(
                 "Hibernate", "Amit Sir", new ArrayList<>());


         Student student1 = scc.studentService.registerStudent(
                 "Krishna", 22, 85.0, new ArrayList<>());
         Student student2 = scc.studentService.registerStudent(
                 "Rohit", 23, 90.0, new ArrayList<>());


         scc.studentService.addingCourseToStudent(student1.getId(), course1);
         scc.studentService.addingCourseToStudent(student1.getId(), course2);

         scc.studentService.addingCourseToStudent(student2.getId(), course1);
         scc.studentService.addingCourseToStudent(student2.getId(), course2);


         scc.courseService.addingStudentToCourse(course1.getId(), student1);
         scc.courseService.addingStudentToCourse(course1.getId(), student2);

         scc.courseService.addingStudentToCourse(course2.getId(), student1);
         scc.courseService.addingStudentToCourse(course2.getId(), student2);
         
         acac.close();
    }
    
    @PreDestroy
    public void destroy() {
    	System.out.println("AnnotationConfigApplicationContext is now closed....");
    }
}
