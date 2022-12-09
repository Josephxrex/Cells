<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<div class="material">
    <div class="target-Welcome">
        <div>
            <h1>Welcome Pogy</h1>
            <h3>It?s good to see you again.</h3>
        </div>
        <div>
            <img src="../assets/welcome.svg" alt="" />
        </div>
    </div>
    <div class="cells-presentation">
        <h1>Your Cells</h1>
        <h3>All your cells</h3>

        <div class="cells-container">
            <c:forEach var="cells" items="${cells}" varStatus="status" >
             
                <form class="cell-target" action="${pageContext.request.contextPath}/ServletCell?accion=eliminar" method="POST" >
                    <img src="${cells.image}" alt="" />
                    <div class="content-cell">
                        <h2>${cells.name}</h2>
                        <p>
                            Average Age: ${cells.average_age}<br>
                            Locality: ${cells.locality}<br>
                        </p>
                          <input type="text" name="idCell" value="${cells.featured_cell_ID}" readonly>
                           <a href="${pageContext.request.contextPath}/ServletCell?accion=editar&idCell=${cells.featured_cell_ID}">Editar</a>
                    </div>
                     <button class="btn-crud" style="padding-right: 1.5rem;"><img src="../assets/delete.svg" alt=""></button>
                </form>
                   
              </c:forEach>
            
        </div>
    </div>
</div>