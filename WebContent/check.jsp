<%@ page language="java" import="java.util.*"
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>确认消息列表</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>
<body style="background: url(images/background.png)">
    <h1>确认消息列表</h1>
    <br>
    <br>
<div class="list-container">
	<form action="ackadds" method="post">
        <table width="100%" style="border:1px solid #FFFFFF;" align="center" cellspacing="1" cellpadding="1">
            <tr>
                <th style="color:#FFFFFF;" height="50px"><font size=6>姓名</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>开始时间</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>结束时间</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>学科</font></th>
            </tr>
            
            <%
            List<Map<String, String>> S_ack_list = (List<Map<String, String>>) session.getAttribute("S_ack_list");
            if (S_ack_list != null && !S_ack_list.isEmpty()) {
                for (Map<String, String> message : S_ack_list) {
                    String teacher = message.get("teacher");
                    String studentStartTime = message.get("studentStartTime");
                    String studentOverTime = message.get("studentOverTime");
                    String project = message.get("project");
            %>
            <tr>
                <td style="color:#FFFFFF;" height="50px"><font size=6><%= teacher %></font></td>
                <td style="color:#FFFFFF;" height="50px"><font size=6><%= studentStartTime %></font></td>
                <td style="color:#FFFFFF;" height="50px"><font size=6><%= studentOverTime %></font></td>
                <td style="color:#FFFFFF;" height="50px"><font size=6><%= project %></font></td>
                <td style="color:#FFFFFF;" height="50px">

                        <input type="hidden" name="teacher" value="<%= teacher %>">
                        <input type="hidden" name="project" value="<%= project %>">
                        <input type="hidden" name="startTime" value="<%= studentStartTime %>">
                        <input type="hidden" name="endTime" value="<%= studentOverTime %>">
                        <input type="submit" value="确认">
                    
                </td>
            </tr>
            <%
                }
            } else {
            %>
            <tr>
                <td colspan="6" style="color:#FFFFFF;" height="50px"><font size=6>暂无数据</font></td>
            </tr>
            <%
            }
            %>
        </table>
        </form>
    </div>  
</body>
</html>
