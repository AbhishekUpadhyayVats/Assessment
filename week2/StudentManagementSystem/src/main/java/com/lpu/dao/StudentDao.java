package com.lpu.dao;

import jakarta.persistence.EntityManagerFactory;

import java.util.List;

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
public class StudentDao {
	
	@Autowired
	private EntityManagerFactory emf;
	
	@PostConstruct
	public void init() {
		System.out.println("StudentDao is now ready to use");
	}
	
	public Student saveStudent(Student s) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		tx.begin();
		em.persist(s);
		tx.commit();
		
		em.close();
		
		return s;
	}
	
	public void updateStudentMarks(int id, double newMarks) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		
		Student s = em.find(Student.class, id);
		
		tx.begin();
		if(s != null) {
			s.setMarks(newMarks);
			em.merge(s);
		}
		tx.commit();
		
		em.close();
	}
	
	public Student findStudentById(int id) {
		EntityManager em = emf.createEntityManager();
		Student s = em.find(Student.class, id);
		em.close();
		return s;
	}
	
	public void deleteById(int id) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Student s = em.find(Student.class, id);
		tx.begin();
		if(s != null) em.remove(s);
		tx.commit();
		
		em.close();
	}
	
	public void getCourseToStudent(int id,Course course) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		Student s = em.find(Student.class, id);
		tx.begin();
//		em.persist(course);
		course.getStudents().add(s);
		s.getCourses().add(course);
		em.merge(s);
		tx.commit();
	}
	
	@PreDestroy
	public void destroy() {
		emf.close();
		System.out.println("StudentDao EMF is closed");
	}
}

// IMPORTANT ALWAYS DO REMEMBER
//public Student findStudentById(int id) {
//    EntityManager em = emf.createEntityManager();
//    Student s = em.find(Student.class, id);
//    em.close();   // ❌ EM closed here
//    return s;     // Entity becomes DETACHED
//}
//
//public void deleteById(int id) {
//    EntityManager em = emf.createEntityManager();
//    EntityTransaction tx = em.getTransaction();
//
//    Student s = findStudentById(id);  // ⚠ Comes from different EM
//
//    tx.begin();
//    if(s != null) em.remove(s);  // ❌ PROBLEM HERE
//    tx.commit();
//
//    em.close();
//}

