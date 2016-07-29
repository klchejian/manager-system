package com.server;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.server.mappers.TestMapper;
import com.server.model.Student;
import com.server.service.TestService;
import com.server.util.SqlSessionFactoryUtil;

public class MapperResourceTest {
	static Logger logger = Logger.getLogger(TestJunit.class);
//	SqlSession sqlSession;
//	TestMapper testMapper;
	@Resource
	private TestMapper testMapper; 
	
	@Resource(name="testService")
	private TestService testService;
	
	@Before
	public void vbefore() {
//		sqlSession = SqlSessionFactoryUtil.openSession();
//		testMapper = sqlSession.getMapper(TestMapper.class);

	}

	@After
	public void vAfter() {
		
//		sqlSession.commit();
	}

	@Test
	public void test() {
		Student student = new Student(null ,"lisinopril",11);
//		int result = testMapper.add(student);
//		if(result>0){
//			logger.info("success insert items:"+result+" ---studentid="+student.getStudentid());
//		}
//		try {
//			testMapper.add(student);
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		testService.ResourceTest();
	}
	
	@Test
	public void test2(){
//		System.out.println("testg2");
	}

}
