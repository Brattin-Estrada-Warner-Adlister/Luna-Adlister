<%--
  Created by IntelliJ IDEA.
  User: javier.estrada
  Date: 4/22/21
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
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