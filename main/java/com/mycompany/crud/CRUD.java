/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.crud;

import dao.*;
import com.mycompany.model.*;

import Menu.Menu;
import java.sql.Date;
import java.sql.Time;
import java.util.Scanner;

public class CRUD {
    private static final Scanner lector = new Scanner(System.in);
    private static final SalaDao salaDAO = new SalaDao();
    private static final EmpleadoDao empleadoDAO = new EmpleadoDao();
    private static final ReservaDao reservaDAO = new ReservaDao();

    public static void main(String[] args) {
        boolean salir = false;
        while (!salir) {
            System.out.println("\n===== MENÚ PRINCIPAL =====");
            System.out.println("1. Gestionar salas");
            System.out.println("2. Gestionar empleados");
            System.out.println("3. Gestionar reservas");
            System.out.println("0. Salir");
            System.out.print("Opción: ");
            int op = lector.nextInt();
            lector.nextLine();

            switch (op) {
                case 1 -> menuSalas();
                case 2 -> menuEmpleados();
                case 3 -> menuReservas();
                case 0 -> salir = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }
    
    private static void menuSalas() {
        boolean atras = false;
        while (!atras) {
            System.out.println("\n-- GESTIÓN DE SALAS --");
            System.out.println("1. Añadir sala");
            System.out.println("2. Listar salas");
            System.out.println("3. Modificar sala");
            System.out.println("4. Eliminar sala");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            int op = lector.nextInt();
            lector.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = lector.nextLine();
                    System.out.print("Capacidad: ");
                    int capacidad = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Recursos: ");
                    String recursos = lector.nextLine();
                    salaDAO.afegirSala(new Sala(0, nombre, capacidad, recursos));
                }
                case 2 -> salaDAO.llistarSales().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID de sala a modificar: ");
                    int id = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombre = lector.nextLine();
                    System.out.print("Nueva capacidad: ");
                    int capacidad = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Nuevos recursos: ");
                    String recursos = lector.nextLine();
                    salaDAO.actualitzarSala(new Sala(id, nombre, capacidad, recursos));
                }
                case 4 -> {
                    System.out.print("ID de sala a eliminar: ");
                    int id = lector.nextInt();
                    lector.nextLine();
                    salaDAO.eliminarSala(id);
                }
                case 0 -> atras = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private static void menuEmpleados() {
        boolean atras = false;
        while (!atras) {
            System.out.println("\n-- GESTIÓN DE EMPLEADOS --");
            System.out.println("1. Añadir empleado");
            System.out.println("2. Listar empleados");
            System.out.println("3. Modificar empleado");
            System.out.println("4. Eliminar empleado");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            int op = lector.nextInt();
            lector.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = lector.nextLine();
                    System.out.print("Email: ");
                    String email = lector.nextLine();
                    System.out.print("Departamento: ");
                    String dep = lector.nextLine();
                    empleadoDAO.afegirEmpleado(new Empleat(0, nombre, email, dep));
                }
                case 2 -> empleadoDAO.llistarEmpleats().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID de empleado: ");
                    int id = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nombre = lector.nextLine();
                    System.out.print("Nuevo email: ");
                    String email = lector.nextLine();
                    System.out.print("Nuevo departamento: ");
                    String dep = lector.nextLine();
                    empleadoDAO.actualitzarEmpleado(new Empleat(id, nombre, email, dep));
                }
                case 4 -> {
                    System.out.print("ID a eliminar: ");
                    int id = lector.nextInt();
                    lector.nextLine();
                    empleadoDAO.eliminarEmpleado(id);
                }
                case 0 -> atras = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }

    private static void menuReservas() {
        boolean atras = false;
        while (!atras) {
            System.out.println("\n-- GESTIÓN DE RESERVAS --");
            System.out.println("1. Añadir reserva");
            System.out.println("2. Listar reservas");
            System.out.println("3. Eliminar reserva");
            System.out.println("0. Volver");
            System.out.print("Opción: ");
            int op = lector.nextInt();
            lector.nextLine();

            switch (op) {
                case 1 -> {
                    System.out.print("ID del empleado: ");
                    int idEmp = lector.nextInt();
                    System.out.print("ID de la sala: ");
                    int idSala = lector.nextInt();
                    lector.nextLine();
                    System.out.print("Fecha (YYYY-MM-DD): ");
                    Date fecha = Date.valueOf(lector.nextLine());
                    System.out.print("Hora de inicio (HH:MM:SS): ");
                    Time inicio = Time.valueOf(lector.nextLine());
                    System.out.print("Hora de fin (HH:MM:SS): ");
                    Time fin = Time.valueOf(lector.nextLine());

                    Reservas r = new Reservas(0, idEmp, idSala, fecha, inicio, fin);
                    reservaDAO.afegirReserva(r);
                }
                case 2 -> reservaDAO.llistarReserves().forEach(System.out::println);
                case 3 -> {
                    System.out.print("ID de la reserva a eliminar: ");
                    int id = lector.nextInt();
                    reservaDAO.eliminarReserva(id);
                }
                case 0 -> atras = true;
                default -> System.out.println("Opción inválida");
            }
        }
    }
}
