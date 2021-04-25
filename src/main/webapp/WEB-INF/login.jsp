<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<link rel="stylesheet" type="text/css" tf:href="@{/css/style.css}"/>
<head>
  <jsp:include page="/WEB-INF/partials/head.jsp">
    <jsp:param name="title" value="Please Log In"/>
  </jsp:include>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp"/>
<div class="container">
  <h2 style="text-align:center;">Login Page.</h2>
  <form action="/login" method="POST">
    <div class="container">
      <div class="row main-content bg-success text-center">
        <div class="col-md-4 text-center company__info">
          <span class="company__logo"><h2><span class="fa fa-android"></span></h2></span>
<%--
      <image src="src/main/webapp/img/logo"></image>
--%>
        </div>
        <div class="col-md-8 col-xs-12 col-sm-12 login_form ">
          <div class="container-100">
            <div class="row">
              <h2>Log In</h2>
            </div>
            <div class="row">
              <form control="" class="form-group">
                <div class="row">
                  <input type="text" name="username" id="username" class="form__input" placeholder="Username">
                </div>
                <div class="row">
                  <!-- <span class="fa fa-lock"></span> -->
                  <input type="password" name="password" id="password" class="form__input" placeholder="Password">
                </div>
                <div class="row">
                  <input type="checkbox" name="remember_me" id="remember_me" class="">
                  <label for="remember_me">Remember Me!</label>
                </div>
                <div class="row">
                  <input type="submit" value="Submit" class="btn">
                </div>
              </form>
            </div>
            <div class="row">
              <p>Don't have an account? <a href="#">Register Here</a></p>
            </div>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer -->
    <div class="container-fluid text-center footer">
      Powered By: &trade; by <a href="https://bit.ly/yinkaenoch">Audi/Colin/Javier.</a></p>
    </div>
  </form>
</div>
</body>
</html>
