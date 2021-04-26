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

    <jsp:include page="/WEB-INF/partials/login.jsp" />
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>PROFILE PAGE</h1>
        <h3>Profile Picture?</h3>
        <h1>Welcome, ${sessionScope.user.username}!</h1>
        <h3>Need to add a create add button on this page to redirect to /ads/create</h3>
    </div>

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
