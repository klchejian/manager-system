package com.server;

import static org.junit.Assert.*;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.server.mappers.TestMapper;
import com.server.model.Student;
import com.server.util.SqlSessionFactoryUtil;

public class TestJunit {
	static Logger logger = Logger.getLogger(TestJunit.class);
	SqlSession sqlSession;
	TestMapper testMapper;
	
	
	
	@Before
	public void vbefore() {
		sqlSession = SqlSessionFactoryUtil.openSession();
		testMapper = sqlSession.getMapper(TestMapper.class);

	}

	@After
	public void vAfter() {
		sqlSession.commit();
	}

	@Test
	public void test() {
		Student student = new Student(null ,"lisinopril",11);
		int result = testMapper.add(student);
		if(result>0){
			logger.info("success insert items:"+result+" ---studentid="+student.getStudentid());
		}
	}
	
	@Test
	public void test2(){
		System.out.println("testg2");
	}

}
