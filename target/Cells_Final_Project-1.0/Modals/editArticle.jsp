<div class="material">
    <div class="target-forms">

        <div>
            <h1>Edit Article</h1>
        </div>
        <div>
            <img
                src="assets/article.svg"
                alt=""
                />
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/ServletArticle?accion=modificar&idArticle=${article.article_ID}"  method="POST" >
        <div class="content-formA">
            <div class="leftF">
                <label for="name">Name:</label><br>
                <input  class="inputForm" required type="text" name="name" value=${article.name}>
                <label for="name">Publication Date:</label><br>
                <input  class="inputForm" required type="date" name="date" value=${article.publicationDate}>
                <label for="name">Description:</label><br>
                <textarea name="comentarios" cols="30" rows="2"
                          class="default">
                  ${article.description}
                </textarea>
            </div>
            <div class="rigthF">
                <label for="name">Image:</label><br>
                <input  class="inputForm" required type="text" name="image" value=${article.image} >
                <label for="name">url:</label><br>
                <input  class="inputForm" required type="text" name="url" value=${article.url} >


            </div>
        </div>
        <div class="container-btnA">
            <button class="btn-primary" type="submit">Edit</button>
        </div>
    </form>
</div>