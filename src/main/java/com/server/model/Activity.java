package com.server.model;

import com.alibaba.fastjson.JSONObject;

public class Activity {
	/*
	 * 学号 外键
	 */public String studentNum;
	/*
	 * 地点
	 */public String address;
	/*
	 * 项目
	 */public String item;

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.toJSONString(this);
	}
}
