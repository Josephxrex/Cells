 <link rel="stylesheet" href="../style1_0.css" />
<dialog id="modalCell" class="cell-forms" >
      <div class="mod-cell">
        <h2>Add Cell</h2>
        <button id="closemodal"><img src="../assets/Exit.svg" alt=""></button>
      </div>
      <form action="${pageContext.request.contextPath}/ServletCell?accion=insertar" method="POST" method="dialog" >
        <div class="container-add">
        <div class="izq-cell">
          <label>Name cell:</label><br />
          <input
            class="inputForm"
            required
            type="text"
            name="namecell"
            placeholder=" Write the name of cell"
          /><br />
          <label>Average Age</label><br />
          <input
            class="inputForm"
            required
            type="number"
            name="averageAge"
            placeholder=" Write the average age"
          /><br />
          <label>Locality</label><br />
          <input
            class="inputForm"
            required
            type="text"
            name="Locality"
            placeholder=" Write the locality"
          /><br />
          <label>image</label><br />
          <input
            class="inputForm"
            required
            type="text"
            name="Image"
            placeholder=" Write url image"
          /><br />
        </div>
        <img class="image-cell" src="../assets/unispinosa_01.png" alt="" />
      </div>
      <button class="btn-primary-cell" type="submit">Add Cell</button>
      </form>
    </dialog>
    <script src="../index_1.js"></script>
