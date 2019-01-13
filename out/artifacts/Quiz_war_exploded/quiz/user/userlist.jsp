<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/1/2019
  Time: 9:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
<%@include file="../includes/header.jsp"%>
</head>
<body>
<% request.getAttribute("userlist"); %>
<%@include file="../includes/navbar.jsp" %>
<div>

    <h1 style="color: red;">${msg}</h1>
</div>
<div>
    <table class="table table-striped" style="color: white;">
        <tr>
            <th>Username</th>
            <th>Password</th>
            <th>Role</th>
            <th>Edit</th>
            <th>Delete</th>

        </tr>
        <c:forEach items="${userlist}" var="user">
            <tr>
                <td>${user.username}</td>
                <td>${user.password}</td>
                <td>${user.role}</td>
                <td style="color: red;"><a href="edit?pageRequest=edit&id=${user.id}"><i class="fas fa-edit"></i></a></td>
                <td style="color: red;"><a href="delete?pageRequest=delete&id=${user.id}"><i class="fas fa-trash"></i></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>