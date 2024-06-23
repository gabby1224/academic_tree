<%@ page language="java"
 pageEncoding="GB2312"
 contentType="text/html; charset=GB2312"
 import="java.awt.*,
   java.awt.image.*,
   javax.swing.*,
   com.sun.image.codec.jpeg.*,
   javax.imageio.*,
   java.awt.*,
   java.awt.event.*,
   javax.swing.JButton,
   javax.swing.JFrame,
   javax.swing.JPanel,
   javax.swing.border.EmptyBorder,
   com.structs.trio.MyPainter"
%>

<html>
<head>
<title>Ê¦³ÐÊ÷</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
</head>
<body style="background: url(images/background.png)">
<%
	MyPainter y=new MyPainter();
%>

	<div>
    <form action="main" method="post">
      <div class="register w3layouts agileits send-button w3layouts agileits c">
      	<input type="submit" value="·µ»ØÖ÷Ò³">
      </div>
    </form>
    <div class="clear"></div>
  </div>
</body>
</html>