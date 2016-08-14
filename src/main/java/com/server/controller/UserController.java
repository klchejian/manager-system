package com.server.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.server.model.Student;
import com.server.service.UserService;


@Controller
@RequestMapping("/User")
public class UserController{

//	private static Log logger = LogFactory.getLog(UserController.class);

	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ArrayList<Student> list = new ArrayList<Student>();
		for(int i = 0 ; i < 10;i++){
			Student student = new Student();
			student.setSex("男"+i);
			student.setIdNumber("13"+i);
			student.setAddress("地址"+i);
			student.setMajor("专业"+i);
			student.setPasswd("password"+i);
			student.setStudentNum("M2015"+i);
			student.setUserName("车健"+i);
			list.add(student);
		}
		request.setAttribute("userList", list);
		return "index";
	}
	
	@RequestMapping("/searchUser")
	public String searchUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8"); 
		String str = request.getParameter("str");
		String status = request.getParameter("status");
		System.out.println("str:"+str+" status:"+status);
		
		ArrayList<HashMap<String, String>> map = userService.selectUser(str);
		
		System.out.println("模糊搜索users:"+map);

		
		request.setAttribute("userList", map);
		return "index";
	}
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.setCharacterEncoding("utf-8"); 
		String userName = request.getParameter("userName");
		String passwd = request.getParameter("passwd");
		String userId = request.getParameter("userId");
		String major = request.getParameter("major");
		String address = request.getParameter("address");
		String sex = request.getParameter("sex");
		String nickName = request.getParameter("nickName");
		String status = request.getParameter("status");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("userName", userName);
		map.put("passwd", passwd);
		map.put("userId", userId);
		map.put("major", major);
		map.put("address", address);
		map.put("sex", sex);
		map.put("nickName", nickName);
		map.put("status", status);
		System.out.println(map);
		
		boolean bool =userService.addUser(map);
		
		System.out.println("add:"+bool);
		
		return "index";
	}
	
}
