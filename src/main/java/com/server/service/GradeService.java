package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.mappers.GradeMapper;

@Transactional
@Service("gradeService")
public class GradeService {
	
	@Resource
	private GradeMapper gradeMapper; 
	
	public  ArrayList<HashMap<String,String>> getMyCourseGrade(HashMap<String, String> map){
		return gradeMapper.getMyCourseGrade(map);
	}
}
