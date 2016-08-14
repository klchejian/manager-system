package com.server;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.server.mappers.TestMapper;
import com.server.mappers.UserMapper;
import com.server.model.Student;
import com.server.util.SqlSessionFactoryUtil;

public class TestJunit {
	static Logger logger = Logger.getLogger(TestJunit.class);
	SqlSession sqlSession;
	UserMapper userMapper;
	
	
	
	@Before
	public void vbefore() {
		sqlSession = SqlSessionFactoryUtil.openSession();
		userMapper = sqlSession.getMapper(UserMapper.class);

	}

	@After
	public void vAfter() {
		sqlSession.commit();
	}

	@Test
	public void test() {
////		Student student = new Student(null ,"lisinopril",11);
//		int result = testMapper.add(student);
//		if(result>0){
//			logger.info("success insert items:"+result+" ---studentid="+student.getStudentid());
//		}
	}
	
	@Test
	public void test2(){
//		System.out.println("testg2");
//		Student student = new Student();
//		student.setAddress("addressislll");
//		student.setIdNumber("idnumberis");
//		System.out.println(student);
	}
	
	@Test
	public void mapperTest(){
//		Student student = userMapper.selectStudent("st");
//		System.out.println("searchStudent:"+student);
	}

}
