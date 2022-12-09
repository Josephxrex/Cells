<%-- 
    Document   : signUp
    Created on : 22 nov. 2022, 20:10:39
    Author     : Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <title>Sign Up</title>
        <meta name="description" content="">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="../style2_0.css">
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
            <div class="contentSinUp">
                <h1>Sign up</h1>
                <form action="${pageContext.request.contextPath}/ServletLogin?accion=insertar" method="POST" class="formsS">
                <div class="content-form">
                    <div class="left">
                    <label for="name">Name:</label><br/>
                    <input required type="text" name="name" placeholder=" Write your name"><br>
                    <label for="lastName">Lastname:</label><br/>
                    <input required type="text" name="lastname" placeholder=" Write your lastname"><br>
                    <label for="password">Password:</label><br/>
                    <input required type="password" name="password" placeholder=" Write your password"><br>
                    <label for="dateofbirth">Date of Birth:</label><br/>
                    <input required type="date" name="dateofBirth" ><br>
                </div>
                <div class="rigth">
                    <label for="username">Username:</label><br/>
                    <input required type="text" name="username" placeholder=" Write your username"><br>
                    <label for="email">E-mail</label><br/>
                    <input required type="text" name="email" placeholder=" Write your email"><br>
                    <label for="Institution">Institution</label><br/>
                    <select name="institution" class="">
                        <option>UNAM</option>
                        <option>IPN</option>
                        <option>SALLE</option>
                        <option>PUEBLA</option>
                    </select>
                </div>
            </div>
            <div class="container-buttonSU">
                <button class="btn-secondary" type="submit">Sign up</button>
            </div>
                </form>
            </div>
        </div>
        </section>
    </body>
</html>
