<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="es_MX"/>
<aside class="more-article">
   <c:forEach var="articles" items="${articles}" varStatus="status" >
    <form class="generic-target" action="${pageContext.request.contextPath}/ServletArticle?accion=eliminar" method="POST">
        <div class="title-buttons">
             <button><img src="../assets/delete.svg" alt="" /></button>
            <h1>${articles.name}</h1>
            </div>
            <p>
                Publication Date:${articles.publicationDate}
                <a style="margin-left: 3rem" href="${pageContext.request.contextPath}/ServletArticle?accion=editar&idArticle=${articles.article_ID}">Editar</a>
            </p>
                
        <input type="text" name="idArticle" value=${articles.article_ID} readonly >
    </form>
    </c:forEach>
</aside>