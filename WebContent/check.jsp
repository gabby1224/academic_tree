<%@ page language="java" import="java.util.*"
    contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" session="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
<style>

        .button-container {
        display: flex;
        justify-content: center; /* 居中对齐 */
        gap: 200px; /* 按钮之间的间距 */
        margin-top: 20px; /* 按需调整顶部外边距 */
    }
        .send-button {
            flex: 1; /* 按钮宽度自动调整 */
            padding: 10px 20px; /* 按钮内边距 */
        }
    </style>
    
</head>
<body style="background: url(images/background.png)">

  
<div class="list-container">
	<form action="message" method="post">
	<div class="d3">
		<h1>学生消息列表</h1>
	</div>  
        <table width="100%" style="border:1px solid #FFFFFF;" align="center" cellspacing="1" cellpadding="1">
            <tr>
                <th style="color:#FFFFFF;" height="50px"><font size=6>姓名</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>开始时间</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>结束时间</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>学科</font></th>
            </tr>
            
            <%
			ArrayList<Map<String, String>> list2 = (ArrayList<Map<String, String>>) session.getAttribute("applying_stu");
			if (list2.size() > 0) 
			{
				for (int i=0; i < list2.size();i++)
				{
					if (list2.get(i).get("teacher") != null)
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("teacher") + "</td>\n");
					else
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list2.get(i).get("studentStartTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("studentStartTime") + "</td>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list2.get(i).get("studentOverTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("studentOverTime") + "</td>\n");
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
        
        <div class="d3">
		<h1>老师消息列表</h1>
	</div>  
        
        <table width="100%" style="border:1px solid #FFFFFF;" align="center" cellspacing="1" cellpadding="1">
            <tr>
                <th style="color:#FFFFFF;" height="50px"><font size=6>姓名</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>开始时间</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>结束时间</font></th>
                <th style="color:#FFFFFF;" height="50px"><font size=6>学科</font></th>
            </tr>
            
            <%
			ArrayList<Map<String, String>> list3 = (ArrayList<Map<String, String>>) session.getAttribute("applying_teacher");
			if (list2.size() > 0) 
			{
				for (int i=0; i < list2.size();i++)
				{
					if (list2.get(i).get("teacher") != null)
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("teacher") + "</td>\n");
					else
						out.print("<tr align=\"center\"><td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list2.get(i).get("teacherStartTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("studentStartTime") + "</td>\n");
					else
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + " " + "</td>\n");
					if (list2.get(i).get("teacherOverTime") != null)
						out.print("<td style=\"color:#FFFFFF;\" height=\"40px\">" + list2.get(i).get("studentOverTime") + "</td>\n");
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
   </form>

        </div>   


    <div class="button-container">
        <form action="ackadds" method="post">
            <input type="submit" value="点击确认学生" class="send-button">
        </form>
        <form action="ackaddse" method="post">
            <input type="submit" value="点击确认老师" class="send-button">
        </form>
    </div>
  
</body>
</html>
