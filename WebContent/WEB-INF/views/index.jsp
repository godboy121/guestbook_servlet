<%@page import="java.util.List"%>
<%@page import="com.bit2016.guestbook2.vo.guestbookVo"%>
<%@page import="com.bit2016.guestbook2.dao.guestbookDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% 
	guestbookDao dao=new guestbookDao(); 
	guestbookVo vo=new guestbookVo();
	List<guestbookVo> list = dao.getList();
%>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>방명록</title>
</head>
<body>
	<form action="/guestbook2/gb?a=add" method="post"> 
	<table border=1 width=500>
		<tr>
			<td>이름:</td><td><input type="text" name="name"></td>
			<td>비밀번호:</td><td><input type="password" name="pass"></td>
		</tr>
		<tr>
			<td colspan=4><textarea name="content" cols=60 rows=5></textarea></td>
		</tr>
		<tr>
			<td colspan=4 align=right><input type="submit" VALUE=" 등록 "></td>
		</tr>
	</table>
	</form>
	<br>
	<% for(guestbookVo VO :list){%>
	<table width=510 border=1>
		<tr>
			<td><%=VO.getNo() %></td>
			<td><%=VO.getName() %></td>
			<td><%=VO.getDate() %></td>
			<td><a href="/guestbook2/gb?a=deleteform&no=<%=VO.getNo() %>"><input type="submit" value="삭제"> </a></td>
		</tr>
		<tr>
			<td colspan=4><%=VO.getContext() %></td>
		</tr>
	</table>
	<%} %>
</body>
</html>