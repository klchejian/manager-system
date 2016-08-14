package com.server.mappers;

import java.util.ArrayList;
import java.util.HashMap;

import com.server.model.Admin;
import com.server.model.Student;
import com.server.model.Teacher;

public interface UserMapper {

	public ArrayList<Student> selectStudent(HashMap<String,String> map);
	
	public Teacher selectTeacher(HashMap<String,String> map);
	
	public Admin selectAdmin(HashMap<String,String> map);
	
	
}
