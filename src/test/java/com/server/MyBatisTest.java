package com.server;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import com.server.mappers.TestMapper;
import com.server.model.Student;
import com.server.util.SqlSessionFactoryUtil;

public class MyBatisTest {
	private static Logger logger = Logger.getLogger(MyBatisTest.class);
public static void main(String[] args) {
	SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
	TestMapper testMapper = sqlSession.getMapper(TestMapper.class);
	Student student = new Student(null ,"lisinopril",11);
	int result = testMapper.add(student);
	sqlSession.commit();
	if(result>0){
		logger.info("success insert items:"+result+" ---studentid="+student.getStudentid());
	}
}
}
