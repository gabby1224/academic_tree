package com.structs.trio;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import database.MySQLConnecter;

@WebServlet("/updateInfo")
public class UpdateInfoServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // 获取请求参数
        String name = request.getParameter("name");
        String sex = request.getParameter("sex");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String email = request.getParameter("email");
        String graduatedSchool = request.getParameter("graduated_school");
        String company = request.getParameter("company");
        String csdnAdd = request.getParameter("CSDN_add");

        // 更新数据库中的信息
        String sql = "UPDATE information SET sex='" + sex + "' WHERE name='" + name + "'";
        System.out.println(sql);
        MySQLConnecter mc = new MySQLConnecter();
        int status = mc.update(sql);

        // 跳转到结果页面或个人主页
        if (status > 0) {
            response.sendRedirect("main.html"); // 假设有一个个人主页页面
        } else {
            response.sendRedirect("main.html"); // 假设有一个错误页面
        }
    }
}

