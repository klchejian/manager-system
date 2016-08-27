package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.mappers.CourseMapper;
import com.server.model.Course;

@Transactional
@Service("courseService")
public class CourseService {
	
	@Resource
	private CourseMapper courseMapper; 
	
	public  ArrayList<HashMap<String, String>> selectCourse(HashMap<String, String> map){
		return courseMapper.selectCourse(map);
	}
	
	public  boolean addCourse(HashMap<String, String> map) throws DuplicateKeyException{
		String courseName = map.get("courseName");
		String teacherId = map.get("teacherId");
		Course course = new Course();
		course.setCourseName(courseName);
		course.setTeacherId(Integer.valueOf(teacherId));
			courseMapper.insertCourse(course);
		
		return true;
	}
	
	public  int deleteCourse(HashMap<String, String> map){
//		String courseId = map.get("courseId");
		
		int res = courseMapper.deleteCourseById(map);
		
		return res;
	}
}
