<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/2/2019
  Time: 8:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="../includes/header.jsp"%>
</head>
<body>
<%@include file="../includes/navbar.jsp" %>
<div class="container">
<h1>Edit Question</h1>
<form action="updateQuestion" method="post" class="form-group col-md-4" style="color: white;">
    <input type="hidden" name="pageRequest" value="updateQuestion">
    <input type="hidden" name="id" value="${question.id}">
    <label>Question</label>
    <input type="text" name="question" class="form-control" value="${question.question}">

    <label>Option 1</label>
    <input type="text" name="option1" class="form-control" value="${question.option1}">

    <label>Option 2</label>
    <input type="text" name="option2" class="form-control" value="${question.option2}">

    <label>Option 3</label>
    <input type="text" name="option3" class="form-control" value="${question.option3}">

    <label>Option 4</label>
    <input type="text" name="option4" class="form-control" value="${question.option4}">

    <label>Correct Answer</label>
    <input type="text" name="correct_answer" class="form-control" value="${question.correct_answer}">

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

    <input type="submit" value="Edit Question" class="btn btn-success">
</form>
</div>
</body>
</html>
