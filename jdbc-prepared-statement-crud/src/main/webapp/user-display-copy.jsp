<%@ page import="java.util.List"%>
<%@ page import="com.jspider.jdbc_prepared_statement_crud.dto.User"%>
<%@ page import="com.jspider.jdbc_prepared_statement_crud.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">

</head>
<body>
	<% List<User> user = new UserDao().getAllUserDao();%>

	<h1>Welcome to the display page</h1> 
	<table>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>EMAIL</th>
			<th>PASSWORD</th>
			<th>DOB</th>
			<th>GENDER</th>
			<th colspan="2">ACTION</th>

		</tr>
		<%for(User users:user){ %>
		<tr>
			<td><%= users.getId() %></td>
			<td><%= users.getName() %></td>
			<td><%= users.getEmail() %></td>
			<td><%= users.getPassword() %></td>
			<td><%= users.getDob() %></td>
			<td><%= users.getGender() %></td>
			<td><a href="user-update.jsp?id=<%=users.getId()%>">Edit</a></td>
			<td><a href="delete?id=<%=users.getId()%>">Delete</a></td>
		</tr>
		<%} %>
	</table>
</body>
</html>