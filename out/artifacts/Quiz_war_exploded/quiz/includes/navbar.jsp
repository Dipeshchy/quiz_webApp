<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 1/3/2019
  Time: 7:34 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="navbar">

    <ul>
        <li><a href="home?pageRequest=home">Home</a></li>
        <c:if test="${sessionScope.user.role=='admin'}">
        <li><a href="userlist?pageRequest=userlist">Userlist</a></li>
        <li><a href="questions?pageRequest=questions">Questions</a></li>
        </c:if>
        <c:if test="${sessionScope.user.role=='player'}">
            <li><a href="myprofile?pageRequest=myprofile&id=${user.id}">My Profile</a></li>
            <li><a href="playquiz?pageRequest=playQuiz&id=0">Play Quiz</a></li>
        </c:if>
        <li class="logout-item"><a href="logout?pageRequest=logout">Log Out</a></li>
    </ul>

</div>
<hr>
<h2>Welcome : ${sessionScope.user.username}</h2>
