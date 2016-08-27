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
import org.springframework.web.bind.annotation.RequestMapping;

import com.server.model.Course;
import com.server.service.CourseService;
import com.server.service.UserService;


@Controller
@RequestMapping("/Course")
public class CourseController{

	@Resource(name="courseService")
	private CourseService courseService;
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) throws Exception{
		ArrayList<Course> list = new ArrayList<Course>();
		for(int i = 0 ; i < 10;i++){
			Course course = new Course();
			course.setCourseId(i);
			course.setCourseName("课程名-"+i);
			course.setTeacherId(i);
			list.add(course);
		}
		request.setAttribute("courseList", list);
		return "index";
	}
	
	@RequestMapping("/searchCourse")
	public String searchUser(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String str = request.getParameter("str");
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("str", str);
		
		ArrayList<HashMap<String, String>> resMap = courseService.selectCourse(map);
		
		request.setAttribute("str", str);
		request.setAttribute("courseList", resMap);
		return "index";
	}
	
	@RequestMapping("/add")
	public String add(HttpServletRequest request,HttpServletResponse response){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("status", "1");
		ArrayList<HashMap<String, String>> teacherList = userService.selectUser(map );
		request.setAttribute("teacherList", teacherList);
			return "add";
		
	}
	@RequestMapping("/addCourse")
	public String addCourse(HttpServletRequest request,HttpServletResponse response){
		String courseName = request.getParameter("courseName");
		String teacherId = request.getParameter("teacherId");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("courseName", courseName);
		map.put("teacherId", teacherId);
		
//		boolean bool = false;
		try {
			courseService.addCourse(map);
//			bool = courseService.addCourse(map);
		} catch (DuplicateKeyException e) {
			e.printStackTrace();
			request.setAttribute("message", "ID或用户名已存在");
			request.setAttribute("courseName", courseName);
			request.setAttribute("teacherId", teacherId);
			return "add";
		}
		
		return "index";
	}
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request,HttpServletResponse response){
		String courseId = request.getParameter("courseId");
		HashMap<String,String> map = new HashMap<String,String>();
		map.put("courseId", courseId);
		courseService.deleteCourse(map);
		RequestDispatcher view = request.getRequestDispatcher("searchCourse");
		try {
			view.forward(request,response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
