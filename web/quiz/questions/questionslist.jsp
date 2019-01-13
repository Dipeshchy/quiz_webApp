<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/2/2019
  Time: 4:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
<% request.getAttribute("questionList"); %>
<%@include file="../includes/navbar.jsp" %>
<div>

    <h1 style="color: red;">${msg}</h1>
</div>
<div>

    <hr>
    <form action="questionCategory" method="post" style="color: white;">
        <input type="hidden" name="pageRequest" value="selectByCategory">
        <label>Select By Category</label>
        <select name="selectedCategory">
            <option value="math">Math</option>
            <option value="science">Science</option>
            <option value="computer">Computer</option>
        </select>
        <input class="btn btn-danger" type="submit" value="Search">
    </form>
    <br>
    <form action="questionDifficulty" method="post" style="color: white;">
        <input type="hidden" name="pageRequest" value="selectByDifficultyLevel">
        <label>Select By Difficulty Level</label>
        <select name="selectedDifficultyLevel">
            <option value="easy">Easy</option>
            <option value="medium">Medium</option>
            <option value="hard">Hard</option>
        </select>
        <input class="btn btn-danger" type="submit" value="Search">
    </form>
    <hr>
    <h2><a href="addQuestion?pageRequest=addQuestionPage" style="color: white;">Add New Question</a></h2>
    <hr>
    <table class="table table-striped table-bordered" style="color: white;">
        <tr>
            <th>Question</th>
            <th>Option 1</th>
            <th>Option 2</th>
            <th>Option 3</th>
            <th>Option 4</th>
            <th>Correct Answer</th>
            <th>Category</th>
            <th>Difficulty Level</th>
            <th>Edit</th>
            <th>Delete</th>
        </tr>
        <c:forEach items="${questionList}" var="question">
            <tr>
                <td>${question.question}</td>
                <td>${question.option1}</td>
                <td>${question.option2}</td>
                <td>${question.option3}</td>
                <td>${question.option4}</td>
                <td>${question.correct_answer}</td>
                <td>${question.category}</td>
                <td>${question.difficulty_level}</td>
                <td style="color: red;"><a href="editQuestion?pageRequest=editQuestion&id=${question.id}"><i class="fas fa-edit"></i></a></td>
                <td style="color: red;"><a href="deleteQuestion?pageRequest=deleteQuestion&id=${question.id}"><i class="fas fa-trash"></i></a></td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
