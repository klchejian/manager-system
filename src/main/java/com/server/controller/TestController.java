package com.server.controller;

import javax.annotation.Resource;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.server.service.TestService;


@Controller
public class TestController{

	private static Log logger = LogFactory.getLog(TestController.class);

	@Resource(name="testService")
	private TestService testService;
	
	@RequestMapping("/test")
	public String testMethod(){
		logger.info("start TestMethod");
		System.out.println("start TestMethod");
		testService.ResourceTest();
		return "test";
	}
}
