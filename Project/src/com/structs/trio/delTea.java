package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class delTea 
{
	private String teacher;
	
	public String DeleteTeacher(String teacher)
	{
		String sql = "delete from " + Login_in.name + "的老师  where teacher =" + "\"" + teacher + "\"" + ";";
		MySQLConnecter newc = new MySQLConnecter();
		int status = newc.update(sql);
		if (status == 0)
			return "FALSE";
		
		String sql2 = "select * from information where Name=" + "\"" + teacher + "\"" + ";";
		ArrayList<Map<String, String>> result2 = newc.select(sql2, "information");
		
		if (result2.size() != 0) {
			String sql4 = "delete from " + teacher + "的学生  where student =" + "\"" + Login_in.name + "\"" + ";";
			int num = newc.update(sql4);
			if (num == 0)
				return"FALSE";
		}
		return "SUCCESS";
	}

	public String del_t_query()
	{
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		teacher = request.getParameter("student");

		MySQLConnecter mc = new MySQLConnecter();

		String createTeacherTableSql = "CREATE TABLE IF NOT EXISTS " + teacher + "_DELt_message (student VARCHAR(20))";
		try{
			mc.update(createTeacherTableSql);
		}
		catch(Exception e){
			return "False";
		}

		// 将信息插入到数据库中
		String sql = "INSERT INTO " + teacher + "_DELt_message (student) VALUES ('" +
				Login_in.name + "')";
		mc.insert(sql); // 执行插入操作
		return "SUCCESS";
	}

	public void Dt_ack(String teacher)
	{
		String sql = "SELECT * FROM " + teacher + "_DELt_message" + " where student=" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result1 = mc.select(sql, teacher + "_DELt_message");
		if (result1.size() == 0) {
			//return "FALSE";
			return;
		}

		DeleteTeacher(teacher);

		String delsql = "delete from " + teacher + "_DELt_message  where student =" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc2 = new MySQLConnecter();
		mc2.update(delsql);
	}
}
