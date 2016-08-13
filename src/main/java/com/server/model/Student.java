package com.server.model;

import com.alibaba.fastjson.JSONObject;

public class Student {
	/*
	 * 学号 主键
	 */public String studentNum;
	/*
	 * 性别
	 */public String sex;
	/*
	 * 姓名
	 */public String userName;
	/*
	 * 身份证
	 */public String idNumber;
	/*
	 * 专业
	 */public String major;
	/*
	 * 地址
	 */public String address;
	/*
	 * 密码
	 */public String passwd;

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}


	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub

		return JSONObject.toJSONString(this);
	}

}
