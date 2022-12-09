
package web;

import datos.PublisherDAO;
import entities.Publisher;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/ServletPublisher")
public class ServletPublisher extends HttpServlet {
    
     @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarPublisher(request, response);
                    break;
                case "modificar":
                  this.modificarPublisher(request, response);
                    break;
                case "listar":
                    this.accionDefault(request, response);
                    break;
                 case "eliminar":
                    this.eliminarPublisher(request, response);
                    break;
                default:
                  this.accionDefault(request, response);
            }
        } else {
              this.accionDefault(request, response);
        }
    }

     protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "listar":
                    this.accionDefault(request, response);
                    break;
                    case "editar":
                     this.editarPublisher(request, response);
                    break;
                default:
                  this.accionDefault(request, response);
            }
        } else {
              this.accionDefault(request, response);
        }
    }
    private void insertarPublisher(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
      
        Publisher publisher = new Publisher(name,address,phoneNumber);
        
        PublisherDAO publisherdao = new PublisherDAO();
        publisherdao.insertar(publisher);
        System.out.println(publisher+"Fue insertado");
       accionDefault(request, response);
    }
    private void eliminarPublisher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idPublisher = Integer.parseInt(request.getParameter("idPublisher"));
     

        //Creamos el objeto de cliente (modelo)
         Publisher publisher = new Publisher(idPublisher);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new PublisherDAO().eliminar(publisher);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }

    private void accionDefault(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Publisher> publishers= new PublisherDAO().listar();
        System.out.println("publishers= " + publishers);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("publishers",publishers);
        response.sendRedirect("views/institutionForm.jsp");
        }

    private void editarPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idPublisher = Integer.parseInt(request.getParameter("idPublisher"));
        Publisher publishers= new PublisherDAO().encontrar(new Publisher(idPublisher));
        request.setAttribute("publishers",publishers);
        String jspEditar = "views/updatePublisher.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    }
    private void modificarPublisher(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         int id= Integer.parseInt(request.getParameter("idPublisher"));
        String name = request.getParameter("name");
        String address = request.getParameter("address");
        String phoneNumber = request.getParameter("phoneNumber");
      
        Publisher publisher = new Publisher(id,name,address,phoneNumber);
        PublisherDAO publisherdao = new PublisherDAO();
        publisherdao.actualizar(publisher);
        System.out.println(publisher+"Fue insertado");
       accionDefault(request, response);
       
        }

    
}
