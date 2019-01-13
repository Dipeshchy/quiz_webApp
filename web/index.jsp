<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/1/2019
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
</head>
<style>
    body {
        background: #2d343d;
    }

    .login {
        margin: 20px auto;
        width: 300px;
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
<form class="login" method="post" action="login">
    <h1 class="login-title">Simple Login</h1>
    <h2>${msg}</h2>
    <input type="hidden" name="pageRequest" value="login">
    <input type="text" name="username" class="login-input" placeholder="Username" autofocus>
    <input type="password" name="password" class="login-input" placeholder="Password">
    <br>
    <label>Role : </label>
    <select name="role" class="login-input">
        <option value="admin">Admin</option>
        <option value="player">Player</option>
    </select>
    <br>
    <input type="submit" value="Lets Go" class="login-button">
    <br>
    <a href="signup?pageRequest=signuppage">Register here..</a>
</form>
</body>
</html>

