package com.server.service;


import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.dao.DuplicateKeyException;
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
	
	public  ArrayList<HashMap<String, String>> selectUser(HashMap<String, String> map){
		String status = map.get("status");
		ArrayList<HashMap<String, String>> userLists = new ArrayList<HashMap<String,String>>();
		switch (status) {
		case "0":
			userLists.addAll(userMapper.selectStudent(map));
			break;
		case "1":
			userLists.addAll(userMapper.selectTeacher(map));
			break;
		case "2":
			userLists.addAll(userMapper.selectAdmin(map));
			break;
		case "3":
			userLists.addAll(userMapper.selectStudent(map));
			userLists.addAll(userMapper.selectTeacher(map));
			userLists.addAll(userMapper.selectAdmin(map));
			break;
		default:
			break;
		}
		
		return userLists;
	}
	
	public  boolean addUser(HashMap<String, String> map) throws DuplicateKeyException{
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
	
	public  int deleteUser(HashMap<String, String> map){
		String userType = map.get("userType");
		String userId = map.get("userId");
		int res = 0;
		switch (userType) {
		case "0":
			res = userMapper.deleteStudentById(map);
			break;
		case "1":
			res = userMapper.deleteTeacherById(map);
			break;
		case "2":
			res = userMapper.deleteAdminById(map);
			break;
		default:
			res = 0;
			break;
		}
		
		return res;
	}
}
