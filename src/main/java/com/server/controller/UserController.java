package com.server.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestDataBinder;
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
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("str", str);
		map.put("status", status);
		
		
		ArrayList<HashMap<String, String>> resMap = userService.selectUser(map);
		
		System.out.println("模糊搜索users:"+resMap);

		
		request.setAttribute("str", str);
		request.setAttribute("status", status);
		request.setAttribute("userList", resMap);
		return "index";
	}
	
	@RequestMapping("/addUser")
	public String addUser(HttpServletRequest request,HttpServletResponse response){
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
		
		boolean bool;
		try {
			bool = userService.addUser(map);
		} catch (DuplicateKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			request.setAttribute("message", "ID或用户名已存在");
			request.setAttribute("userName", userName);
			request.setAttribute("passwd", passwd);
			request.setAttribute("userId", userId);
			request.setAttribute("major", major);
			request.setAttribute("address", address);
			request.setAttribute("sex", sex);
			request.setAttribute("nickName", nickName);
			request.setAttribute("status", status);
			return "add";
		}
		
		return "index";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,HttpServletResponse response){
		String userId = request.getParameter("userId");
		String userType = request.getParameter("userType");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("userId", userId);
		map.put("userType", userType);
		System.out.println(map);
		userService.deleteUser(map);
//		boolean bool;
//		try {
//			bool = userService.addUser(map);
//		} catch (DuplicateKeyException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			request.setAttribute("message", "ID或用户名已存在");
//			request.setAttribute("userName", userName);
//			request.setAttribute("passwd", passwd);
//			request.setAttribute("userId", userId);
//			request.setAttribute("major", major);
//			request.setAttribute("address", address);
//			request.setAttribute("sex", sex);
//			request.setAttribute("nickName", nickName);
//			request.setAttribute("status", status);
//			return "add";
//		}
		RequestDispatcher view = request.getRequestDispatcher("searchUser");
		try {
			view.forward(request,response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
//		return "searchUser";
	}
	
}
