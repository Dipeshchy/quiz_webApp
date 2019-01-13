<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/2/2019
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="../includes/header.jsp"%>
</head>
<style>
    body {
        background: #2d343d;
    }

    .login {
        margin: 20px auto;
        width: 400px;
        padding: 30px 25px;
        background: white;
        border: 1px solid #c4c4c4;
    }

    h1.login-title {
        margin: -28px -25px 25px;
        padding: 15px 25px;
        line-height: 30px;
        font-size: 25px;
        font-weight: 300;
        color: #ADADAD;
        text-align:center;
        background: #f7f7f7;

    }

    .login-input {
        width: 285px;
        height: 50px;
        margin-bottom: 25px;
        padding-left:10px;
        font-size: 15px;
        background: #fff;
        border: 1px solid #ccc;
        border-radius: 4px;
    }
    .login-input:focus {
        border-color:#6e8095;
        outline: none;
    }
    .login-button {
        width: 100%;
        height: 50px;
        padding: 0;
        font-size: 20px;
        color: #fff;
        text-align: center;
        background: #f0776c;
        border: 0;
        border-radius: 5px;
        cursor: pointer;
        outline:0;
    }

    .login-lost
    {
        text-align:center;
        margin-bottom:0px;
    }

    .login-lost a
    {
        color:#666;
        text-decoration:none;
        font-size:13px;
    }
    h2 {
        color : red;
    }


</style>
<body>
<%@include file="../includes/navbar.jsp" %>
<form class="login" method="post" action="update">
    <h1 class="login-title">Edit User</h1>
    <h2>${msg}</h2>
    <input type="hidden" name="pageRequest" value="update">
    <input type="hidden" name="id" value="${user.id}">
    <input type="text" name="username" class="login-input" value="${user.username}" placeholder="${user.username}" autofocus>
    <input type="text" name="password" class="login-input" placeholder="${user.password}" value="${user.password}">

    <br>
    <label>Role : </label>
    <select name="role" class="login-input">
        <option value="admin">Admin</option>
        <option value="player">Player</option>
    </select>
    <br>
    <input type="submit" value="Edit" class="login-button">
</form>
</body>
</html>
