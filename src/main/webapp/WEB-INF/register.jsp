<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="partials/head.jsp">
        <jsp:param name="title" value="Register Here!" />
    </jsp:include>
</head>
<style>
  /*.container {*/
  /*  background-color: crimson;*/
  /*}*/
  .main-content{
    width: 50%;
    border-radius: 20px;
    box-shadow: 0 5px 5px rgba(0,0,0,.4);
    margin: 5em auto;
    display: flex;
  }
  .company__info{
    background-color: #008080;
    border-top-left-radius: 20px;
    border-bottom-left-radius: 20px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    color: #fff;
  }
  .fa-android{
    font-size:3em;
  }
  @media screen and (max-width: 640px) {
    .main-content{width: 90%;}
    .company__info{
      display: none;
    }
    .login_form{
      border-top-left-radius:20px;
      border-bottom-left-radius:20px;
    }
  }
  @media screen and (min-width: 642px) and (max-width:800px){
    .main-content{width: 70%;}
  }
  .row > h2{
    color:#008080;
  }
  .login_form{
    background-color: #fff;
    border-top-right-radius:20px;
    border-bottom-right-radius:20px;
    border-top:1px solid #ccc;
    border-right:1px solid #ccc;
  }
  form{
    padding: 0 2em;
  }
  .form__input{
    width: 100%;
    border:0px solid transparent;
    border-radius: 0;
    border-bottom: 1px solid #aaa;
    padding: 1em .5em .5em;
    padding-left: 2em;
    outline:none;
    margin:1.5em auto;
    transition: all .5s ease;
  }
  .form__input:focus{
    border-bottom-color: #008080;
    box-shadow: 0 0 5px rgba(0,80,80,.4);
    border-radius: 4px;
  }
  .btn{
    transition: all .5s ease;
    width: 70%;
    border-radius: 30px;
    color:#008080;
    font-weight: 600;
    background-color: #fff;
    border: 1px solid #008080;
    margin-top: 1.5em;
    margin-bottom: 1em;
  }
  .btn:hover, .btn:focus{
    background-color: #008080;
    color:#fff;
  }
</style>
<body>
    <jsp:include page="partials/navbar.jsp" />
    <div class="container-fluid">
      <div class="row main-content bg-success text-center">
        <div class="col-md-4 text-center company__info">
          <span class="company__logo"><h2><span class="fa fa-android"></span></h2></span>
          <h4 class="company_title">Your Company Logo</h4>
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
              Powered By: &trade; by <a href="https://bit.ly/yinkaenoch">Audi/Colin/Javier.</a></p>
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
