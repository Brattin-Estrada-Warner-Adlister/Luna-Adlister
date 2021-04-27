<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>
<style>
    .main-body {
        background-color: #0B4F6C;
        border: #757575;
        color: black;
    }

    .h1 {
        font-family: 'Rancho', cursive;
    }
</style>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!"/>
    </jsp:include>
</head>
<style>
</style>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">

    <h1>Welcome to the GigLister!</h1>
</div>
</body>
</html>