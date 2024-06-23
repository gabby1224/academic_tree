<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/normalize.css" />
<link rel="stylesheet" type="text/css" href="css/demo.css" />
<link rel="stylesheet" type="text/css" href="css/component.css" />
<link rel="stylesheet" type="text/css" href="css/content.css" />
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>
<body style="background: url(images/background.png)">
<body>
	<div class="d1">
		<h1>老师列表</h1>
	</div>
	<div class="d2">
		<table width=700px style="border:1px;" align="center" cellspacing="1" cellpadding="1">
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=5>姓名</font></th>
			<th style="color:#FFFFFF;" height="50px"><font size=5>开始时间</font></th>
			<th style="color:#FFFFFF;" height="50px"><font size=5>结束时间</font></th>
			<th style="color:#FFFFFF;" height="50px"><font size=5>所授科目</font></th>
		</tr>
		<%
			ArrayList<Map<String, String>> list2 = (ArrayList<Map<String, String>>) session.getAttribute("teacherlistOther");
			if (list2.size() > 0) 
			{
				for (int i=0; i < list2.size();i++)
				{
					if (list2.get(i).get("teacher") != null)
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("teacher") + "</td>\n");
					else
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list2.get(i).get("teacherStartTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("teacherStartTime") + "</td>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list2.get(i).get("teacherOverTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("teacherOverTime") + "</td>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list2.get(i).get("project") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"50px\">" + list2.get(i).get("project") + "</td></tr>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"50px\">" + " " + "</td></tr>\n");
				}
			}
		%>
		</table>
	</div>
	
	<div class="d3">
		<h1>学生列表</h1>
	</div>  
	<div class="d4">
		<table width=700px style="border:1px;" align="center" cellspacing="1" cellpadding="1">
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=5>姓名</font></th>
			<th style="color:#FFFFFF;" height="50px"><font size=5>开始时间</font></th>
			<th style="color:#FFFFFF;" height="50px"><font size=5>结束时间</font></th>
			<th style="color:#FFFFFF;" height="50px"><font size=5>所学科目</font></th>
		</tr>
		<%
			ArrayList<Map<String, String>> list1 = (ArrayList<Map<String, String>>) session.getAttribute("studentlistOther");
			if (list1.size() > 0) 
			{
				for (int i=0; i < list1.size();i++)
				{
					if (list1.get(i).get("student") != null)
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + list1.get(i).get("student") + "</td>\n");
					else
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list1.get(i).get("studentStartTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list1.get(i).get("studentStartTime") + "</td>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list1.get(i).get("studentOverTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list1.get(i).get("studentOverTime") + "</td>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list1.get(i).get("project") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"50px\">" + list1.get(i).get("project") + "</td></tr>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"50px\">" + " " + "</td></tr>\n");
				}
			}
		%>
		</table>
	</div>
</body>
</body>
</html>