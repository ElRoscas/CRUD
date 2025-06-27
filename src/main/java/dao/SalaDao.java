/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.crud.DBconnection;
import com.mycompany.model.Sala;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SalaDao {
    
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_reservas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public void afegirSala(Sala sala) {
    if (sala.getCapacitat() < 0) {
        throw new IllegalArgumentException("La capacidad no puede ser negativa.");
    }

    String sql = "INSERT INTO salas (nombre, capacidad, recursos) VALUES (?, ?, ?)";

    try (Connection conn = DBconnection.getConnection();
         PreparedStatement stmt = conn.prepareStatement(sql)) {

        stmt.setString(1, sala.getNom());
        stmt.setInt(2, sala.getCapacitat());
        stmt.setString(3, sala.getRecursos());

        stmt.executeUpdate();
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

    public List<Sala> llistarSales() {
        List<Sala> llista = new ArrayList<>();
        String sql = "SELECT * FROM salas";

        try (Connection conn = DBconnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Sala s = new Sala(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getInt("capacidad"),
                    rs.getString("recursos")
                );
                llista.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return llista;
    }

    public void actualitzarSala(Sala sala) {
        String sql = "UPDATE salas SET nombre=?, capacidad=?, recursos=? WHERE id=?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, sala.getNom());
            stmt.setInt(2, sala.getCapacitat());
            stmt.setString(3, sala.getRecursos());
            stmt.setInt(4, sala.getId());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void eliminarSala(int id) {
        String sql = "DELETE FROM salas WHERE id=?";

        try (Connection conn = DBconnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
