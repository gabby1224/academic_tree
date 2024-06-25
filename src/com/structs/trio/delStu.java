package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class delStu 
{
	private String student;
	
	public String DeleteStudent()
	{
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		student = request.getParameter("student");
		String sql = "delete from " + Login_in.name + "的学生  where student =" + "\"" + student + "\"" + ";";
		MySQLConnecter newc = new MySQLConnecter();
		int status = newc.update(sql);
		if (status == 0)
			return "FALSE";
		
		String sql1 = "select * from information where Name=" + "\"" + student + "\"" + ";";
		ArrayList<Map<String, String>> result1 = newc.select(sql1, "information");
		
		if (result1.size() != 0) {
			String sql3 = "delete from " + student + "的老师  where teacher =" + "\"" + Login_in.name + "\"" + ";";
			int num = newc.update(sql3);
			if (num == 0)
				return "FALSE";
		}
		return "SUCCESS";
	}
}
