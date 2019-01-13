<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/4/2019
  Time: 3:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
<%@include file="../includes/navbar.jsp" %>
<hr>
<div class="container col-md-4">
    <form action="gametype" method="post" class="form-group" style="color: white;">
        <input type="hidden" name="pageRequest" value="gametype">
        <label>Select Category : </label>
        <select name="category" class="form-control">
            <option value="all">All</option>
            <option value="math">Math</option>
            <option value="science">Science</option>
            <option value="computer">Computer</option>
        </select>
        <br>
        <label>Select Difficulty Level : </label>
        <br>
        <input type="radio" name="difficulty_level" value="easy">Easy
        <input type="radio" name="difficulty_level" value="medium">Medium
        <input type="radio" name="difficulty_level" value="hard">Hard
        <br>
        <input type="submit" value="Lets Play" class="btn btn-warning">
    </form>
</div>
</body>
</html>
