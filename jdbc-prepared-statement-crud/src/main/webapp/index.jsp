<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Registration System - Home</title>
    <link rel="stylesheet" type="text/css" href="css/index.css">
</head>
<body>

   
	<%@ include file="navbar.jsp" %>
    <!-- Hero Section -->
    <header class="form-header">
        <h1>Welcome to the User Registration System</h1>
        <p>Securely register, login, and manage your account with style.</p>
    </header>

    <!-- Features & About Project wrapped -->
    <div class="main-content">

        <!-- Features -->
        <section class="info-box">
            <h2>🔥 Features</h2>
            <ul>
                <li>📝 User Registration with form validation</li>
                <li>🔐 Secure Login with session handling</li>
                <li>📋 View, Edit & Delete users in real-time</li>
                <li>💾 MySQL Database Integration</li>
                <li>🎨 Marvel Comic Style User Interface</li>
            </ul>
        </section>

        <!-- About Project -->
        <section class="info-box">
            <h2>📢 About the Project</h2>
            <p>This is a full-stack web application titled <strong>"User Registration System"</strong> built using <strong>JSP, Servlets, and JDBC</strong>.</p>
            <p>Users can:</p>
            <ul>
                <li>✔️ Register and login</li>
                <li>✔️ Manage personal info (Update/Delete)</li>
                <li>✔️ View all users in an interactive table</li>
            </ul>
            <p>💡 Sessions are handled securely, ensuring authenticated access only.</p>
            <p>💬 The design is inspired by <strong>Marvel Comics</strong> to make it fun and professional!</p>
        </section>

    </div>

  	<%@ include file="footer.jsp" %>
</body>
</html>
