package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.mappers.UserMapper;
import com.server.model.Student;

@Transactional
@Service("userService")
public class UserService {
	
	@Resource
	private UserMapper userMapper; 
	
	public  ArrayList<HashMap<String, String>> selectUser(String str){
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("str", str);
		ArrayList<HashMap<String, String>> userLists =userMapper.selectStudent(map);
		userLists.addAll(userMapper.selectTeacher(map));
		userLists.addAll(userMapper.selectAdmin(map));
		
		return userLists;
	}
}
