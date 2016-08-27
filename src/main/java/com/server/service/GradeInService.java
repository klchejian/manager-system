package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.mappers.GradeInMapper;

@Transactional
@Service("gradeInService")
public class GradeInService {
	
	@Resource
	private GradeInMapper gradeInMapper; 
	
	public  ArrayList<HashMap<String,String>> getMyCourse(HashMap<String, String> map){
		return gradeInMapper.getMyCourse(map);
	}
}
