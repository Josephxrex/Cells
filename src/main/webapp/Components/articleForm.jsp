<div class="material">
    <div class="target-forms">

        <div>
            <h1>Article</h1>
        </div>
        <div>
            <img
                src="../assets/article.svg"
                alt=""
                />
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/ServletArticle?accion=insertar" method="POST" >
        <div class="content-formA">
            <div class="leftF">
                <label for="name">Name:</label><br>
                <input  class="inputForm" required type="text" name="name" placeholder=" Write the name of article">
                <label for="name">Publication Date:</label><br>
                <input  class="inputForm" required type="date" name="date" >
                <label for="name">Description:</label><br>
                <textarea name="comentarios" cols="30" rows="2"
                          class="default" onfocus="this.select()">
                    Write a description
                </textarea>
            </div>
            <div class="rigthF">
                <label for="name">Image:</label><br>
                <input  class="inputForm" required type="text" name="image" placeholder=" Write the url of the image">
                <label for="name">url:</label><br>
                <input  class="inputForm" required type="text" name="url" placeholder=" Write the url of the article">


            </div>
        </div>
        <div class="container-btnA">
            <button class="btn-primary" type="submit">ADD</button>
        </div>
    </form>
</div>