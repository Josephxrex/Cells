<%-- 
    Document   : dashBoard
    Created on : 22 nov. 2022, 20:09:34
    Author     : Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <title>Dashboard</title>
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
        
        <section class="homeDash">
            <div class="containerDash">
                <!--Navbar-->
                <jsp:include page="../Components/navbar.jsp"/>
                <!--List of Cells-->
                <jsp:include page="../Components/cellsMaterial.jsp"/>
               <!--MoreInformation-->
               <jsp:include page="../Components/moreInformation.jsp"/>
            </div>
        </section>
               <jsp:include page="../Modals/AddCell.jsp"/>
    </body>
</html>



