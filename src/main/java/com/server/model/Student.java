package com.server.model;

public class Student {
	private Integer studentid;
	private String name;
	private Integer age;

	
	


	public Student(Integer studentid, String name, Integer age) {
		super();
		this.studentid = studentid;
		this.name = name;
		this.age = age;
	}


	public Integer getStudentid() {
		return studentid;
	}


	public void setStudentid(Integer studentid) {
		this.studentid = studentid;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

}
