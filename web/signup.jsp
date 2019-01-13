<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/1/2019
  Time: 8:55 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="quiz/includes/header.jsp" %>
</head>

<body>
<form class="login" method="post" action="signup">
    <h1 class="login-title">Sign Up Page</h1>
    <h2>${msg}</h2>
    <input type="hidden" name="pageRequest" value="signup">
    <input type="text" name="username" class="login-input" placeholder="Username" autofocus>
    <br>
    <input type="password" name="password" class="login-input" placeholder="Password">
    <input type="submit" value="Sign Up" class="login-button">
</form>
</body>
</html>
