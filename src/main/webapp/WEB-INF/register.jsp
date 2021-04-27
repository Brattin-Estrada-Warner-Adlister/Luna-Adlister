<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" type="text/css" th:href="@{/css/style.css}"/>
<style>
  .container{
    background-color:  #0B4F6C;
    border: #757575;
    color: black;
  }
</style>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register Here!" />
    </jsp:include>
</head
<body>
    <h2 style="text-align:center;">Register User.</h2>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container">
      <div class="row main-content  text-center">
        <div class="col-md-4 text-center company__info">
          <span class="company__logo"><h2><span class="fa fa-android"></span></h2></span>
          <h4 class="company_title">Our
            Logo should be here</h4>
        </div>
        <div class="col-md-8 col-xs-12 col-sm-12 login_form ">
          <div class="container-100">
            <div class="row">
        <h1>Please fill in your information.</h1>
        <form action="/register" method="post">
            <div class="form-group">
                <label for="username">Username</label>
                <input id="username" name="username" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input id="email" name="email" class="form-control" type="text">
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input id="password" name="password" class="form-control" type="password">
            </div>
            <div class="form-group">
                <label for="confirm_password">Confirm Password</label>
                <input id="confirm_password" name="confirm_password" class="form-control" type="password">
            </div>
            <input type="submit" class="btn btn-primary btn-block">
        </form>
            <!-- Footer -->
            <div class="container-fluid text-center footer">
              Powered By: &trade; by <a href="#">Audi/Colin/Javier.</a></p>
            </div>
            </div>
          </div>
            </form>
          </div>
          </div>
        </div>
      </div>
    </div>
</body>
</html>
