package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class InformationOther 
{
	private ArrayList<String> list = null;

	public ArrayList<String> getList() {
		return this.list;
	}

	public String infor()
	{
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		String sql1 = "select * from information where Name=\"" + find.findname + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result1 = mc.select(sql1, "information");
		session.setAttribute("inforlistOther", result1);
		return "SUCCESS";
	}
}
