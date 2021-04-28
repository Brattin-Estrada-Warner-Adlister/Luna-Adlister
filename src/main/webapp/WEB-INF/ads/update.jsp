<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<<<<<<< HEAD
=======
<%--
  Created by IntelliJ IDEA.
  User: javier.estrada
  Date: 4/22/21
  Time: 3:47 PM
  To change this template use File | Settings | File Templates.
--%>
>>>>>>> 2db44e94fa71e1ae2ce8bb0ff14f10aed34e3502
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Update Ads</title>
        <jsp:include page="/WEB-INF/partials/head.jsp">
            <jsp:param name="title" value="Your Profile" />
        </jsp:include>
        <link rel="stylesheet" href="../../css/main.css">
    </head>
    <body>
        <jsp:include page="/WEB-INF/partials/navbar.jsp" />
        <c:if test="${created == true}" >
            <h1 style="color: white; text-align: center;">Your Ad has been created.</h1>
        </c:if>

        <c:if test="${edited == true}" >
            <h1 style="color: white; text-align: center;">Your Ad has been updated.</h1>
        </c:if>

        <c:if test="${deleted == true}" >
            <h1 style="color: white; text-align: center;">Your Ad has been deleted</h1>
        </c:if>

        <div style="text-align: center">
            <div>
                <img src="../../img/myimg.png" class="">
            </div>
            <a href="/profile" style="color: white">Back to profile</a>
            <span style="color: white"> | </span>
            <a href="/home" style="color: white">To home page</a>
        </div>
    </body>
</html>



