<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>My first web page</title>

    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>
<%@ include file="navbar.jsp" %>
	<% String error = (String) request.getAttribute("savedMsg"); %>
	<% if (error != null) { %>
	   	<div class="saved-message"><%= error %></div>
	<% } %>
<main>
    <form action="userRegister" method="post" id="register-form" class="styled-form">

        <label for="userid">USERID:</label><br>
        <input type="text" placeholder="enter user id" name="id" id="userid" class="form-input"> <br>

        <label for="username">USERNAME:</label><br>
        <input type="text" placeholder="enter user name" name="name" id="username" class="form-input"> <br>

        <label for="useremail">USEREMAIL:</label><br>
        <input type="email" placeholder="enter user email" name="email" id="useremail" class="form-input"> <br>

        <label for="userpass">USERPASSWORD:</label><br>
        <input type="password" placeholder="enter user password" name="password" id="userpass" class="form-input"> <br>

        <label for="userdob">USERDOB:</label><br>
        <input type="date" placeholder="enter user dob" name="dob" id="userdob" class="form-input"> <br>

        <label>USERGENDER:</label>
		<div class="gender-group">
    		<input type="radio" name="gender" value="male">MALE
    		<input type="radio" name="gender" value="female">FEMALE
		</div>
        

        <input type="submit" value="Sign up" id="register-btn" class="form-submit">
    </form>
</main>
	<%@ include file="footer.jsp" %>
</body>
</html>