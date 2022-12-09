/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package datos;

import entities.Cell;
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
public class CellDAO {

    private static final String SQL_SELECT = "SELECT featured_cell_ID, name, average_age, locality, image "
            + " FROM featured_cell";

    private static final String SQL_SELECT_BY_ID = "SELECT featured_cell_ID, name, average_age, locality, image "
            + " FROM featured_cell WHERE featured_cell_ID = ?";

    private static final String SQL_INSERT = "INSERT INTO featured_cell(name, average_age, locality, image) "
            + " VALUES(?, ?, ?, ?)";

    private static final String SQL_UPDATE = "UPDATE featured_cell "
            + " SET name=?, average_age=?, locality=?, image=? WHERE featured_cell_ID=?";

    private static final String SQL_DELETE = "DELETE FROM featured_cell WHERE featured_cell_ID = ?";

    public List<Cell> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Cell cell = null;
        List<Cell> cells = new ArrayList<>();
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT);
            rs = stmt.executeQuery();
            while (rs.next()) {
                int featured_cell_ID = rs.getInt("featured_cell_ID");
                String name = rs.getString("name");
                int average_age = rs.getInt("average_age");
                String locality = rs.getString("locality");
                String image = rs.getString("image");
                cell = new Cell(featured_cell_ID, name, average_age, locality, image);
                cells.add(cell);
            }
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cells;
    }

    public Cell encontrar(Cell cell) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_SELECT_BY_ID);
            stmt.setInt(1,cell.getFeatured_cell_ID());
            rs = stmt.executeQuery();//nos posicionamos en el primer registro devuelto
            if (rs.next()) {           
                //se valida si hay resultados
                do {
                    String name = rs.getString(2);
                    int average_age = rs.getInt(3);
                    String locality = rs.getString(4);
                    String image = rs.getString(5);
                    cell.setName(name);
                    cell.setAverage_age(average_age);
                    cell.setLocality(locality);
                    cell.setImage(image);
                } while (rs.next()); //repita mientras existan más datos
            }
        
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(rs);
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return cell;
    }

    public int insertar(Cell cell) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_INSERT);
            stmt.setString(1, cell.getName());
            stmt.setInt(2, cell.getAverage_age());
            stmt.setString(3, cell.getLocality());
            stmt.setString(4, cell.getImage());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int actualizar(Cell cell) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_UPDATE);
            stmt.setString(1, cell.getName());
            stmt.setInt(2, cell.getAverage_age());
            stmt.setString(3, cell.getLocality());
            stmt.setString(4, cell.getImage());
            stmt.setInt(5, cell.getFeatured_cell_ID());

            rows = stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(stmt);
            Conexion.close(conn);
        }
        return rows;
    }

    public int eliminar(Cell cell) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int rows = 0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SQL_DELETE);
            stmt.setInt(1, cell.getFeatured_cell_ID());

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
