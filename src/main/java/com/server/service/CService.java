package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.mappers.CMapper;

@Transactional
@Service("cService")
public class CService {
	
	@Resource
	private CMapper cMapper; 
	
	public  ArrayList<String> getSelectedCourse(HashMap<String, String> map){
		return cMapper.getSelectedCourse(map);
	}
	
	public  int chooseCourse(HashMap<String, String> map){
		return cMapper.chooseCourse(map);
	}
	
	public  int delete(HashMap<String, String> map){
		return cMapper.delete(map);
	}
	
}
