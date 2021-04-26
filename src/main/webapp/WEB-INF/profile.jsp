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
<<<<<<< HEAD
    <jsp:include page="/WEB-INF/partials/login.jsp" />
=======
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

<%--    USER'S ADS--%>
    <h2 class="text-capitalize">Current Ads:</h2>
    <div class="row">
        <c:forEach var="ad" items="${userAds}">
            <div class="card col col-10 mx-auto mb-4">
                <div class="card-title bg-primary text-center">
                    <h1>${ad.title}</h1></div>
                <div class="card-body">
                    <div class="card-text"><h2>${ad.description}</h2></div>
                    <a href="/ads/edit?adId=${ad.id}" class="btn btn-edit_ad" role="button">Edit Ad</a>
                    <a href="/ads/delete?adId=${ad.id}" class="btn btn-delete_ad" role="button">Delete Ad</a>
                </div>
                <div class="d-flex">
                    <c:forEach var="category" items="${ad.categories}">
                        <span class="badge badge-pill badge-info mx-2">${category}</span>
                    </c:forEach>
                </div>
            </div>
        </c:forEach>
    </div>

<<<<<<< HEAD
<%--    <div class="col col-8">--%>
<%--        <a href="/update" class="btn btn-info" role="button">Edit Profile</a>--%>
<%--        <a href="/delete" class="btn btn-warning" role="button">Delete Profile</a>--%>
<%--    </div>--%>

=======
</div>
>>>>>>> b20834dbafd7f090a589a36ba90e70d98ce04a0a
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
