package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.server.mappers.UserMapper;
import com.server.model.Admin;
import com.server.model.Student;
import com.server.model.Teacher;

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
	
	public  boolean addUser(HashMap<String, String> map){
		String userName = map.get("userName");
		String passwd = map.get("passwd");
		String userId = map.get("userId");
		String major = map.get("major");
		String address = map.get("address");
		String sex = map.get("sex");
		String nickName = map.get("nickName");
		String status = map.get("status");
		switch (status) {
		case "0":
			Student student = new Student();
			student.setAddress(address);
			student.setIdNumber(userId);
			student.setMajor(major);
			student.setPasswd(passwd);
			student.setSex(sex);
			student.setStudentNum(userName);
			student.setUserName(nickName);
			userMapper.insertStudent(student);
			break;
		case "1":
			Teacher teacher = new Teacher();
			teacher.setNickName(nickName);
			teacher.setPasswd(passwd);
			teacher.setTeacherId(Integer.parseInt(userId));
			teacher.setUserName(userName);
			userMapper.insertTeacher(teacher);
			break;
		case "2":
			Admin admin = new Admin();
			admin.setAdminId(Integer.parseInt(userId));
			admin.setNickName(nickName);
			admin.setPasswd(passwd);
			admin.setUserName(userName);
			userMapper.insertAdmin(admin);
			break;

		default:
			return false;
//			break;
		}
		
		return true;
	}
}
