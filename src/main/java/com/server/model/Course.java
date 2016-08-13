package com.server.model;

import com.alibaba.fastjson.JSONObject;

public class Course {
	/*
	 * 课程号 主键
	 */public int courseId;
	/*
	 * 课程名
	 */public String courseName;
	/*
	 * 外键
	 */public int teacherId;

	public int getCourseId() {
		return courseId;
	}

	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public int getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.toJSONString(this);
	}
}
