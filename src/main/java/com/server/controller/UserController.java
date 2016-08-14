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
		
		String str = request.getParameter("str");
		String status = request.getParameter("status");
		System.out.println("str:"+str+" status:"+status);
		
		HashMap<String,String> map = userService.selectUser("stu");
		
		System.out.println("模糊搜索student:"+map);

		
		request.setAttribute("userList", map);
		return "index";
	}
	
}
