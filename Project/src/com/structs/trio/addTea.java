package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class addTea 
{
	private String teacher;
	private String teacherStartTime;
	private String teacherOverTime;
	private String project;
	
	public String AddTeacher(String teacher, String teacherStartTime, String teacherOverTime, String project)
	{
		String sql0 = "select * from " + Login_in.name + "的老师" + " where teacher=" + "\"" + teacher + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result0 = mc.select(sql0, Login_in.name+"的老师");
		if (result0.size() != 0) 
		{
			String s1 = "delete from " + Login_in.name + "的老师" + " where teacher=" + "\"" + teacher + "\"" + ";";
			mc.update(s1);
		}
		
		String sql = "insert into " + Login_in.name + "的老师" + " values(" + 
				"\"" + teacher  + "\"" + "," + "\"" + teacherStartTime + "\"" + ","
				+ "\"" + teacherOverTime + "\"" + "," + "\"" + project  + "\"" + ");";
		MySQLConnecter newc = new MySQLConnecter();
		newc.update(sql);
		
		String sql2 = "select * from information where Name=\"" + teacher + "\"" + ";";
		ArrayList<Map<String, String>> result2 = newc.select(sql2, "information");
		
		if (result2.size() != 0) {
			String sql4 = "insert into " + teacher + "的学生" + " values(" + 
					"\"" + Login_in.name  + "\"" + "," + "\"" + teacherStartTime + "\"" + ","
					+ "\"" + teacherOverTime + "\"" + "," + "\"" + project  + "\"" + ");";
			newc.update(sql4);
		}
		return "SUCCESS";
	}

	public String Add_T_toquery()
	{
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		teacher = request.getParameter("teacher");
		teacherStartTime = request.getParameter("teacherStartTime");
		teacherOverTime = request.getParameter("teacherOverTime");
		project = request.getParameter("project");

		MySQLConnecter mc = new MySQLConnecter();
		// 如果消息表不存在则创建一个消息表，用来存储提交的add消息
		// 创建教师表 -- 申请者（某学生）， 开始时间， 结束时间， 科目
		String createTableSql = "CREATE TABLE IF NOT EXISTS " + teacher + "_ADDt_message (student VARCHAR(20), teacherStartTime VARCHAR(20), teacherOverTime VARCHAR(20), project VARCHAR(20))";
		try{
			mc.update(createTableSql);
		}
		catch(Exception e){
			return "False";
		}

		// 将信息插入到数据库中
		String sql = "INSERT INTO " + teacher + "_ADDt_message (student, teacherStartTime, teacherOverTime, project) VALUES ('" +
				Login_in.name + "', '" + teacherStartTime + "', '" + teacherOverTime + "', '" + project + "')";
		mc.insert(sql); // 执行插入操作
		return "SUCCESS";
	}

	public void T_ack(String teacher)
	{
		// 被我添加的人点击确认消息，调用此函数添加对方为我的老师，且去掉他消息队列中的消息， 注意这里要给一个 teacher 的参数
		String sql = "SELECT * FROM " + teacher + "_ADDt_message" + " where student=" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result1 = mc.select(sql, teacher + "_ADDt_message");
		if (result1.size() == 0) {
			//return "FALSE";
			return;
		}
		String teacherStartTime = result1.get(0).get("teacherStartTime");
		String teacherOverTime = result1.get(0).get("teacherOverTime");
		String project = result1.get(0).get("project");
		AddTeacher(teacher, teacherStartTime, teacherOverTime, project);

		String delsql = "delete from " + teacher + "_ADDt_message  where student =" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc2 = new MySQLConnecter();
		mc2.update(delsql);
	}
}
