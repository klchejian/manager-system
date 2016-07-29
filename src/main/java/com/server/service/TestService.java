package com.server.service;

import java.util.HashMap;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionCallbackWithoutResult;
import org.springframework.transaction.support.TransactionTemplate;

import com.server.mappers.TestMapper;
import com.server.model.Student;

@Transactional
@Service("testService")
public class TestService {
	
	@Resource
	private TestMapper testMapper; 
	
	@Autowired
	private TransactionTemplate transactionTemplate;
	
	
	
	public TransactionTemplate getTransactionTemplate() {
		return transactionTemplate;
	}

	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void testFuc(){
		System.out.println("testService Fuc");
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
		System.out.println("testService ResourceTest");
		Student student0=  new Student(35, "chejian", 50);
		testMapper.subAge(student0);
		Student student1 = new Student(34, "chejian", 50);
		testMapper.addAge(student1);
		
		
	}
}
