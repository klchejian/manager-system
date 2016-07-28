package com.server.service;

import org.springframework.stereotype.Service;

@Service("testService")
public class TestService {
	public void testFuc(){
		System.out.println("testService Fuc");
	}
}
