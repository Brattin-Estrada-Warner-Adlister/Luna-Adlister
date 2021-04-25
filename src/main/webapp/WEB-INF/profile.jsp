<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>

<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>PROFILE PAGE</h1>
        <h3>Profile Picture?</h3>
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h3>Need to add a create add button on this page to redirect to /ads/create</h3>
    </div>

</body>
</html>
