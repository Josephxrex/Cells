/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entities.Publisher;
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
public class PublisherDAO {

    private static final String SQL_SELECT = "SELECT publisher_ID, name, address, phoneNumber "
            + " FROM publisher";

    private static final String SQL_SELECT_BY_ID = "SELECT publisher_ID, name, address, phoneNumber "
            + " FROM publisher WHERE publisher_ID = ?";

    private static final String SQL_INSERT = "INSERT INTO publisher(name, address, phoneNumber) "
            + " VALUES(?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE publisher "
            + " SET name=?, address=?, phoneNumber=? WHERE publisher_ID=?";

    private static final String SQL_DELETE = "DELETE FROM publisher WHERE publisher_ID = ?";

    public List<Publisher> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Publisher publisher = null;
        List<Publisher> publishers = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int publisher_ID = rs.getInt("publisher_ID");
                String name = rs.getString("name");
                String address = rs.getString("address");
                String phoneNumber = rs.getString("phoneNumber");
                publisher = new Publisher(publisher_ID, name, address, phoneNumber);
                publishers.add(publisher);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return publishers;
    }

    public Publisher encontrar(Publisher publisher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1, publisher.getPublisher_ID());
            rs = stmt.executeQuery();//nos posicionamos en el primer registro devuelto
            if (rs.next()) {
                do {
                    String name = rs.getString(2);
                    String phoneNumber = rs.getString(3);
                    String address = rs.getString(4);

                    publisher.setName(name);
                    publisher.setPhoneNumber(phoneNumber);
                    publisher.setAddress(address);
                } while (rs.next());
            }
            

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return publisher;
    }

    public int insertar(Publisher publisher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, publisher.getName());
            stmt.setString(2, publisher.getPhoneNumber());
            stmt.setString(3, publisher.getAddress());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Publisher publisher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, publisher.getName());
            stmt.setString(2, publisher.getPhoneNumber());
            stmt.setString(3, publisher.getAddress());
            stmt.setInt(4, publisher.getPublisher_ID());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Publisher publisher) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, publisher.getPublisher_ID());

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
