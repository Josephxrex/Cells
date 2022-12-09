<div class="material">
    <div class="target-forms">
        <div>
            <h1>Publisher</h1>
        </div>
        <div>
            <img src="../assets/intitution.svg" alt="" />
        </div>
    </div>
    <form action="${pageContext.request.contextPath}/ServletPublisher?accion=insertar" method="POST">
        <div class="content-formP">
            <div>
                <label>Name:</label><br />
                <input
                    class="inputForm"
                    required
                    type="text"
                    name="name"
                    placeholder=" Write the name of the publisher"
                    /><br />
                <label>Address:</label><br />
                <input
                    class="inputForm"
                    required
                    type="text"
                    name="address"
                      placeholder=" Write the address"
                    /><br />
                <label>Phone Number:</label><br />
                <input
                    class="inputForm"
                    required
                    type="text"
                    name="phoneNumber"
                    placeholder=" Write the phone number"
                    /><br />
                
            </div>
        </div>
        <div class="container-btnP">
            <button class="btn-primary" type="submit">ADD</button>
        </div>
    </form>
</div>