<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/3/2019
  Time: 9:23 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>

<div class="container" style="color: white;">
    <h1 class="text-info">My Profile</h1>
    <hr>
    <h3>Username : ${user.username}</h3>
    <h3>Password : ${user.password}</h3>
    <h3>Role : ${user.role}</h3>
</div>
</body>
</html>
