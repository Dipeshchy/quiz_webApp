<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/10/2019
  Time: 10:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Score</title>
    <%@include file="../includes/header.jsp"%>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>
<div class="container" style="color: white;">
    <h1>Your Result</h1>
    <h4>Correct Answers : </h4>
    <h4>Wrong Answers : </h4>
    <table class="table table-striped" style="color: white;">
        <tr>
            <th>Question</th>
            <th>Correct Answer</th>
            <th>Your Answer</th>
            <th>Result</th>
        </tr>
        <c:forEach items="${scores}" var="score">
            <tr>
                <td>${score.question}</td>
                <td>${score.correct_answer}</td>
                <td>${score.given_answer}</td>
                <c:if test="${score.result=='Right'}">
                    <td style="background-color: green;">${score.result}</td>
                </c:if>
                <c:if test="${score.result=='Wrong'}">
                    <td style="background-color: red;">${score.result}</td>
                </c:if>

            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
