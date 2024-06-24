package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class addStu
{
	private String student;
	private String project;
	private String studentStartTime;
	private String studentOverTime;

	public String getStudent() {
		return this.student;
	}

	public void setStudent(String student) {
		this.student = student;
	}

	public String getStudentStartTime() {
		return this.studentStartTime;
	}

	public void setStudentStartTime(String studentStartTime) {
		this.student = studentStartTime;
	}

	public String getStudentOverTime() {
		return this.studentOverTime;
	}

	public void setStudentOverTime(String studentOverTime) {
		this.studentOverTime = studentOverTime;
	}

	public String getProject() {
		return this.project;
	}

	public void setProject(String project) {
		this.project = project;
	}
	
	public String AddStudent(String student, String studentStartTime, String studentOverTime, String project)
	{
//		ServletRequest request = ServletActionContext.getRequest();
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpSession session = req.getSession();
//		student = request.getParameter("student");
//		studentStartTime = request.getParameter("studentStartTime");
//		studentOverTime = request.getParameter("studentOverTime");
//		project = request.getParameter("project");
		
		String sql0 = "select * from " + Login_in.name + " where student=" + "\"" + student + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result0 = mc.select(sql0, Login_in.name+"的学生");
		if (result0.size() != 0) 
		{
			String s1 = "delete from " + Login_in.name + " where student=" + "\"" + student + "\"" + ";";
			mc.update(s1);
		}

		String sql = "insert into " + Login_in.name + "的学生" + " values(" + 
				"\"" + student  + "\"" + "," + "\"" + studentStartTime  + "\"" + ","
				+ "\"" + studentOverTime  + "\"" + "," + "\"" + project  + "\"" + ");";
		MySQLConnecter newc = new MySQLConnecter();
		int status = newc.update(sql);
		if (status == 0)
			return "FALSE";
		
		String sql1 = "select * from information where Name=\"" + student + "\"" + ";";
		ArrayList<Map<String, String>> result1 = newc.select(sql1, "information");
		if (result1.size() != 0) 
		{
			String sql3 = "insert into " + student + "的老师" + " values(" + 
					"\"" + Login_in.name  + "\"" + "," + "\"" + studentStartTime  + "\"" + ","
					+ "\"" + studentOverTime  + "\"" + "\"" + project  + "\"" + ");";
			int number = newc.update(sql3);
		}
		return "SUCCESS";
	}


	public String Add_S_toquery()
	{
		//接受到 http 请求, 该用户要添加学生，先存下来发送给对方确认
		//数据库中将消息存到对方的‘申请你为学生’表中
		ServletRequest request = ServletActionContext.getRequest();
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();
		student = request.getParameter("student");
		studentStartTime = request.getParameter("studentStartTime");
		studentOverTime = request.getParameter("studentOverTime");
		project = request.getParameter("project");

		MySQLConnecter mc = new MySQLConnecter();
		// 如果消息表不存在则创建一个消息表，用来存储提交的add消息
		// 创建教师表
		String createTeacherTableSql = "CREATE TABLE IF NOT EXISTS " + student + "_ADDs_message (teacher VARCHAR(20), studentStartTime VARCHAR(20), studentOverTime VARCHAR(20), project VARCHAR(20))";
		try{
			mc.update(createTeacherTableSql);
		}
		catch(Exception e){
			return "False";
		}

		// 将信息插入到数据库中
		String sql = "INSERT INTO " + student + "_ADD_message (teacher, studentStartTime, studentOverTime, project) VALUES ('" +
				Login_in.name + "', '" + studentStartTime + "', '" + studentOverTime + "', '" + project + "')";
		mc.insert(sql); // 执行插入操作
		return "SUCCESS";
	}

	public void S_ack()
	{
		// 被我添加的学生点击确认消息，调用此函数添加对方为我的学生，且去掉他消息队列中的消息， 注意这里要给一个 student 的参数
		String sql = "SELECT * FROM " + getStudent() + "_ADDs_message" + " where teacher=" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result1 = mc.select(sql, getStudent() + "_ADDs_message");
		if (result1.size() == 0) {
			//return "FALSE";
			return;
		}
		String studentStartTime = result1.get(0).get("studentStartTime");
		String studentOverTime = result1.get(0).get("studentOverTime");
		String project = result1.get(0).get("project");
		AddStudent(getStudent(), studentStartTime, studentOverTime, project);
		String delsql = "delete from " + getStudent() + "_ADDs_message  where teacher =" + "\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc2 = new MySQLConnecter();
		mc2.update(delsql);
	}
}

