<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/2/2019
  Time: 4:16 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
<%@include file="../includes/navbar.jsp" %>
<div class="container">
    <h1>Add Question</h1>
<form action="addQuestion" method="post" class="form-group col-md-4" style="color: white;">
    <input type="hidden" name="pageRequest" value="addQuestion">
    <label>Question</label>
    <input type="text" name="question" class="form-control">

    <label>Option 1</label>
    <input type="text" name="option1" class="form-control">

    <label>Option 2</label>
    <input type="text" name="option2" class="form-control">

    <label>Option 3</label>
    <input type="text" name="option3" class="form-control">

    <label>Option 4</label>
    <input type="text" name="option4" class="form-control">

    <label>Correct Answer</label>
    <input type="text" name="correct_answer" class="form-control">

    <label>Category</label>
    <select name="category" class="form-control">
        <option value="math">Math</option>
        <option value="science">Science</option>
        <option value="computer">Computer</option>
    </select>

    <label>Difficulty Level</label>
    <select name="difficulty_level" class="form-control">
        <option value="easy">Easy</option>
        <option value="medium">Medium</option>
        <option value="hard">Hard</option>
    </select>

    <input type="submit" value="Add Question" class="btn btn-success">
</form>
</div>
</body>
</html>
