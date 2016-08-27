package com.server.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.server.service.GradeInService;


@Controller
@RequestMapping("/GradeIn")
public class GradeInController{

	@Resource(name="gradeInService")
	private GradeInService gradeInService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String str = request.getParameter("str");
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("str", str);
		map.put("userName", ((HashMap<String,String>)request.getSession().getAttribute("loginUser")).get("userId"));
		ArrayList<HashMap<String,String>> courseList = gradeInService.getMyCourse(map);
		
		request.setAttribute("str", str);
		request.setAttribute("courseList", courseList);
		return "index";
	}
	
	@RequestMapping("/getCourseUsers")
	public String getCourseUsers(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String courseId = request.getParameter("courseId");
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("courseId", courseId);
		ArrayList<HashMap<String,String>> courseList = gradeInService.getCourseUsers(map);
		
//		request.setAttribute("str", str);
		request.setAttribute("courseList", courseList);
		return "index";
	}
	
	
}
