package com.server.mappers;

import java.util.ArrayList;
import java.util.HashMap;

public interface GradeInMapper {
	
	public ArrayList<HashMap<String, String>> getMyCourse(HashMap<String, String> map);
	
	public ArrayList<HashMap<String, String>> getCourseUsers(HashMap<String, String> map);
	
	public int gradeIn(HashMap<String, String> map);
	
}
