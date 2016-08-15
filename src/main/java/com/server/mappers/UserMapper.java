package com.server.mappers;

import java.util.ArrayList;
import java.util.HashMap;

import com.server.model.Admin;
import com.server.model.Student;
import com.server.model.Teacher;

public interface UserMapper {

	public ArrayList<HashMap<String,String>> selectStudent(HashMap<String,String> map);
	
	public ArrayList<HashMap<String,String>> selectTeacher(HashMap<String,String> map);
	
	public ArrayList<HashMap<String,String>> selectAdmin(HashMap<String,String> map);
	
	public int insertStudent(Student student);
	
	public int insertTeacher(Teacher teacher);
	
	public int insertAdmin(Admin admin);
	
	public int deleteStudentById(HashMap<String,String> map);
	
	public int deleteTeacherById(HashMap<String,String> map);
	
	public int deleteAdminById(HashMap<String,String> map);
	
	
}
