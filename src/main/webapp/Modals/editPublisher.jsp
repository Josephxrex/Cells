<div class="material">
    <div class="target-forms">
        <div>
            <h1>Edit Publisher</h1>
        </div>
        <div>
            <img src="assets/intitution.svg" alt="" />
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/ServletPublisher?accion=modificar&idPublisher=${publishers.publisher_ID}"  method="POST">
        <div class="content-formP">
            <div>
                <label>Name:</label><br />
                <input
                    class="inputForm"
                    required
                    type="text"
                    name="name"
                    value=${publishers.name}
                    /><br />
                <label>Address:</label><br />
                <input
                    class="inputForm"
                    required
                    type="text"
                    name="address"
                     value=${publishers.address}
                    /><br />
                <label>Phone Number:</label><br />
                <input
                    class="inputForm"
                    required
                    type="text"
                    name="phoneNumber"
                     value=${publishers.phoneNumber}
                    /><br />
                
            </div>
        </div>
        <div class="container-btnP">
            <button class="btn-primary" type="submit">Edit</button>
        </div>
    </form>
</div>