package com.server.mappers;

import java.util.ArrayList;
import java.util.HashMap;

import com.server.model.Course;

public interface CourseMapper {

	public ArrayList<HashMap<String,String>> selectCourse(HashMap<String,String> map);
	
	public int insertCourse(Course course);
	
	public int deleteCourseById(HashMap<String,String> map);
	
	
	
}
