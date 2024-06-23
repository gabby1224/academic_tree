package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class addTeaOther
{
	private String teacher;
	private String teacherStartTime;
	private String teacherOverTime;
	private String project;
	
	public String AddTeacher() 
	{
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		teacher = request.getParameter("teacher");
		teacherStartTime = request.getParameter("teacherStartTime");
		teacherOverTime = request.getParameter("teacherOverTime");
		project = request.getParameter("project");
		
		String sql0 = "select * from " + find.findname + "的老师" + " where teacher=" + "\"" + teacher + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result0 = mc.select(sql0, find.findname+"的老师");
		if (result0.size() != 0) 
		{
			String s1 = "delete from " + find.findname + "的老师" + " where teacher=" + "\"" + teacher + "\"" + ";";
			mc.update(s1);
		}
		
		String sql = "insert into " + find.findname + "的老师" + " values(" + 
				"\"" + teacher  + "\"" + "," + "\"" + teacherStartTime + "\"" + ","
				+ "\"" + teacherOverTime + "\"" + "," + "\"" + project  + "\"" + ");";
		MySQLConnecter newc = new MySQLConnecter();
		newc.update(sql);
		
		String sql2 = "select * from information where Name=\"" + teacher + "\"" + ";";
		ArrayList<Map<String, String>> result2 = newc.select(sql2, "information");
		
		if (result2.size() != 0) {
			String sql4 = "insert into " + teacher + "的学生" + " values(" + 
					"\"" + find.findname  + "\"" + "," + "\"" + teacherStartTime + "\"" + ","
					+ "\"" + teacherOverTime + "\"" + "," + "\"" + project  + "\"" + ");";
			newc.update(sql4);
		}
		return "SUCCESS";
	}
}
