/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import Model.Reservas;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.sql.Time;

import static org.junit.jupiter.api.Assertions.*;

public class ReservaDaoTest {

    @Test
    public void testCrearReserva() {
        Reservas r = new Reservas(1, 2, 3, Date.valueOf("2025-06-25"), Time.valueOf("10:00:00"), Time.valueOf("11:00:00"));
        assertEquals(1, r.getId());
        assertEquals(2, r.getIdEmpleado());
        assertEquals(3, r.getIdSala());
        assertEquals(Date.valueOf("2025-06-25"), r.getFecha());
        assertEquals(Time.valueOf("10:00:00"), r.getHoraInicio());
        assertEquals(Time.valueOf("11:00:00"), r.getHoraFin());
    }

    @Test
    public void testSetters() {
        Reservas r = new Reservas(0, 0, 0, null, null, null);
        r.setId(10);
        r.setIdEmpleado(20);
        r.setIdSala(30);
        r.setFecha(Date.valueOf("2025-06-30"));
        r.setHoraInicio(Time.valueOf("09:00:00"));
        r.setHoraFin(Time.valueOf("10:30:00"));

        assertEquals(10, r.getId());
        assertEquals(20, r.getIdEmpleado());
        assertEquals(30, r.getIdSala());
        assertEquals(Date.valueOf("2025-06-30"), r.getFecha());
        assertEquals(Time.valueOf("09:00:00"), r.getHoraInicio());
        assertEquals(Time.valueOf("10:30:00"), r.getHoraFin());
    }

    @Test
    public void testToString() {
        Reservas r = new Reservas(5, 1, 2, Date.valueOf("2025-07-01"), Time.valueOf("14:00:00"), Time.valueOf("15:00:00"));
        String esperado = "Reserva ID 5: empleado:1 | sala:2 | fecha: 2025-07-01 | de 14:00:00 a 15:00:00";
        assertEquals(esperado, r.toString());
    }

    @Test
    public void testHorasInvalidas() {
        Time horaInicio = Time.valueOf("16:00:00");
        Time horaFin = Time.valueOf("15:00:00");
        assertTrue(horaInicio.after(horaFin));
    }

    @Test
    public void testFechaNoNula() {
        Reservas r = new Reservas(6, 1, 1, Date.valueOf("2025-08-01"), Time.valueOf("08:00:00"), Time.valueOf("09:00:00"));
        assertNotNull(r.getFecha());
    }
}


