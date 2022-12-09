<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<aside class="more-article">
   <c:forEach var="publishers" items="${publishers}" varStatus="status" >
    <form class="generic-target" action="${pageContext.request.contextPath}/ServletPublisher?accion=eliminar" method="POST">
        <div class="title-buttons">
             <button><img src="../assets/delete.svg" alt="" /></button>
            <h1>${publishers.name}</h1>
            </div>
            <p>
                Address:${publishers.address}<br>
                Phone Number:${publishers.phoneNumber}<br>
                <a href="${pageContext.request.contextPath}/ServletPublisher?accion=editar&idPublisher=${publishers.publisher_ID}">Editar</a>
                
            </p>
        <input type="text" name="idPublisher" value=${publishers.publisher_ID} readonly >
    </form>
    </c:forEach>
</aside>