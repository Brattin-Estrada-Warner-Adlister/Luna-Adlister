<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <a class="navbar-brand" href="/ads">Adlister</a>
        </div>

        <div class="search-container">
            <form class="form-inline" action="/ads/search" method="post">
                <input id="search" name="search" type="text">
                <button type="submit">Submit</button>
            </form>
        </div>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/login">Login</a></li>
            <li><a href="/register">Register</a></li>
        </ul>
    </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<nav class="navbar navbar-default bg-secondary">--%>
<%--    <div class="container-fluid">--%>
<%--        <!-- Brand and toggle get grouped for better mobile display -->--%>
<%--        <div class="d-flex align-items-center">--%>
<%--            <a  href="/users" id="adListView">Adlister</a>--%>
<%--        </div>--%>
<%--        <ul class="nav d-flex w-75 justify-content-end align-items-center">--%>
<%--            <c:choose>--%>
<%--                <c:when test="${!sessionScope.loggedIn}">--%>
<%--                    <li><a href="/login">Login</a></li>--%>
<%--                    <li><a href="/register">Register</a></li>--%>

<%--                </c:when>--%>
<%--                <c:otherwise>--%>
<%--                    <li><a href="/profile">Profile</a></li>--%>
<%--                    <li><a href="/logout">Logout</a></li>--%>
<%--                    <li><a href="/ads">View Ads</a></li>--%>
<%--                    <li><a href="/ads/create">Create Ad</a></li>--%>
<%--                    <form action="/ads/search" method="post" class="mb-0 ml-3" >--%>
<%--                        <select name="category" id="category" >--%>
<%--                            <option value="all">All</option>--%>
<%--                            <option value="clothes">Clothes</option>--%>
<%--                            <option value="auto">Auto</option>--%>
<%--                            <option value="children">Children</option>--%>
<%--                            <option value="pets">Pets</option>--%>
<%--                            <option value="home">Home</option>--%>
<%--                            <option value="miscellaneous">Miscellaneous</option>--%>
<%--                        </select>--%>
<%--                        <input type="text" name="searchTerm" id="search">--%>
<%--                        <button type="submit" class="btn">Search Ads</button>--%>
<%--                    </form>--%>
<%--                </c:otherwise>--%>
<%--            </c:choose>--%>

<%--        </ul>--%>
<%--    </div><!-- /.navbar-collapse -->--%>
<%--    </div><!-- /.container-fluid -->--%>
<%--</nav>--%>

