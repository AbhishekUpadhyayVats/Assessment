package com.lpu.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String trainer;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student> students;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}

	public int getId() {
		return id;
	}

	public Course(String name, String trainer, List<Student> students) {
		super();
		this.name = name;
		this.trainer = trainer;
		this.students = students;
	}

	public Course() {
		super();
	}
}
