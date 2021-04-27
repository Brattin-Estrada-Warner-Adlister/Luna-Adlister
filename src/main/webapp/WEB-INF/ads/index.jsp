<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="We're givin' ya all she's got Captain!" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>We're givin' ya all she's got Captain!</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2>${ad.title}</h2>
            <p>${ad.description}</p>
            <form action="/ads/delete" method="post">
                <input type="hidden" name="id" value="${ad.id}">
                <button>Delete Ad</button>
            </form>
        </div>
    </c:forEach>
</div>
</body>
</html>
