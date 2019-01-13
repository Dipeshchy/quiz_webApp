<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/2/2019
  Time: 11:28 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="../includes/header.jsp" %>
</head>
<body>
<%@include file="../includes/navbar.jsp" %>
<div>

    <h1>Lets Play</h1>

    <form action="questionsanswer" method="post" class="form-group" style="color: white;margin-left:150px;">
        <input type="hidden" name="pageRequest" value="questionsanswer">
      <c:forEach items="${questionList}" var="question" varStatus="myIndex">
        <label style="font-size: 30px;">${myIndex.index+1}. ${question.question}</label>
          <br>
          <input type="radio" name="answer" value="${question.option1}"> ${question.option1}
          <br>
          <input type="radio" name="answer" value="${question.option2}"> ${question.option2}
          <br>
          <input type="radio" name="answer" value="${question.option3}"> ${question.option3}
          <br>
          <input type="radio" name="answer" value="${question.option4}"> ${question.option4}
          <hr>
      </c:forEach>
        <br>
        <input type="submit" value="Submit" class="btn btn-success">
    </form>
</div>
</body>
</html>
