<%@ page import="com.jspider.jdbc_prepared_statement_crud.dto.User"%>
<%@ page import="com.jspider.jdbc_prepared_statement_crud.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<%@ include file="navbar.jsp" %>
	<%
	int id=Integer.parseInt(request.getParameter("id")); 
	User user = new UserDao().getUserByIdDao(id);
	%>
	
	<% String delete = (String) request.getAttribute("deleteMsg"); %>
	<% if (delete != null) { %>
	   	<div class="delete-message"><%= delete %></div>
	<% } %>
	
     
        
<main>
    <form action="userUpdate" method="post" id="register-form" class="styled-form">

        <label for="userid">USERID:</label><br>
        <input type="text" placeholder="enter user id" name="id" id="userid" class="form-input" value="<%=id%>"> <br>

        <label for="username">USERNAME:</label><br>
        <input type="text" placeholder="enter user name" name="name" id="username" class="form-input" value="<%=user.getName()%>"> <br>

        <label for="useremail">USEREMAIL:</label><br>
        <input type="email" placeholder="enter user email" name="email" id="useremail" class="form-input" value="<%=user.getEmail()%>"> <br>

        <label for="userpass">USERPASSWORD:</label><br>
        <input type="password" placeholder="enter user password" name="password" id="userpass" class="form-input" value="<%=user.getPassword()%>"> <br>

        <label for="userdob">USERDOB:</label><br>
        <input type="date" placeholder="enter user dob" name="dob" id="userdob" class="form-input" value="<%=user.getDob()%>"> <br>

        <label>USERGENDER:</label>
		<div class="gender-group">
    		<input type="radio" name="gender" value="male" <%if(user.getGender().equalsIgnoreCase("male")){ %> checked="checked"  <%} %> >MALE
    		<input type="radio" name="gender" value="female" <%if(user.getGender().equalsIgnoreCase("female")){ %> checked="checked"  <%} %>>FEMALE
		</div>
        

        <input type="submit" value="Update" id="register-btn" class="form-submit">
    </form>
</main>
	<%@ include file="footer.jsp" %>
</body>
</html>