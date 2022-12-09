<%-- 
    Document   : institutionForm
    Created on : 22 nov. 2022, 20:09:47
    Author     : Joseph
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Institution Form</title>
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
          <jsp:include page="../Components/navbar.jsp"/>
          <jsp:include page="../Components/publisherForm.jsp"/>
          <jsp:include page="../Components/listPublisher.jsp"/>
      </div>
    </section>
  </body>
</html>

