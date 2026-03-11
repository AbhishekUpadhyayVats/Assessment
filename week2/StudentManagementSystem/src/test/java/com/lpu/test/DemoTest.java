package com.lpu.test;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import com.lpu.entity.Student;

public class DemoTest {
	
	
	@BeforeAll
	public static void m1() {
		System.out.println("Before All");
	}
	
	@AfterAll
	public static void m2() {
		System.out.println("After All");
	}
	
	@BeforeEach
	public void m3() {
		System.out.println("Before each test method");
	}
	
	@AfterEach
	public void m4(){
		System.out.println("After each test method");
	}
	
	@Test
	public void demo1() {
		//checks equal or not
		Assertions.assertEquals("xyz", "xyz");
	}
	
	@Test
	public void demo2() {
		//expected value is not null
		Assertions.assertNotNull(null,"null value is not allowed");
	}
	
	@Test
	public void demo3() {
		Assertions.assertThrows(NullPointerException.class, () -> {
			int a = 7/0;
		});
	}
	
	@Test
	public void demo4() {
		Assertions.assertDoesNotThrow(() -> {
			int a = 7/7;
		});
	}
	
	@Test
	public void demo5() {
		Student s1 = new Student();
		Student s2 = new Student();
		//check for reference of object
		Assertions.assertSame(s1,s2);
	}
	
	@Test
	public void demo6() {
		int age = 17;
		if(age<18) {
			fail("age is less than 18");
		}
	}
	
	@Test
	public void demo7() {
		int[] arr1 = {10,20};
		int[] arr2 = {10,20,7};
		//Check elements of both array are same or not
//		int[] arr1 = {20,10,7};   ->Order or Sequence is different because sequence should be same as well
//		int[] arr2 = {10,20,7};
		Assertions.assertArrayEquals(arr1,arr2);
	}
	
	@Test
	public void demo8() {
		boolean res = true;
		Assertions.assertTrue(res);
	}
	
	@Test
	public void demo9() {
		boolean res = true;
		Assertions.assertFalse(res);
	}
	
	@ParameterizedTest
	@CsvSource({"2,3,5","10,20,30","-1,1,0"})
	public void demo10(int a, int b, int expected){
		int res = a + b;
		Assertions.assertEquals(expected, res);
	}
}
