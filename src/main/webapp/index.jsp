<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>

    <head>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Welcome to my site!" />
        </jsp:include>
    </head>
    <style>
    </style>
    <body>
        <h2 style="text-align:center;">Welcome to Adlister.</h2>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <div class="container">

        </div>
    </body>
</html>
