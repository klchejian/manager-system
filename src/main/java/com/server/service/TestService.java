package com.server.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.server.mappers.TestMapper;
import com.server.model.Student;

@Service("testService")
public class TestService {
	
	@Resource
	private TestMapper testMapper; 
	
	
	
	public void testFuc(){
		System.out.println("testService Fuc");
	}
	
	public void ResourceTest(){
		System.out.println("testService ResourceTest");
		Student student = new Student(null, "chejian", 18);
		testMapper.add(student);
		System.out.println(student.getStudentid());
	}
}
