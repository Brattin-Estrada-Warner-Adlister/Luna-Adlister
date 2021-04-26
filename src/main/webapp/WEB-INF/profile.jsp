<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>

<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>
</head>

<body>
    <jsp:include page="/WEB-INF/partials/login.jsp" />

    <div class="container">
        <h1>PROFILE PAGE</h1>
        <h3>Profile Picture?</h3>
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h3>Need to add a create add button on this page to redirect to /ads/create</h3>
    </div>

<%--    <div class="col col-8">--%>
<%--        <a href="/update" class="btn btn-info" role="button">Edit Profile</a>--%>
<%--        <a href="/delete" class="btn btn-warning" role="button">Delete Profile</a>--%>
<%--    </div>--%>

</body>
</html>
