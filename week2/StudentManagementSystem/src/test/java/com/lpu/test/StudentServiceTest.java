package com.lpu.test;

import com.lpu.service.StudentService;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterAll;

public class StudentServiceTest {
	static StudentService service;
	
	@BeforeAll
	public static void m1() {
		service = new StudentService();
	}
	
//	@
	
	@AfterAll
	public static void m2() {
		System.out.println("After All");
	}
}
