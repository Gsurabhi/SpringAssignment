package com.bitwise.spring.controller;

import java.util.HashMap;

public class Users 
{
private HashMap<String,String> validuser = new HashMap<String,String>();
	
	public Users () {
		this.initUsers();;
	}
	
	public void initUsers () {
		validuser.put("surabhi", "Asdf@1234");
		validuser.put("kalpana", "kPvarat#3443");
		validuser.put("devyani", "deVs&more45!");
		validuser.put("mayank",  "mAyAr$6789");
		
	}
	
	public HashMap<String, String> getUsers () {
		return this.validuser;
	}

	
}
