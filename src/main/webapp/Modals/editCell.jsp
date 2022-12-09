
<div class="material">
    <div class="target-forms">

        <div>
            <h1>Edit Cell</h1>
        </div>
        <div>
            <img
                src="assets/article.svg"
                alt=""
                />
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/ServletCell?accion=modificar&idCliente=${cliente.idCliente}"  method="POST" class="was-validated" >
        <div class="content-formA">
            <div class="leftF">
                <label for="name">ID:</label><br>
                <input  class="inputID" required type="number" name="idCell" value=${cell.featured_cell_ID}><br>
                <label for="name">Name:</label><br>
                <input  class="inputForm" required type="text" name="namecell" value="${cell.name}"><br>
                <label for="name">Average Age</label><br>
                <input  class="inputForm" required type="number" name="averageAge" value=${cell.average_age}><br>
                <label for="name">Locality </label><br>
                <input  class="inputForm" required type="text" name="locality" value="${cell.locality}"><br>
                <label for="name">Image</label><br>
                <input  class="inputForm" required type="text" name="image" value="${cell.image}"><br>
            </div>
            <div class="rigthF">
                <img class="img-cell"src="${cell.image}"alt="">
            </div>
        </div>
        <div class="container-btnA">
            <button class="btn-primary" type="submit">Edit</button>
        </div>
    </form>
</div>