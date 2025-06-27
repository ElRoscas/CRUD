/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.model;

/**
 *
 * @author Asus
 */
public class Empleat {
    private int id;
    private String nom;
    private String email;
    private String departament;

    public Empleat(int id, String nom, String email, String departament) {
        this.id = id;
        this.nom = nom;
        this.email = email;
        this.departament = departament;
    }
    
    public Empleat(String nom, String email, String departament) {
        this.nom = nom;
        this.email = email;
        this.departament = departament;
    }

    public Empleat() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartament() {
        return departament;
    }

    public void setDepartament(String departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "Empleado: " +
                " id: " + id +
                " | nom: " + nom +
                " | email: " + email + 
                " | departament: " + departament;
    }
}
