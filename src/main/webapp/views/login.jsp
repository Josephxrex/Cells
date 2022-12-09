<%-- 
    Document   : login
    Created on : 22 nov. 2022, 20:10:00
    Author     : Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Login</title>
    <meta name="description" content="" />
    <meta name="viewport" content="width=device-width, initial-scale=1" />
    <link rel="stylesheet" href="../style2_0.css" />
    <link
      rel="shortcut icon"
      href="../assets/microscope.ico"
      type="image/x-icon"
    />
  </head>
  <body>
    <section class="homeForm">
      <div class="navbar">
        <img src="../assets/microscopeFill.svg" class="imageIco" />
      </div>
      <div class="center">
        <div class="contentForm">
          <h1>
            Login to Your <br />
            Account
          </h1>
          <form action="${pageContext.request.contextPath}/ServletLogin?accion=consultar" method="POST"class="formsL">
            <label for="user">User:</label><br />
            <input required type="text" name="username" placeholder="Write your user" /><br />
            <label for="password">Password:</label><br />
            <input required type="password" name="password" placeholder=" Write your password" /><br />
            <div class="container-btn">
              <button class="btn-primary" type="submit">Log in</button>
              <button class="btn-secondary" type="submit">Sign up</button>
            </div>
          </form>
          <div class="login-with">
            <label for="">Login using social networks</label><br />
            <img src="../assets/facebook.svg" class="imgNet" />
            <img src="../assets/insta.svg" class="imgNet" />
          </div>
        </div>
      </div>
    </section>
  </body>
</html>