/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package web;

import datos.CellDAO;
import entities.Researcher;
import datos.ResearcherDAO;
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
@WebServlet("/ServletLogin")
public class ServletLogin extends HttpServlet {
      @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "insertar":
                    this.insertarResercher(request, response);
                    break;
                case "consultar":
                    this.ConsultResercher(request, response);
                    break;
                default:
                  this.accionDefault(request, response);
            }
        } else {
              this.accionDefault(request, response);
        }
    }
    private void ConsultResercher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        ResearcherDAO researcherdao = new ResearcherDAO();
        boolean result =researcherdao.ConsultarUser(username,password);
        if (result){
         this.accionSuccessfull(request, response);
        }else{
         this.accionDefault(request, response);
        }
    }

    
    
      private void insertarResercher(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        String lastname = request.getParameter("lastname");
        String password = request.getParameter("password");
        String dateofbirth = request.getParameter("dateofBirth");
        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String institution = request.getParameter("institution");


        Researcher researcher = new Researcher(username,name,lastname,email,password,institution);
       
        ResearcherDAO researcherdao = new ResearcherDAO();
        researcherdao.insertar(researcher);  
        System.out.println(researcher+"Fue insertado");
        this.accionSuccessfull(request, response);
      
    }
      private void accionSuccessfull (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.sendRedirect("views/dashBoard.jsp");
    }
       private void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
             response.sendRedirect("index.jsp");
    }
}
