<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/10/2019
  Time: 3:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Question</title>
    <%@include file="../includes/header.jsp"%>
    <style>
        .questions {
            color: white;
        }
    </style>
</head>
<body>
<%@include file="../includes/navbar.jsp"%>
<div class="container questions">
    <c:if test="${not empty question}">
    <h2>Lets Play</h2>
        <form action="nextquestion" method="post">
        <h4>Q. ${question.question} </h4>
            <input type="hidden" name="pageRequest" value="nextQuestion">
            <input type="hidden" name="id" value="${question.id}">
            <table class="col-md-12" style="color: white;">
                <tr>
                    <td>
                        <input type="radio" name="answer" value="${question.option1}"> 1. ${question.option1}
                    </td>
                    <td>
                        <input type="radio" name="answer" value="${question.option2}"> 2. ${question.option2}
                    </td>
                </tr>
                <tr>
                    <td>
                        <input type="radio" name="answer" value="${question.option3}"> 3. ${question.option3}
                    </td>
                     <td>
                         <input type="radio" name="answer" value="${question.option4}"> 4. ${question.option4}
                    </td>
                </tr>
            </table>
        <br>
            <input type="submit" class="btn btn-success" value="Next">
        </form>
    </c:if>
    <c:if test="${empty question}">
        <h2 style="color: white;">Completed</h2>
        <a href="viewresult?pageRequest=viewResult" class="btn btn-primary">View Result</a>
    </c:if>
</div>
</body>
</html>
