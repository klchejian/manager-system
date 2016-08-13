package com.server.controller;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.server.service.PublicService;
import com.server.service.TestService;


@Controller
public class PublicController{

	private static Log logger = LogFactory.getLog(PublicController.class);

	@Resource(name="publicService")
	private PublicService publicService;
	
	@RequestMapping("/login")
	public void login(HttpServletRequest request,HttpServletResponse response) throws Exception{
		String username=request.getParameter("username");
		String passwd=request.getParameter("password");
		String status  =request.getParameter("status");
		if(username==null||passwd==null||status==null){
			RequestDispatcher view = request.getRequestDispatcher("Public/login.jsp");
			view.forward(request, response);
			return;
		}
//		logger.info(" username:"+username+"  password:"+passwd+"  status:"+status);
		String loginUser = publicService.login(username, passwd, status);
		if(loginUser==null){
			request.setAttribute("message", "用户名或密码错误");
			RequestDispatcher view = request.getRequestDispatcher("Public/login.jsp");
			view.forward(request, response);
		}else{
			request.getSession().setAttribute("loginUser", loginUser);
			RequestDispatcher view = request.getRequestDispatcher("index.jsp");
			view.forward(request, response);
		}

		return;
	}
	
	@RequestMapping("/signout")
	public void signout(HttpServletRequest request,HttpServletResponse response) throws Exception{
		request.getSession().invalidate();
		RequestDispatcher view = request.getRequestDispatcher("Public/login.jsp");
		view.forward(request, response);
	}
	


}
