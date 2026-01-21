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
		<% String pass = (String) request.getAttribute("passMismatch"); %>
	<% if (pass != null) { %>
	   	<div class="pass-mismatch-message"><%= pass %></div>
	<% } %>
	
	<% String errorMsg = (String) request.getAttribute("errorMsg"); %>
	<% if (errorMsg != null) { %>
	   	<div class="login-message"><%=errorMsg%></div>
	<% } %>
	
	<% String logout = (String) request.getAttribute("logout"); %>
	<% if (logout != null) { %>
	   	<div class="login-message"><%=logout%></div>
	<% } %>
	
    <div class="login-form">
        <h2>User Login</h2>
        <form action="login" method="post">
            <label for="email">Email:</label>
            <input type="email" name="email" id="email" required>

            <label for="password">Password:</label>
            <input type="password" name="password" id="password" required>

            <input type="submit" value="Login">
        </form>
    </div>

    <%@ include file="footer.jsp" %>

	    <!-- <form action="login" method="get">
        <label>Email:</label><br>
        <input type="email" name="email" required><br><br>

        <label>Password:</label><br>
        <input type="password" name="password" required><br><br>

        <input type="submit" value="Login">
    </form> -->
</body>
</html>