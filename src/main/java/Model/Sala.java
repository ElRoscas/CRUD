/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Asus
 */
public class Sala {
    private int id;
    private String nombre;
    private int capacidad;
    private String recursos;

    public Sala(int id, String nom, int capacitat, String recursos) {
        this.id = id;
        this.nombre = nom;
        this.capacidad = capacitat;
        this.recursos = recursos;
    }

    public Sala() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nombre;
    }

    public void setNom(String nom) {
        this.nombre = nom;
    }

    public int getCapacitat() {
        return capacidad;
    }

    public void setCapacitat(int capacitat) {
        this.capacidad = capacitat;
    }

    public String getRecursos() {
        return recursos;
    }

    public void setRecursos(String recursos) {
        this.recursos = recursos;
    }

    @Override
    public String toString() {
        return "Sala: " +
                " id: " + id +
                " | nombre:'" + nombre +
                " | capacidad: " + capacidad +
                " | recursos=: " + recursos;
    }
}
