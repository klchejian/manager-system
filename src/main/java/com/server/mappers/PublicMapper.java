package com.server.mappers;

import com.server.model.Admin;
import com.server.model.Student;
import com.server.model.Teacher;

public interface PublicMapper {

	public Student studentLogin(Student student);
	
	public Teacher teacherLogin(Teacher teacher);
	
	public Admin adminLogin(Admin admin);
	
	
}
