<%--
  Created by IntelliJ IDEA.
  User: Asus
  Date: 3/10/2024
  Time: 12:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginTest</title>
</head>
<body>
<div>
    <form action="login.do" method="post">
        <label>User Name</label>
        <br>
        <input type="text" name="username" id="username" placeholder="username" required>
        <br>
        <label>Password</label>
        <br>
        <input type="password" id="password" name="password" placeholder="password" required>
        <br>
        <label>Remember Me</label>
        <input type="checkbox"  name="rememberMe" value="rememberMe">
        <br>
        <a href="forgot.do"> Forgot Password? </a>
    </form>
</div>
</body>
</html>
