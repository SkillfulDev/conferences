<%--<%@ page language="java" contentType="text/html; charset=ISO-8859-1"--%>
<%--         pageEncoding="ISO-8859-1"%>--%>
<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <title>Register</title>
</head>
<body>
<form action="<%= request.getContextPath() %>/pages/register" method="post">
    <div class="container">
        <h1>Register</h1>
        <p>Please fill in this form to create an account.</p>

        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter Login" name="login" required>

        <label for="first_name"><b>First Name</b></label>
        <input type="text" placeholder="Enter First Name" name="first_name" required>

        <label for="second_name"><b>Second Name</b></label>
        <input type="text" placeholder="Enter Second Name" name="second_name" required>

        <label for="email"><b>Email</b></label>
        <input type="text" placeholder="Enter Email" name="email" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>
        <hr>

        <button type="submit" class="registerbtn">Register</button>
    </div>

    <div class="signin">
        <p>Already have an account? <a href="<%= request.getContextPath() %>/pages/login">Sign In</a></p>
    </div>
</form>
</body>
</html>