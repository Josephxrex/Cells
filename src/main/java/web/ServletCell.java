/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.CellDAO;
import entities.Cell;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Joseph
 */
@WebServlet("/ServletCell")
public class ServletCell extends HttpServlet {
    int contador=0;
   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                     this.editarCell(request, response);
                    break;
                case "listar":
                    this.accionDefault(request, response);
                  break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
           
        }
    } 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarCell(request, response);
                    break;
                case "eliminar":
                    this.eliminarCell(request, response);
                    break;
                 case "modificar":
                     this.modificarCell(request, response);
                    break;
                default:
                    this.accionDefault(request, response);
            }
        } else {
            this.accionDefault(request, response);
        }
    }
    
     private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        List<Cell> cells = new CellDAO().listar();
        System.out.println("cells = " + cells);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("cells", cells);
        response.sendRedirect("views/dashBoard.jsp");
        
    }
      private void eliminarCell(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos los valores del formulario editarCliente
        int idCell = Integer.parseInt(request.getParameter("idCell"));
     

        //Creamos el objeto de cliente (modelo)
         Cell cell = new Cell(idCell);

        //Eliminamos el  objeto en la base de datos
        int registrosModificados = new CellDAO().eliminar(cell);
        System.out.println("registrosModificados = " + registrosModificados);

        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
    }
    private void editarCell(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //recuperamos el idCliente
        int idCell = Integer.parseInt(request.getParameter("idCell"));
        Cell cell= new CellDAO().encontrar(new Cell(idCell));
        request.setAttribute("cell", cell);
        String jspEditar = "views/editCell.jsp";
        request.getRequestDispatcher("views/editCell.jsp").forward(request, response);
    }
    private void insertarCell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("namecell");
        String averageAge = request.getParameter("averageAge");
        String locality= request.getParameter("Locality");
        String image= request.getParameter("Image");
        
        int averageage = Integer. parseInt(averageAge);
        Cell cell = new Cell(name,averageage,locality,image);
        CellDAO celldao= new CellDAO();
        celldao.insertar(cell);
        System.out.println(cell+"Fue insertado");
        this.accionDefault(request, response);
    }

    private void modificarCell(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("idCell"));
        String name = request.getParameter("namecell");
        int  averageAge =Integer.parseInt(request.getParameter("averageAge"));
        String locality= request.getParameter("locality");
        String image= request.getParameter("image");
        Cell cell = new Cell(id,name,averageAge,locality,image);
        CellDAO celldao= new CellDAO();
        celldao.actualizar(cell);
        System.out.println(cell+"Fue Modificado");
        this.accionDefault(request, response);
       
        }
}
