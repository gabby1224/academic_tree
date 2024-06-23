<%@ page language="java" import="java.util.*"
		 contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>个人资料</title>
	<link rel="stylesheet" href="css/style.css" type="text/css" media="all">
	<script type="text/javascript">
		function makeEditable(element) {
			element.readOnly = false; // 取消只读属性
			element.style.color = 'blue'; // 设置字体颜色为蓝色
		}

		function saveChanges() {
			document.getElementById("infoForm").action = "/updateInfo";
			document.getElementById("infoForm").submit();
		}
	</script>
</head>
<body style="background: url(images/background.png)">
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
</div>
<div class="a">
	<form id="infoForm" action="/updateInfo" method="post">
		<table width="500px" style="border:1px;" align="center" cellspacing="1" cellpadding="1">
			<tr>
				<%
					ArrayList<Map<String, String>> list11 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list11 != null && list11.size() > 0) {
						out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><input type='text' name='name' value='" + list11.get(0).get("name") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
			<tr>
				<%
					ArrayList<Map<String, String>> list12 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list12 != null && list12.size() > 0) {
						out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><input type='text' name='sex' value='" + list12.get(0).get("sex") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
			<tr>
				<%
					ArrayList<Map<String, String>> list13 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list13 != null && list13.size() > 0) {
						out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><input type='text' name='birthday' value='" + list13.get(0).get("birthday") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
			<tr>
				<%
					ArrayList<Map<String, String>> list14 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list14 != null && list14.size() > 0) {
						out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><input type='text' name='phone' value='" + list14.get(0).get("phone") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
			<tr>
				<%
					ArrayList<Map<String, String>> list15 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list15 != null && list15.size() > 0) {
						out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><input type='text' name='email' value='" + list15.get(0).get("email") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
			<tr>
				<%
					ArrayList<Map<String, String>> list16 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list16 != null && list16.size() > 0) {
						out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><input type='text' name='graduated_school' value='" + list16.get(0).get("graduated_school") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
			<tr>
				<%
					ArrayList<Map<String, String>> list17 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list17 != null && list17.size() > 0) {
						out.print("<th style=\"color:#FFFFFF;\" height=\"50px\"><input type='text' name='company' value='" + list17.get(0).get("company") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
			<tr>
				<%
					ArrayList<Map<String, String>> list18 = (ArrayList<Map<String, String>>) session.getAttribute("inforlist");
					if (list18 != null && list18.size() > 0) {
						out.print("<th style=\"color:#FF0000;\" height=\"50px\"><input type='text' name='CSDN_add' value='" + list18.get(0).get("CSDN_add") + "' readonly ondblclick='makeEditable(this)'/></th>");
					} else {
						out.print("<th>false</th>");
					}
				%>
			</tr>
		</table>
		<input type="submit" value="保存更改"><br/>
	</form>
</div>
<div>
	<form action="main" method="post">
		<div class="register w3layouts agileits send-button w3layouts agileits c">
			<input type="submit" value="返回个人主页">
		</div>
	</form>
	<div class="clear"></div>
</div>
</body>
</html>
