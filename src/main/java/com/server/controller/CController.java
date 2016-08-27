package com.server.controller;

import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.server.service.CService;
import com.server.service.CourseService;


@Controller
@RequestMapping("/CCourse")
public class CController{

	@Resource(name="cService")
	private CService cService;
	
	@Resource(name="courseService")
	private CourseService courseService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String str = request.getParameter("str");
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("str", str);
		
		ArrayList<HashMap<String, String>> resMap = courseService.selectCourse(map);
		map.clear();
		map.put("studentNum", ((HashMap<String,String>)request.getSession().getAttribute("loginUser")).get("userId"));
		ArrayList<String> selectedList = cService.getSelectedCourse(map);
		
		request.setAttribute("str", str);
		request.setAttribute("courseList", resMap);
		request.setAttribute("selectedList", selectedList);
		return "index";
	}
	
	@RequestMapping("/chooseCourse")
	public void searchUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		String studentNum = request.getParameter("studentNum");
		String studentNum = ((HashMap<String,String>)request.getSession().getAttribute("loginUser")).get("userId");
		String courseId = request.getParameter("courseId");
		String courseName = request.getParameter("courseName");
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("studentNum", studentNum);
		map.put("courseId", courseId);
		map.put("courseName", courseName);
		
		int res = cService.chooseCourse(map);
		
		request.setAttribute("res", res);

		RequestDispatcher view = request.getRequestDispatcher("index");
		view.forward(request, response);
		return;
	}
	
	@RequestMapping("/delete")
	public void delete(HttpServletRequest request,HttpServletResponse response) throws Exception{
//		String studentNum = request.getParameter("studentNum");
		String studentNum = ((HashMap<String,String>)request.getSession().getAttribute("loginUser")).get("userId");
		String courseId = request.getParameter("courseId");
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("studentNum", studentNum);
		map.put("courseId", courseId);
		
		int res = cService.delete(map);
		
		request.setAttribute("res", res);
		
		RequestDispatcher view = request.getRequestDispatcher("index");
		view.forward(request, response);
		return;
	}
	
}
