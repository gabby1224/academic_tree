package com.structs.trio;

import database.*;
import java.util.Map;
import java.util.ArrayList;

public class Login_in 
{
	public static String name;
	private String password;
	private ArrayList<String> list = null;

	public ArrayList<String> getList() {
		return this.list;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	public String login() {
		String sql1 = "select * from information where Name=\"" + getName() + "\"";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result1 = mc.select(sql1, "information");
		if (result1.size() == 0) {
			//return "FALSE";
			return "SUCCESS";
		}
		String password = result1.get(0).get("password");
		if (!password.equals(getPassword()))
		{
			return "FALSE";
			//return "SUCCESS";
		}
		return "SUCCESS";
	}
}
