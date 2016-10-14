<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<%
	String no=request.getParameter("no");%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form method="post" action="/guestbook2/gb?a=delete ">
	<input type='hidden' name="no" value="<%=no%>">
	<table>
		<tr>
			<td>방명록</td>
			<td><input type="password" name="password"></td>
			<td><input type="submit" value="삭제"></td>
			<td><a href="index.jsp">이동하기</a></td>
		</tr>
	</table>
	</form>
</body>
</html>