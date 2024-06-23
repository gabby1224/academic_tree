<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>个人资料</title>
<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
</head>
<body style="background: url(images/background.png)">
<body>
	<h1>个人基本信息</h1>
	<br>
	<br>
	<div class="b">
	<table width="100%" style="border:1px;" align="center" cellspacing="1" cellpadding="1">
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>姓名</font></th>
		</tr>
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>性别</font></th>
		</tr>
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>生日</font></th>
		</tr>
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>电话号码</font></th>
		</tr>
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>电子邮箱</font></th>
		</tr>
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>毕业院校</font></th>
		</tr>
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>工作单位</font></th>
		</tr>
		<tr>
			<th style="color:#FFFFFF;" height="50px"><font size=6>个人主页</font></th>
		</tr>
	</table>
	</table>
	</div>
	<div class="a">
	<table width="500px" style="border:1px;" align="center" cellspacing="1" cellpadding="1">
		<tr>
			<%
			ArrayList<Map<String, String>> list11 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list11.size() > 0) {
				out.print("<th style=\"color:#FFFFFF;\" height=\"50px\">" + "<font size=6>" + list11.get(0).get("name")+ "</font>" + "</th>");
			}else {
				out.print("<th>" + "false" + "</th>");
			}
			%>
		</tr>
		<tr>
			<%
			ArrayList<Map<String, String>> list12 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list12.size() > 0) {
				out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><font size=6>" + list12.get(0).get("sex")+ "</font></th>");
			}else {
				out.print("<th>false</th>");
			}
			%>
		</tr>
		<tr>
			<%
			ArrayList<Map<String, String>> list13 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list13.size() > 0) {
				out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><font size=6>" + list13.get(0).get("birthday")+ "</font></th>");
			}else {
				out.print("<th>false</th>");
			}
			%>
		</tr>
		<tr>
			<%
			ArrayList<Map<String, String>> list14 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list14.size() > 0) {
				out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><font size=6>" + list14.get(0).get("phone")+ "</font></th>");
			}else {
				out.print("<th>false</th>");
			}
			%>
		</tr>
		<tr>
			<%
			ArrayList<Map<String, String>> list15 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list15.size() > 0) {
				out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><font size=6>" + list15.get(0).get("email")+ "</font></th>");
			}else {
				out.print("<th>false</th>");
			}
			%>
		</tr>
		<tr>
			<%
			ArrayList<Map<String, String>> list16 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list16.size() > 0) {
				out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><font size=6>" + list16.get(0).get("graduated_school")+ "</font></th>");
			}else {
				out.print("<th>false</th>");
			}
			%>
		</tr>
		<tr>
			<%
			ArrayList<Map<String, String>> list17 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list17.size() > 0) {
				out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><font size=6>" + list17.get(0).get("company")+ "</font></th>");
			}else {
				out.print("<th>false</th>");
			}
			%>
		</tr>
		<tr>
			<%
			ArrayList<Map<String, String>> list18 = (ArrayList<Map<String, String>>) session.getAttribute("inforlistOther");
			if (list18.size() > 0) {
				out.print("<th style=\"color:#FF0000;\" height=\"50px\">" + "<a href = " + list18.get(0).get("CSDN_add") + ">" + "<font size=6>" + list17.get(0).get("CSDN_add")+ "</font></th>");
			}else {
				out.print("<th>false</th>");
			}
			%>
		</tr>
	</table>
	</table>
	</div>
    <div>
    <form action="mainOther" method="post">
      <div class="register w3layouts agileits send-button w3layouts agileits c">
      	<input type="submit" value="返回个人主页">
      </div>
    </form>
    <div class="clear"></div>
  </div>
</body>
</body>
</html>