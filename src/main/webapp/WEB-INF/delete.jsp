<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Delete Profile" />
</jsp:include>
<html>
<head>
    <title>Delete</title>
    <style>
        body {
            background-color: cornflowerblue;
            text-align: center;
            margin-top: 10%;
        }
    </style>
</head>
<body>
<h1>Are you sure you want to delete your awesome profile?!</h1>
<form method="post" action="/delete">
    <input type="text" value="${sessionScope.user.id}" name="id" hidden>
    <button type="submit" class="btn btn-danger">Are You Sure?</button>
</form>
<form action="/profile">
    <input type="text" value="${sessionScope.user.id}" name="id" hidden>
    <button type="submit" class="btn btn-success">Go Back to Profile</button>
</form>
</body>
</html>