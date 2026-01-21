<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="register" method="get">
        <label for="id">ID:</label><br>
        <input type="number" id="id" name="id" placeholder="Enter your ID" required><br><br>

        <label for="name">Name:</label><br>
        <input type="text" id="name" name="name" placeholder="Enter your full name" required><br><br>

        <label for="email">Email:</label><br>
        <input type="email" id="email" name="email" placeholder="Enter your email" required><br><br>

 		<label for="password">Password:</label><br>
        <input type="password" id="password" name="password" placeholder="Enter a strong password" required><br><br>
        
         <label for="dob">Date of Birth:</label><br>
        <input type="date" id="dob" name="dob" required><br><br>
        
        
         <label for="gender">Gender:</label><br>
        <select id="gender" name="gender" required>
            <option value="">--Select Gender--</option>
            <option value="Male">Male</option>
            <option value="Female">Female</option>
            <option value="Other">Other</option>
        </select><br><br>
        
       
       

       

        <input type="submit" value="Register">
    </form>
	

</html>