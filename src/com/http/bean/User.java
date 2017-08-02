package com.http.bean;

import java.util.Date;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

public class User {

	private String name;
    private Date birthday;
	private String password;
	private Integer age;
	private String msg;

	public String getMsg() {
		return msg;
	}

	public void setMsg(String paramMsg) {
		msg = paramMsg;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	
}
