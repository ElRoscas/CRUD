/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Menu;

import dao.SalaDao;
import Model.Sala;

import java.util.List;
import java.util.Scanner;

public class MenuClass {
    private static final SalaDao dao = new SalaDao();
    private static final Scanner lector = new Scanner(System.in);

    public static void mostrarMenu() {
        int opcion;
        do {
            System.out.println("\n--- Gestión de Salas ---");
            System.out.println("1. Añadir sala");
            System.out.println("2. Listar salas");
            System.out.println("3. Modificar sala");
            System.out.println("4. Eliminar sala");
            System.out.println("0. Volver al menú principal");
            System.out.print("Selecciona una opción: ");
            opcion = lector.nextInt();
            lector.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1 -> añadirSala();
                case 2 -> listarSalas();
                case 3 -> modificarSala();
                case 4 -> eliminarSala();
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida.");
            }
        } while (opcion != 0);
    }

    private static void añadirSala() {
        System.out.print("Nombre de la sala: ");
        String nombre = lector.nextLine();
        System.out.print("Capacidad: ");
        int capacidad = lector.nextInt();
        lector.nextLine();
        System.out.print("Recursos disponibles: ");
        String recursos = lector.nextLine();

        Sala sala = new Sala(0, nombre, capacidad, recursos);
        dao.afegirSala(sala);
        System.out.println("Sala añadida correctamente.");
    }

    private static void listarSalas() {
        List<Sala> salas = dao.llistarSales();
        if (salas.isEmpty()) {
            System.out.println("No hay salas registradas.");
        } else {
            for (Sala s : salas) {
                System.out.println(s);
            }
        }
    }

    private static void modificarSala() {
        System.out.print("ID de la sala a modificar: ");
        int id = lector.nextInt();
        lector.nextLine();

        System.out.print("Nuevo nombre: ");
        String nombre = lector.nextLine();
        System.out.print("Nueva capacidad: ");
        int capacidad = lector.nextInt();
        lector.nextLine();
        System.out.print("Nuevos recursos: ");
        String recursos = lector.nextLine();

        Sala sala = new Sala(id, nombre, capacidad, recursos);
        dao.actualitzarSala(sala);
        System.out.println("Sala modificada correctamente.");
    }

    private static void eliminarSala() {
        System.out.print("ID de la sala a eliminar: ");
        int id = lector.nextInt();
        dao.eliminarSala(id);
        System.out.println("Sala eliminada correctamente.");
    }
}

