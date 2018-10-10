package com.example.test;

import org.junit.Test;

import com.example.encrypt.Student;

import lombok.extern.log4j.Log4j;

@Log4j
public class ObjectValTest {
	
	@Test
	public void testVal() {
		Student student = new Student();
		student.setName("zhang3");
		student.setAddress("guangzhou");

		Student s2 = student;
		s2.setName("li4");

		log.info(student);
		log.info(s2);
	}
}
