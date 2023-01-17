<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 15.12.2022
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="../css/style.css">
    <title>Title</title>
</head>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>--%>
<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<body>
<jsp:useBean id="event" scope="request" type="com.conference.model.Event"/>

<form action="<%= request.getContextPath() %>pages/edit/${event.id}" method="post">
    <div class="container">
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" value="${event.name}"/><br>
            <label for="name">Describe:</label>
            <input type="text" id="describe" name="describe" value="${event.describe}"/><br>
            <label for="name">Date:</label>
            <input type="datetime-local" id="date" name="date" value="${event.date}"/><br>
            <label for="name">Place:</label>
            <input type="text" id="place" name="place" value="${event.place}"/><br>
            <label>Topics:</label>
            <div class="topic-container">

                <div id="topic-main">
                    <c:forEach items="${event.topics}" var="topic">
                        <input type="text" name="topic" value="${topic.name}"/>
                    </c:forEach>
                </div>


                <p>Add new topic</p>
                <button type="button" id="topic-btn" class="topic-btn-add">+</button>
            </div>
            <%--            <input type="text" id="topic" name="topic" value= "${event.topics}"/><br><br>--%>
            <%--            <c:forEach items="${event.topics}" var="topic">--%>
            <%--                <input type="text" name="topic" value="${topic.name}"/><br><br>--%>
            <%--            </c:forEach>--%>
            <input type="submit" class="registerbtn" value="Send">
        </div>
    </div>
    <form>
        <input class="back-btn" type="button" value="Back" onclick="history.back()">
    </form>
</form>


<script src="../js/topic.js"></script>

</body>
</html>
