<%--
  Created by IntelliJ IDEA.
  User: y.chernonog
  Date: 01.12.2022
  Time: 14:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/main.css">

    <title>Account</title>
</head>

<body>
<div class="container">
    <select class="change-lang">
        <option value="ua">UA</option>
        <option value="en">EN</option>
    </select>

    <div class="container-left">
        <div class="logo-user">
            <div class="photo-user">
                <img src="" alt="">
            </div>
        </div>
        <div class="contacts">
            <p class="email">qwerty@qwerty.com</p>
            <p class="phone">000-000-00-00</p>
        </div>
        <div class="edit-buttons">
            <c:choose>
                <c:when test="${sessionScope.get('user') == null}">
                    <form action="<%= request.getContextPath() %>/pages/login">
                        <button id="btn-login">Sign In</button>
                    </form>
                    <form action="<%= request.getContextPath() %>/pages/register">
                        <button id="btn-reg">Sign Up</button>
                    </form>
                </c:when>
                <c:otherwise>
                    <form action="<%= request.getContextPath() %>/pages/settings">
                        <button id="btn-edit">Edit</button>
                    </form>
                    <form action="<%= request.getContextPath() %>/pages/logout" method="post">
                        <button id="btn-logout">Log Out</button>
                    </form>
                </c:otherwise>
            </c:choose>
        </div>
    </div>

    <div class="container-center scroll">

        <div class="side-navigation">
            <ul id="myNode" class="side-navigation__content">

            </ul>
        </div>

        <c:forEach items="${events}" var="event">

            <div class="container-event">
                <div class="container-article" id="${event.id}">
                    <div class="conference-header">
                        <h2>${event.name}</h2>
                    </div>
                    <div class="conference-main">
                        <p>${event.describe}</p>
                        <p>${event.date}</p>
                        <p>${event.place}</p>
                        <br>
                        <h3>Topics:</h3>

                        <c:set var="i" value="0" scope="page"/>
                        <c:forEach items="${event.topics}" var="topic">

                            <c:set var="i" value="${i + 1}" scope="page"/>
                            <p>${i}. ${topic.name}</p>

                        </c:forEach>
                    </div>
                    <div>

                    </div>

                    <div class="conference-footer">
                        <c:if test="${sessionScope.role == 'USER'}">
                            <form action="<%= request.getContextPath() %>/speaker/${event.id}">

                                <button id="btn-speaker">Join as a Speaker</button>

                            </form>
                        </c:if>
                        <button id="btn-join">Join</button>
                    </div>
                </div>
            </div>
        </c:forEach>

    </div>

    <div class="container-right">
        <%--        <c:if test="${sessionScope.role == 'MODERATOR'}">--%>
        <c:if test="${sessionScope.role == 'MODERATOR'}">
            <h2>Admin Panel</h2>
            <form action="<%= request.getContextPath() %>/eventRegistration">
                <button>Add event</button>
            </form>
            <form action="<%= request.getContextPath() %>/edit">
                <button>Edit Event</button>
            </form>
            <form action="<%= request.getContextPath() %>/request">
                <button>Request List</button>
            </form>
        </c:if>
        <c:if test="${sessionScope.role == 'SPEAKER'}">
            <form action="<%= request.getContextPath() %>/showSpeakerTopic/${user.id}">
                <button>Show my topic</button>
            </form>
        </c:if>
        <c:if test="${sessionScope.role == 'USER'}">
            <form action="<%= request.getContextPath() %>/eventRegistration">
                <button>Show my Event</button>
            </form>
        </c:if>
    </div>
</div>


<%--<script src="https://cdnjs.cloudflare.com/ajax/libs/gsap/1.19.1/TweenMax.min.js"></script>--%>
<%--<script type="text/javascript" src="../js/cssanimation-gsap.js"></script>--%>
<%--<script type="module" src="../js/lang.js"></script>--%>
<%--<script type="module" src="../js/changeLang.js"></script>--%>

<script>

    window.addEventListener('load', function () {
        const event_parent = document.querySelectorAll('.container-event .container-article');
        const container_articled = document.getElementsByClassName('.container-event >.container-article');
        // console.log(container_articled)
        // const paginatParent = document.querySelectorAll('.side-navigation .side-navigation__item');

        // parent.addEventListener('change', rebuildPagination)

        const paginat_parent = document.getElementById('myNode');

        for (let i = 1; i <= event_parent.length; i++) {
            var a_link = document.createElement("a");
            var span = document.createElement("span");
            var li = document.createElement("li");

            span.setAttribute("class", "test");
            txt = document.createTextNode(i);
            span.appendChild(txt);

            a_link.setAttribute("class", "side-navigation__link")
            a_link.setAttribute("href", "#" + i);
            a_link.appendChild(span);


            li.setAttribute("class", "side-navigation__item"); // added line
            li.appendChild(a_link);
            paginat_parent.appendChild(li);

        }
    });


</script>

</body>

<script type="module" src="../js/lang.js"></script>
<script type="module" src="../js/changeLang.js"></script>
</html>
