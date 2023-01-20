<%--
  Created by IntelliJ IDEA.
  User: Евгений
  Date: 08.12.2022
  Time: 22:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="../css/style.css">
</head>
<body>

<form action="<%= request.getContextPath() %>/pages/settings" method="post">

    <div class="container">
        <h1>The input elements</h1>
        <div>
            <%--        <label for="role">Role:</label>--%>
            <p> ${sessionScope.get('user').role}</p><br><br>
            <label for="login">Login:</label>
            <input type="text" id="login" name="login" value="${sessionScope.get('user').login}"><br><br>

            <label for="first_name">First Name:</label>
            <input type="text" id="first_name" name="first_name" value="${sessionScope.get('user').firstName}"><br><br>

            <label for="second_name">Second Name:</label>
            <input type="text" id="second_name" name="second_name" value="${sessionScope.get('user').secondName}"><br><br>

            <label for="email">Email :</label>
            <input type="email" id="email" name="email" value="${sessionScope.get('user').email}"><br><br>

            <label for="password">Password:</label>
            <input type="password" id="password" name="password"><br><br>

            <button type="submit" class="registerbtn" value="Submit">Submit</button>
            <form>
                <input class="back-btn" type="button" value="Back" onclick="history.back()">
            </form>
        </div>
    </div>
</form>
</body>

</html>

<!-- <form action="<%= request.getContextPath() %>/settings" method="post">
<label for="login">Login:</label>
<input type="text" id="login" name="login" value="${user.login}"><br><br>
<label for="email">Email :</label>
<input type="email" id="email" name="email" value="${user.email}"><br><br>
<label for="password">Password:</label>
<input type="password" id="password" name="password"><br><br>
<input type="submit" value="Submit">
</form> -->