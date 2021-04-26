<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
    <style>
        #logo {
            position: absolute;
            width: 100%;
            height: 100%;
            top: 0;
            left: 0;
            right: 0;
            bottom: 0;
            z-index: 1;
        }
        #user {
            position: relative;
            z-index: 5;
        }
    </style>
</head>

<body>
<h2 style="text-align:center;">Users Profile.</h2>
<jsp:include page="/WEB-INF/partials/login.jsp" />
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <div class="jumbotron jumbotron-fluid m-auto text-center bg-primary" style="position: relative; z-index:
        0;">
        <img src="/logo.svg" id="logo" alt="">
        <h1 class="center m-auto" id="user">Welcome, ${sessionScope.user.username.toUpperCase()}!</h1>
    </div>

    <div class="row p-2">
        <div class="col col-4">
            <img alt="picture">
        </div>
<%--        EDIT/DELETE PROFILE--%>
        <div class="col col-8">
            <a href="/update" class="btn btn-edit_user" role="button">Edit Profile</a>
            <a href="/delete" class="btn btn-delete_user" role="button">Delete Profile</a>
        </div>
    </div>
>>>>>>> b20834dbafd7f090a589a36ba90e70d98ce04a0a
=======

    <jsp:include page="/WEB-INF/partials/login.jsp" />
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
>>>>>>> 438b99b9cb13d6397e7b55ad45f1db30df623770

    <div class="container">
        <h1>PROFILE PAGE</h1>
        <h3>Profile Picture?</h3>
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h3>Need to add a create add button on this page to redirect to /ads/create</h3>
    </div>

<<<<<<< HEAD
<<<<<<< HEAD
<%--    <div class="col col-8">--%>
<%--        <a href="/update" class="btn btn-info" role="button">Edit Profile</a>--%>
<%--        <a href="/delete" class="btn btn-warning" role="button">Delete Profile</a>--%>
<%--    </div>--%>

=======
</div>
>>>>>>> b20834dbafd7f090a589a36ba90e70d98ce04a0a
=======
>>>>>>> 438b99b9cb13d6397e7b55ad45f1db30df623770
</body>
</html>

<%--INITIAL PROFILE JSP CODE FOR BACKUP--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>--%>

<%--<head>--%>
<%--    <jsp:include page="/WEB-INF/partials/head.jsp">--%>
<%--        <jsp:param name="title" value="Your Profile" />--%>
<%--    </jsp:include>--%>
<%--</head>--%>
<%--<body>--%>
<%--    <jsp:include page="/WEB-INF/partials/navbar.jsp" />--%>

<%--    <div class="container">--%>
<%--        <h1>PROFILE PAGE</h1>--%>
<%--        <h3>Profile Picture?</h3>--%>
<%--        <h1>Welcome, ${sessionScope.user.username}!</h1>--%>
<%--        <h3>Need to add a create add button on this page to redirect to /ads/create</h3>--%>
<%--    </div>--%>

<%--</body>--%>
<%--</html>--%>
