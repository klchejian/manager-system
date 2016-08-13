package com.server.service;


import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;

import com.server.mappers.PublicMapper;
import com.server.mappers.TestMapper;
import com.server.model.Admin;
import com.server.model.Student;
import com.server.model.Teacher;

@Transactional
@Service("publicService")
public class PublicService {
	
	@Resource
	private PublicMapper publicMapper; 
	
	/*@Autowired
	private TransactionTemplate transactionTemplate;
	
	
	
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}*/

	public String login(String username,String passwd,String status){
		if(status==null){
			return  null;
		}
		String resultName = null;
		switch (status) {
		case "0":
			Student student = new Student();
			student.setStudentNum(username);
			student.setPasswd(passwd);
			student= publicMapper.studentLogin(student);
			System.out.println(student);
			if(student!=null){
				resultName=student.getUserName();
			}
			break;
		case "1":
			Teacher teacher = new Teacher();
			teacher.setUserName(username);
			teacher.setPasswd(passwd);
			teacher=publicMapper.teacherLogin(teacher);
			System.out.println(teacher);
			if(teacher!=null){
				resultName=teacher.getNickName();
			}
			break;
		case "2":
			Admin admin = new Admin();
			admin.setUserName(username);
			admin.setPasswd(passwd);
			admin=publicMapper.adminLogin(admin);
			System.out.println(admin);
			if(admin!=null){
				resultName=admin.getNickName();
			}
			break;

		default:
			break;
		}
		return resultName;
	}
	
	public  void ResourceTest(String str){
	/*	//编程式事务实现
		transactionTemplate.execute(new TransactionCallbackWithoutResult() {
			@Override
			protected void doInTransactionWithoutResult(TransactionStatus arg0) {
				// TODO Auto-generated method stub
				System.out.println("testService ResourceTest");
				Student student0=  new Student(35, "chejian", 50);
				testMapper.subAge(student0);
				Student student1 = new Student(34, "chejian", 50);
				testMapper.addAge(student1);
			}
		});*/
//		System.out.println("testService ResourceTest");
//		Student student0=  new Student(35, "chejian", 50);
//		testMapper.subAge(student0);
//		Student student1 = new Student(34, "chejian", 50);
//		testMapper.addAge(student1);
		
		
	}
}
