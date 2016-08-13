package com.server.model;

import com.alibaba.fastjson.JSONObject;

public class CourseSelect {
	/*
	 * 学号 外键
	 */public String studentNum;
	/*
	 * 课程号 主键
	 */public int courseId;
	/*
	 * 课程名
	 */public String courseName;
	/*
	 * 成绩
	 */public double grade;
	/*
	 * 总成绩
	 */public double gradeSum;

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}

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

	public double getGrade() {
		return grade;
	}

	public void setGrade(double grade) {
		this.grade = grade;
	}

	public double getGradeSum() {
		return gradeSum;
	}

	public void setGradeSum(double gradeSum) {
		this.gradeSum = gradeSum;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.toJSONString(this);
	}
}
