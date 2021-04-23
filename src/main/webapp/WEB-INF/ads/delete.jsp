<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<h1 style="color: green;">Your ad was successfully deleted!</h1>
<a href="/profile">Go back to profile</a>
<a href="/home">Go to home page</a>
</body>
</html>