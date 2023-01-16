<%@ page contentType="text/html;charset=utf-8" %>
<!DOCTYPE html>
<html lang="en ">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../css/style.css">
    <title>Document</title>
</head>
<body>
<form action="/pages/login" method="post">
    <div class="container">
        <h1 class="login-h1">Sign in</h1>

        <label for="login"><b>Login</b></label>
        <input type="text" placeholder="Enter Login" name="login" required>

        <label for="password"><b>Password</b></label>
        <input type="password" placeholder="Enter Password" name="password" required>


        <hr>
        <button type="submit" class="registerbtn">Sign in</button>


    </div>
</form>
</body>
</html>