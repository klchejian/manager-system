package com.server.model;

import com.alibaba.fastjson.JSONObject;

public class Admin {
	/*
	 * 主键（自增长）
	 */public int adminId;
	/*
	 * 用户名
	 */public String userName;
	/*
	 * 密码
	 */public String passwd;
	/*
	 * 姓名
	 */public String nickName;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return JSONObject.toJSONString(this);
	}

}
