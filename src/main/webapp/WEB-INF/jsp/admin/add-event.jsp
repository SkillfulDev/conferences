<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 12.12.2022
  Time: 10:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="<c:url value="/css/style.css"/>">
</head>

<body>
<div class="container">

    <form action="/pages/admin/add-event" method="post">

        <div>
            <p>Event name</p>
            <input name="name" type="text" required>

            <div>
                <p>Event Describe</p>
                <textarea name="descr" cols="50" rows="10" required></textarea>
            </div>

            <p>Place</p>
            <input name="place" type="text" required>

            <p>Event date</p>
            <input type="datetime-local" name="date" required>

            <p>Topic</p>
            <div class="topic-container">

                <div id="topic-main">
                    <input name="topic" type="text" required>
                </div>


                <p>Add new topic</p>
                <button type="button" id="topic-btn" class="topic-btn-add">+</button>
            </div>

            <div>
                <button type="submit" class="registerbtn">Submit</button>
            </div>
            <input class="back-btn" type="button" value="Back" onclick="history.back()">
        </div>
    </form>

</div>
<script src="<c:url value="/js/topic.js"/>">

</script>
</body>

</html>