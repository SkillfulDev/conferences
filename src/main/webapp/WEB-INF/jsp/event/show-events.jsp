<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/editEvent.css"/>">
    <title>All events</title>
</head>
<body>
<div class="container">

    <table>
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Describe</th>
            <th>Date</th>
            <th>Place</th>
            <th>Action</th>
        </tr>
        <jsp:useBean id="events" scope="request" type="java.util.List"/>
        <c:forEach items="${events}" var="event">
            <tr id="${event.id}">
                <td>${event.id}</td>
                <td>${event.name}</td>
                <td>${event.describe}</td>
                <td>${event.date}</td>
                <td>${event.place}</td>
                <td>
                    <a href="<c:url value="/pages/event/edit-event?eventID=${event.id}"/>">Edit</a>
<%--                    <form action="<c:url value="/pages/event/edit-event?eventID=${event.id}"/>" method="get">--%>
<%--                        <input type="submit" value="Edit">--%>
<%--                    </form>--%>
                </td>
            </tr>
        </c:forEach>
    </table>
    <form>
        <input class="back-btn"  type="button" value="Back" onclick="history.back()">
    </form>
</div>

</body>
</html>
