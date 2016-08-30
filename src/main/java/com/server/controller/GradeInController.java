package com.server.controller;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
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
		String str = request.getParameter("str");
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("courseId", courseId);
		request.setAttribute("str", str);
		ArrayList<HashMap<String,String>> courseList = gradeInService.getCourseUsers(map);

		/*
		courseList.clear();
		for(int i = 0 ; i < 11 ; i++){
			HashMap<String, String> e = new HashMap<String, String>();
			e.put("courseId", i+" 501 "+i);
			e.put("courseName", i+"courseName"+i);
			e.put("studentNum", i+"studentNum"+i);
			e.put("studentName", i+"studentName"+i);	
			e.put("grade", i+"grade"+i);
			courseList.add(e);
		}
		*/
		
		request.setAttribute("courseList", courseList);
		return "input";
	}
	
	@RequestMapping("/gradeIn")
	public void gradeIn(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String getJsonString = (String) request.getParameter("gradeList");
		JSONArray gradeList = JSONObject.parseArray(getJsonString);
		
		gradeInService.gradeIn(gradeList);
		
		String courseId = "0";
		if(gradeList != null){
			if(gradeList.size()>0){
				courseId = gradeList.getJSONObject(0).getString("courseId");
				System.out.println("coursefsfrserIDsss:"+courseId);
			}
			
		}
		
//		request.setAttribute("courseId", courseId);
		response.addHeader("Access-Control-Allow-Origin", "*");
		PrintWriter writer = null;
		try {
			writer = response.getWriter();
			writer.println(courseId);
			writer.flush();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if(null != writer){
				writer.close();
			}
		}
//		response.setContentType("json");
//		RequestDispatcher view = request.getRequestDispatcher("getCourseUsers");
////		try {
//			view.forward(request, response);
//		} catch (ServletException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		return;
	}
	
	
}
