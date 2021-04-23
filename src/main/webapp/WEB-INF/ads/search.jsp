<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <title>Ads</title>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h2>Ads Related to Your Search</h2>


    <c:forEach var="ad" items="${ads}">
        <div class="card col-md-6">
            <div class="card-body">
                <h4 class="card-title">${ad.title}</h4>
                <p class="card-text">${ad.description}</p>
            </div>
        </div>
    </c:forEach>
</div>

</body>
</html>