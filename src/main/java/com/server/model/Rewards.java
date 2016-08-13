package com.server.model;

import com.alibaba.fastjson.JSONObject;

public class Rewards {
	/*
	 * 学号 外键
	 */public String studentNum;
	/*
	 * 事件
	 */public String even;
	/*
	 * 奖励
	 */public String rewards;
	/*
	 * 惩处
	 */public String punishment;
	/*
	 * 教师号 外键
	 */public int teacherId;

	public String getStudentNum() {
		return studentNum;
	}

	public void setStudentNum(String studentNum) {
		this.studentNum = studentNum;
	}


	public String getEven() {
		return even;
	}

	public void setEven(String even) {
		this.even = even;
	}

	public String getRewards() {
		return rewards;
	}

	public void setRewards(String rewards) {
		this.rewards = rewards;
	}

	public String getPunishment() {
		return punishment;
	}

	public void setPunishment(String punishment) {
		this.punishment = punishment;
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
