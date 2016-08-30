package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSONArray;
import com.server.mappers.GradeInMapper;

@Transactional
@Service("gradeInService")
public class GradeInService {
	
	@Resource
	private GradeInMapper gradeInMapper; 
	
	public  ArrayList<HashMap<String,String>> getMyCourse(HashMap<String, String> map){
		return gradeInMapper.getMyCourse(map);
	}
	
	public ArrayList<HashMap<String, String>> getCourseUsers(HashMap<String,String> map){
		return gradeInMapper.getCourseUsers(map);
	}
	
	public int gradeIn(JSONArray gradeList){
		for(int i = 0 ; i < gradeList.size() ; i++){
			String courseId = (String) gradeList.getJSONObject(i).get("courseId");
			String studentNum = (String) gradeList.getJSONObject(i).get("studentNum");
			String grade =(String) gradeList.getJSONObject(i).get("grade");
			HashMap<String,String> map = new HashMap<String, String>();
			map.put("courseId", courseId);
			map.put("studentNum", studentNum);
			map.put("grade", grade);
			gradeInMapper.gradeIn(map);
		}
		return 1;
	}
}
