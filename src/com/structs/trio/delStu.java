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
	public void setStudent(String student) {
		this.student = student;
	}
	public String DeleteStudent(String student)
	{
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

	public String del_s_query()
	{
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		student = request.getParameter("student");

		MySQLConnecter mc = new MySQLConnecter();

		String createTeacherTableSql = "CREATE TABLE IF NOT EXISTS " + student + "_DELs_message (teacher VARCHAR(20))";
		try{
			mc.update(createTeacherTableSql);
		}
		catch(Exception e){
			return "False";
		}

		// 将信息插入到数据库中
		String sql = "INSERT INTO " + student + "_DELs_message (teacher) VALUES ('" +
				Login_in.name + "')";
		mc.insert(sql); // 执行插入操作
		return "SUCCESS";
	}

	public void Ds_ack()
	{
		String sql = "SELECT * FROM " + student + "_DELs_message" + " where teacher=" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result1 = mc.select(sql, student + "_DELs_message");
		if (result1.size() == 0) {
			//return "FALSE";
			return;
		}

		DeleteStudent(student);

		String delsql = "delete from " + student + "_DELs_message  where teacher =" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc2 = new MySQLConnecter();
		mc2.update(delsql);
	}

}
