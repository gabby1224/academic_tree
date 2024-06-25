package com.structs.trio;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import database.MySQLConnecter;

public class messageshow
{
    private ArrayList<String> list = null;

    public ArrayList<String> getList() {
        return this.list;
    }

    public String infortable()
    {
        ServletRequest request = ServletActionContext.getRequest();
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        MySQLConnecter mc = new MySQLConnecter();

        String sql1 = "SELECT * FROM " + "_ADDs_message" + " where be_applied_stu=" + "\'" + Login_in.name + "\'" + ";";
        ArrayList<Map<String, String>> result1 = mc.select(sql1, "_ADDs_message");
        session.setAttribute("applying_stu", result1);
        
        String sql2 = "SELECT * FROM " + "_ADDt_message" + " where be_applied_teacher=" + "\"" + Login_in.name + "\"" + ";";
        ArrayList<Map<String, String>> result2 = mc.select(sql2, "_ADDt_message");
        session.setAttribute("applying_teacher", result2);

        return "SUCCESS";
    }
}
