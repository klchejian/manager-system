package com.server.mappers;

import java.util.ArrayList;
import java.util.HashMap;

public interface UserMapper {

	public ArrayList<HashMap<String,String>> selectStudent(HashMap<String,String> map);
	
	public ArrayList<HashMap<String,String>> selectTeacher(HashMap<String,String> map);
	
	public ArrayList<HashMap<String,String>> selectAdmin(HashMap<String,String> map);
	
	
}
