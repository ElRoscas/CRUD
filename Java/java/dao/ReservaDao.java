/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import com.mycompany.model.Reservas;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ReservaDao {
    private static final String URL = "jdbc:mysql://localhost:3306/sistema_reservas";
    private static final String USUARIO = "root";
    private static final String CONTRASENA = "";

    public void afegirReserva(Reservas r) {
        if (existeConflicte(r)) {
            System.out.println("❌ Ya existe una reserva en ese horario para la sala.");
            return;
        }

        String sql = "INSERT INTO reservas (id_empleado, id_sala, fecha, hora_inicio, hora_fin) VALUES (?, ?, ?, ?, ?)";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, r.getIdEmpleado());
            stmt.setInt(2, r.getIdSala());
            stmt.setDate(3, r.getFecha());
            stmt.setTime(4, r.getHoraInicio());
            stmt.setTime(5, r.getHoraFin());
            stmt.executeUpdate();
            System.out.println("✅ Reserva creada con éxito.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Reservas> llistarReserves() {
        List<Reservas> llista = new ArrayList<>();
        String sql = "SELECT * FROM reservas";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             Statement stmt = con.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            while (rs.next()) {
                Reservas r = new Reservas(
                        rs.getInt("id"),
                        rs.getInt("id_empleado"),
                        rs.getInt("id_sala"),
                        rs.getDate("fecha"),
                        rs.getTime("hora_inicio"),
                        rs.getTime("hora_fin")
                );
                llista.add(r);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return llista;
    }

    private boolean existeConflicte(Reservas r) {
        String sql = """
                SELECT COUNT(*) FROM reservas
                WHERE id_sala = ? AND fecha = ? AND (
                      (hora_inicio < ? AND hora_fin > ?) OR
                      (hora_inicio >= ? AND hora_inicio < ?)
                )""";

        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, r.getIdSala());
            stmt.setDate(2, r.getFecha());
            stmt.setTime(3, r.getHoraFin());
            stmt.setTime(4, r.getHoraInicio());
            stmt.setTime(5, r.getHoraInicio());
            stmt.setTime(6, r.getHoraFin());

            try (ResultSet rs = stmt.executeQuery()) {
                rs.next();
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return true;
        }
    }

    public void eliminarReserva(int id) {
        String sql = "DELETE FROM reservas WHERE id = ?";
        try (Connection con = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
             PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
            System.out.println("✅ Reserva eliminada.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
