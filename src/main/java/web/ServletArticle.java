
package web;

import datos.ArticleDAO;
import entities.Article;
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
@WebServlet("/ServletArticle")
public class ServletArticle  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion = request.getParameter("accion");
        if (accion != null) {
            switch (accion) {
                case "editar":
                     this.editarArticle(request, response);
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
                    this.insertarArticle(request, response);
                    break;
                case "eliminar":
                    this.eliminarArticle(request, response);
                    break;
                   case "modificar":
                    this.modificarArticle(request, response);
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
       
        List<Article> articles = new ArticleDAO().listar();
        System.out.println("articles= " + articles);
        HttpSession sesion = request.getSession();
        sesion.setAttribute("articles", articles);
        response.sendRedirect("views/articleForm.jsp");
        
    }

    private void insertarArticle(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException  {
      
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String comentarios= request.getParameter("comentarios");
        String image= request.getParameter("image");
        String url= request.getParameter("url");
        
        Article  article = new Article(name,date,comentarios,image,url);
        ArticleDAO articledao1= new ArticleDAO();
        articledao1.insertar(article);
        System.out.println(article+"Fue insertado");
        this.accionDefault(request, response);
    }

    private void eliminarArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
         int idArticle = Integer.parseInt(request.getParameter("idArticle"));
         Article article = new Article(idArticle);
         int registrosModificados = new ArticleDAO().eliminar(article);
        System.out.println("registrosModificados = " + registrosModificados);
        //Redirigimos hacia accion por default
        this.accionDefault(request, response);
         
     
    }

    private void editarArticle(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
       
        int idArticle = Integer.parseInt(request.getParameter("idArticle"));
        Article article= new ArticleDAO().encontrar(new Article(idArticle));
        request.setAttribute("article", article);
        String jspEditar = "views/updateArticle.jsp";
        request.getRequestDispatcher(jspEditar).forward(request, response);
    
    }

    private void modificarArticle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id= Integer.parseInt(request.getParameter("idArticle"));
        String name = request.getParameter("name");
        String date = request.getParameter("date");
        String comentarios= request.getParameter("comentarios");
        String image= request.getParameter("image");
        String url= request.getParameter("url");
        
        Article  article = new Article(id,name,date,comentarios,image,url);
        ArticleDAO articledao1= new ArticleDAO();
        articledao1.actualizar(article);
        System.out.println(article+"Fue insertado");
        this.accionDefault(request, response);
       }
}
