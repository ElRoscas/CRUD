/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.model.Empleat;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_reservas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public void afegirEmpleado(Empleat e) {
        String sql = "INSERT INTO empleados (nombre, email, departamento) VALUES (?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getEmail());
            stmt.setString(3, e.getDepartament());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public List<Empleat> llistarEmpleats() {
        List<Empleat> llista = new ArrayList<>();
        String sql = "SELECT * FROM empleados";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Empleat e = new Empleat(
                        rs.getInt("id"),
                        rs.getString("nombre"),
                        rs.getString("email"),
                        rs.getString("departamento")
                );
                llista.add(e);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return llista;
    }

    public void actualitzarEmpleado(Empleat e) {
        String sql = "UPDATE empleados SET nombre = ?, email = ?, departamento = ? WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setString(1, e.getNom());
            stmt.setString(2, e.getEmail());
            stmt.setString(3, e.getDepartament());
            stmt.setInt(4, e.getId());
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    public void eliminarEmpleado(int id) {
        String sql = "DELETE FROM empleados WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}

