package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class addStuOther
{
	private String student;
	private String studentStartTime;
	private String studentOverTime;
	private String project;
	
	public String AddStudent() 
	{
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		student = request.getParameter("student");
		studentStartTime = request.getParameter("studentStartTime");
		studentOverTime = request.getParameter("studentOverTime");
		project = request.getParameter("project");

		String sql0 = "select * from " + find.findname + " where student=" + "\"" + student + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result0 = mc.select(sql0, find.findname+"的学生");
		if (result0.size() != 0) 
		{
			String s1 = "delete from " + find.findname + " where student=" + "\"" + student + "\"" + ";";
			mc.update(s1);
		}
		
		String sql = "insert into " + find.findname + "的学生" + " values(" + 
				"\"" + student  + "\"" + "," + "\"" + studentStartTime  + "\"" + ","
				+ "\"" + studentOverTime  + "\"" + "," + "\"" + project  + "\"" + ");";
		MySQLConnecter newc = new MySQLConnecter();
		newc.update(sql);
		
		String sql1 = "select * from information where Name=\"" + student + "\"" + ";";
		ArrayList<Map<String, String>> result1 = newc.select(sql1, "information");
		if (result1.size() != 0) {
			String sql3 = "insert into " + student + "的老师" + " values(" + 
					"\"" + find.findname  + "\"" + "," + "\"" + studentStartTime  + "\"" + ","
					+ "\"" + studentOverTime  + "\"" + "\"" + project  + "\"" + ");";
			newc.update(sql3);
		}
		return "SUCCESS";
	}
}
