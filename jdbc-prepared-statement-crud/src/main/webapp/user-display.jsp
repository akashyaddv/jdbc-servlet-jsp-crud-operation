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
	<%@ include file="navbar.jsp" %>
	<%
	List<User> user = new UserDao().getAllUserDao();
	HttpSession httpSession = request.getSession();
	String email = (String)httpSession.getAttribute("userSession"); 
	%>
	
	<% String update = (String) request.getAttribute("updateMsg"); %>
	<% if (update != null) { %>
	   	<div class="update-message"><%= update %></div>
	<% } %>
	
	
		<% String delete = (String) request.getAttribute("deleteMsg"); %>
	<% if (delete != null) { %>
	   	<div class="delete-message"><%= delete %></div>
	<% } %>
	
	
	<% String login = (String) request.getAttribute("login"); %>
	<% if (login != null) { %>
	   	<div class="login-message"><%= login %></div>
	<% } %>
	
	<%if(email!=null){ %>
	
	<%} %>
	
	<h1 class="table-heading">User List</h1>
<main>
	<div class="table-container">
		<table class="styled-table">
			<tr>
				<th>ID</th>
				<th>NAME</th>
				<th>EMAIL</th>
				<th>PASSWORD</th>
				<th>DOB</th>
				<th>GENDER</th>
				<th colspan="2">ACTION</th>
			</tr>
			<%
			for (User users : user) {
			%>
			<tr>
				<td><%=users.getId()%></td>
				<td><%=users.getName()%></td>
				<td><%=users.getEmail()%></td>
				<td><%=users.getPassword()%></td>
				<td><%=users.getDob()%></td>
				<td><%=users.getGender()%></td>
				<td><a class="edit-btn"
					href="user-update.jsp?id=<%=users.getId()%>">Edit</a></td>
				<td><a class="delete-btn" href="delete?id=<%=users.getId()%>">Delete</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
	
</main>
	

<%@ include file="footer.jsp" %>

</body>
</html>