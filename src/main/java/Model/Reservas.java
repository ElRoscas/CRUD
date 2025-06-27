/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

import java.sql.Time;
import java.sql.Date;

public class Reservas {
    private int id;
    private int idEmpleado;
    private int idSala;
    private Date fecha;
    private Time horaInicio;
    private Time horaFin;

    public Reservas(int id, int idEmpleado, int idSala, Date fecha, Time horaInicio, Time horaFin) {
        this.id = id;
        this.idEmpleado = idEmpleado;
        this.idSala = idSala;
        this.fecha = fecha;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
    }

    public int getId() { return id; }
    public int getIdEmpleado() { return idEmpleado; }
    public int getIdSala() { return idSala; }
    public Date getFecha() { return fecha; }
    public Time getHoraInicio() { return horaInicio; }
    public Time getHoraFin() { return horaFin; }

    public void setId(int id) { this.id = id; }
    public void setIdEmpleado(int idEmpleado) { this.idEmpleado = idEmpleado; }
    public void setIdSala(int idSala) { this.idSala = idSala; }
    public void setFecha(Date fecha) { this.fecha = fecha; }
    public void setHoraInicio(Time horaInicio) { this.horaInicio = horaInicio; }
    public void setHoraFin(Time horaFin) { this.horaFin = horaFin; }

    @Override
    public String toString() {
        return "Reserva ID " + id + ": empleado:" + idEmpleado + " | sala:" + idSala +
                " | fecha: " + fecha + " | de " + horaInicio + " a " + horaFin;
    }
}

