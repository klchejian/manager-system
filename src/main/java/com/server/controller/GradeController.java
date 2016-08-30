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
import com.server.service.GradeService;


@Controller
@RequestMapping("/Grade")
public class GradeController{

	@Resource(name="gradeService")
	private GradeService gradeService;
	
	@RequestMapping("/index")
	public String index(HttpServletRequest request,HttpServletResponse response) throws Exception{
		HashMap<String,String> map = new HashMap<String, String>();
		map.put("studentNum", ((HashMap<String,String>)request.getSession().getAttribute("loginUser")).get("userId"));
		ArrayList<HashMap<String,String>> courseList = gradeService.getMyCourseGrade(map);
		
		request.setAttribute("courseList", courseList);
		return "index";
	}
}
