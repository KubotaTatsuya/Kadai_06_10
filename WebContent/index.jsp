<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.catalina.User"%>
<%@page import="bean.BBSbean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
href="https://cdn.jsdelivr.net/gh/kognise/water.css@latest/dist/dark.
min.css">
<title>掲示板</title>
</head>
<body>
<h1>掲示板</h1>
	<input type="button" onclick="location.href='/kadai_9/Admin'" value="管理画面へ" ><br>
<form action="/kadai_9/BBStop" method="post" enctype="multipart/form-data">

		名前<br>
		<input type="text" name="name" value="名無しのジョビ"><br>
		e-mail<br>
		<input type="text" name="mail"><br>
		内容<br>
		<textarea name="message" rows='4' cols='60'></textarea><br>
		<input type="file" name="file"/>
		<input type="submit" value="投稿">

		<hr noshade="noshade" size="1">
	</form>

		<%
		ArrayList<BBSbean> list = (ArrayList<BBSbean>) session.getAttribute("list");
		for (int i = list.size() - 1; i > -1; i--) {
			BBSbean user = list.get(i);
	%>
	<p><%=user.getId()%>.<%=user.getName()%>
		投稿日
		<%=user.getPostdate()%>
		<%=user.getPosttime()%>
		編集日
		<%=user.getEditdatr()%>
		<%=user.getEdittime()%>
	</p>


	<pre><%=user.getComment()%></pre>
	<%
		if (user.getFile() != null) {
	%>
	<img src="./upload/<%=user.getFile()%>">
	<%
		}
	%>
	<br>
	<hr noshade="noshade" size="1">
	<%
				}
			%>
</body>
</html>