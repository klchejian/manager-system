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
	
	public  HashMap<String,String> selectUser(String str){
		HashMap<String,String> map = new HashMap<String, String>();
		HashMap<String,String> resMap = new HashMap<String, String>();
		map.put("str", str);
		ArrayList<Student> students =userMapper.selectStudent(map);
		return resMap;
	}
}
