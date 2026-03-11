package com.lpu.dao;

import jakarta.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.lpu.entity.Course;
import com.lpu.entity.Student;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

@Component
public class CourseDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@PostConstruct
	public void init() {
		System.out.println("CourseDao is ready to use");
	}
	
	public Course saveCourse(Course c) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(c);
		tx.commit();
		
		em.close();
		
		return c;
	}
	
	public void updateCourseTrainer(int id, String trainer) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Course c = em.find(Course.class,id);
		
		tx.begin();
		if(c != null) {
			c.setTrainer(trainer);
			em.merge(c);
		}
		tx.commit();
		
		em.close();
	}
	
	public Course findCourseById(int id) {
		EntityManager em = emf.createEntityManager();
		Course c = em.find(Course.class, id);
		em.close();
		return c;
	}
	
	public void deleteById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Course c = em.find(Course.class, id);
		tx.begin();
		if(c != null) em.remove(c);
		tx.commit();
		
		em.close();
	}
	
	public void getStudentToCourse(int id,Student student) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Course c = em.find(Course.class, id);
		tx.begin();
//		em.persist(student);
		c.getStudents().add(student);
		student.getCourses().add(c);
		em.merge(c);
		tx.commit();
	}
	
	@PreDestroy
	public void destroy() {
		emf.close();
		System.out.println("CourseDao EMF is closed");
	}
}