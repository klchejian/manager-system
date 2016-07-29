package com.server.mappers;

import com.server.model.Student;

public interface TestMapper {

	public int add(Student student);
	
	public int addAge(Student student);
	
	public int subAge(Student student);
}
