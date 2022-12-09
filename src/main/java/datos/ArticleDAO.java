package datos;

import datos.Conexion;
import entities.Article;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author yukit
 */
public class ArticleDAO {

    private static final String SQL_SELECT = "SELECT article_ID, name, publicationDate, description, image, url "
            + " FROM article";

    private static final String SQL_SELECT_BY_ID = "SELECT article_ID, name, publicationDate, description, image, url "
            + " FROM article WHERE article_ID = ?";

    private static final String SQL_INSERT = "INSERT INTO article(name, publicationDate, description, image, url) "
            + " VALUES(?, ?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE article "
            + " SET name=?, publicationDate=?, description=?, image=?, url=? WHERE article_ID=?";

    private static final String SQL_DELETE = "DELETE FROM article WHERE article_ID = ?";

    public ArticleDAO() {
    }

    public List<Article> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Article article = null;
        List<Article> articles = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int article_ID = rs.getInt("article_ID");
                String publicationDate = rs.getString("name");
                String name = rs.getString("publicationDate");
                String description = rs.getString("description");
                String image = rs.getString("image");
                String url = rs.getString("url");
                article = new Article(article_ID, publicationDate, name, description, image, url);
                articles.add(article);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return articles;
    }

    public Article encontrar(Article article) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, article.getArticle_ID());
            rs = stmt.executeQuery();//nos posicionamos en el primer registro devuelto
            if (rs.next()) {
                do {
                    String name = rs.getString(2);
                    String publicationDate = rs.getString(3);
                    String description = rs.getString(4);
                    String image = rs.getString(5);
                    String url = rs.getString(6);

                    article.setName(name);
                    article.setPublicationDate(publicationDate);
                    article.setImage(image);
                    article.setDescription(description);
                    article.setUrl(url);

                } while (rs.next());

            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return article;
    }

    public int insertar(Article article) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, article.getName());
            stmt.setString(2, article.getPublicationDate());
            stmt.setString(3, article.getImage());
            stmt.setString(4, article.getDescription());
            stmt.setString(5, article.getUrl());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Article article) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, article.getName());
            stmt.setString(2, article.getPublicationDate());
            stmt.setString(3, article.getImage());
            stmt.setString(4, article.getDescription());
            stmt.setString(5, article.getUrl());
            stmt.setInt(6, article.getArticle_ID());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Article article) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, article.getArticle_ID());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
}
