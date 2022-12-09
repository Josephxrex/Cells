/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entities.Researcher;
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
public class ResearcherDAO {
    private static final String SQL_SELECT = "SELECT researcher_ID, username, name, lastname, email, password, institution "
            + " FROM researcher";

    private static final String SQL_SELECT_BY_ID = "SELECT researcher_ID, username, name, lastname, email, password, institution "
            + " FROM researcher WHERE researcher_ID = ?";

    private static final String SQL_INSERT = "INSERT INTO researcher(username, name, lastname, email, password, institution) "
            + " VALUES(?, ?, ?, ?, ?,?)";

    private static final String SQL_UPDATE = "UPDATE researcher "
            + " SET username=?, name=?, lastname=?, email=?, password=?, institution=? WHERE researcher_ID=?";

    private static final String SQL_DELETE = "DELETE FROM researcher WHERE researcher_ID = ?";
    
     private static final String SQL_SELECTUSER = "SELECT researcher_ID FROM researcher WHERE username=? AND password =?";

    public List<Researcher> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Researcher researcher = null;
        List<Researcher> researchers = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int researcher_ID = rs.getInt("researcher_ID");
                String username = rs.getString("username");
                String name = rs.getString("name");
                String lastname = rs.getString("lastname");
                String email = rs.getString("email");
                String password = rs.getString("password");
                String institution = rs.getString("institution");
                researcher = new Researcher(researcher_ID,username,name,lastname,email,password,institution);
                researchers.add(researcher);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return researchers;
    }

    public Researcher encontrar(Researcher researcher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, researcher.getResearcher_ID());
            rs = stmt.executeQuery();
            rs.absolute(1);//nos posicionamos en el primer registro devuelto

            String name = rs.getString("name");
            String username = rs.getString("username");
            String email = rs.getString("email");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String institution = rs.getString("institution");

            researcher.setName(name);
            researcher.setUsername(username);
            researcher.setEmail(email);
            researcher.setLastname(lastname);
            researcher.setPassword(password);
            researcher.setInstitution(institution);

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return researcher;
    }

    public int insertar(Researcher researcher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, researcher.getName());
            stmt.setString(2, researcher.getUsername());
            stmt.setString(3, researcher.getEmail());
            stmt.setString(4, researcher.getLastname());
            stmt.setString(5, researcher.getPassword());
            stmt.setString(6, researcher.getInstitution());
            rows = stmt.executeUpdate();
            
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Researcher researcher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, researcher.getName());
            stmt.setString(2, researcher.getUsername());
            stmt.setString(3, researcher.getEmail());
            stmt.setString(4, researcher.getLastname());
            stmt.setString(5, researcher.getPassword());
            stmt.setString(6, researcher.getInstitution());
            stmt.setInt(7, researcher.getResearcher_ID());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Researcher researcher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, researcher.getResearcher_ID());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }
    
    public boolean ConsultarUser(String username,String password){
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rst = null;
        boolean cast= true;
        
         try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECTUSER);
            stmt.setString(1,username);
            stmt.setString(2,password);
            rst=stmt.executeQuery();
            if(rst.next()){
            cast=true;
            }else{
            cast=false;
            }
           
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cast;
    }
}
