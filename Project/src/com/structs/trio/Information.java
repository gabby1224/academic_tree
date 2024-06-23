package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class Information 
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
		String sql1 = "select * from information where Name=\"" + Login_in.name + "\"" + ";";
		MySQLConnecter mc = new MySQLConnecter();
		ArrayList<Map<String, String>> result1 = mc.select(sql1, "information");
		session.setAttribute("inforlist", result1);
		return "SUCCESS";
	}

//	public String mod_information() {
//		ServletRequest request = ServletActionContext.getRequest();
//		HttpServletRequest req = (HttpServletRequest) request;
//		HttpSession session = req.getSession();
//		//不知道上面三行在干什么的
//		// 获取请求参数
//		String name = request.getParameter("name");
//		String sex = request.getParameter("sex");
//		String birthday = request.getParameter("birthday");
//		String phone = request.getParameter("phone");
//		String email = request.getParameter("email");
//		String graduatedSchool = request.getParameter("graduated_school");
//		String company = request.getParameter("company");
//		String csdnAdd = request.getParameter("csdn_add");
//		String password = request.getParameter("password");
//
//		String sql1 = "select * from information where Name=\"" + Login_in.name + "\"" + ';'; // select * from information where Name="your_name";
//		MySQLConnecter mc = new MySQLConnecter();
//
//		ArrayList<Map<String, String>> result1 = mc.select(sql1, "information");
//
//		//if result is null, return false
//		if (result1.size() == 0) {
//			return "FALSE";
//		} else {
//
//
//			return "Success";
//		}
//
//
//		// 创建数据库连接
//		try (Connection conn = getConnection()) {
//			// 检查是否已有记录
//			String checkSql = "SELECT * FROM information WHERE Name = ?";
//			try (PreparedStatement checkStmt = conn.prepareStatement(checkSql)) {
//				checkStmt.setString(1, name);
//				ResultSet rs = checkStmt.executeQuery();
//
//				if (rs.next()) {
//					// 删除旧记录
//					String deleteSql = "DELETE FROM information WHERE Name = ?";
//					try (PreparedStatement deleteStmt = conn.prepareStatement(deleteSql)) {
//						deleteStmt.setString(1, name);
//						deleteStmt.executeUpdate();
//					}
//				}
//			}
//
//			// 插入新记录
//			String insertSql = "INSERT INTO information (Name, Sex, Birthday, Phone, Email, Graduated_School, Company, CSDN_Add, Password) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
//			try (PreparedStatement insertStmt = conn.prepareStatement(insertSql)) {
//				insertStmt.setString(1, name);
//				insertStmt.setString(2, sex);
//				insertStmt.setString(3, birthday);
//				insertStmt.setString(4, phone);
//				insertStmt.setString(5, email);
//				insertStmt.setString(6, graduatedSchool);
//				insertStmt.setString(7, company);
//				insertStmt.setString(8, csdnAdd);
//				insertStmt.setString(9, password);
//				int status = insertStmt.executeUpdate();
//
//				if (status == 0) {
//					return "FALSE";
//				}
//			}
//
//			// 创建教师表
//			String createTeacherTableSql = "CREATE TABLE IF NOT EXISTS " + name + "_Teacher (teacher VARCHAR(20), teacherStartTime VARCHAR(20), teacherOverTime VARCHAR(20), project VARCHAR(20))";
//			try (Statement createTeacherStmt = conn.createStatement()) {
//				createTeacherStmt.executeUpdate(createTeacherTableSql);
//			}
//
//			// 创建学生表
//			String createStudentTableSql = "CREATE TABLE IF NOT EXISTS " + name + "_Student (student VARCHAR(20), studentStartTime VARCHAR(20), studentOverTime VARCHAR(20), project VARCHAR(20))";
//			try (Statement createStudentStmt = conn.createStatement()) {
//				createStudentStmt.executeUpdate(createStudentTableSql);
//			}
//
//			return "SUCCESS";
//		}
//	} catch (SQLException e) {
//	e.printStackTrace();
//	return "ERROR";
//}
//
//	}
//
//	public void doUpdate()
//	{
//
//	}
}
