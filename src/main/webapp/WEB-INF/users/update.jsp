<html>
<head>
    <title>Update</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Update User" />
    </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>

<div class="container p-5">
    <h1>Edit Profile:</h1>

    <form method="post" action="/update">
        <input type="text" value="${sessionScope.user.id}" name="id" hidden>
        <input type="text" class="form-control" id="password" name="password"
               value="${sessionScope.user.password}" hidden>

        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" class="form-control" id="username" name="username" value="${sessionScope.user.username}">
        </div>
        <div class="form-group">
            <label for="email">Email</label>
            <input type="text" class="form-control" id="email" name="email" value="${sessionScope.user.email}">
        </div>
        <%--    this is fake--%>
        <div class="form-group">
            <label for="fake">Password</label>
            <input type="text" class="form-control" id="fake"
                   value="Password cannot be updated" disabled>
        </div>
        <div class="form-group">
            <label for="img">Image URL:</label>
            <input type="text" class="form-control" id="img" name="img" value="${sessionScope.user.avatar}">
        </div>
        <a href="/profile" class="btn btn-primary">Back</a>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form>
</div>

</body>
</html>