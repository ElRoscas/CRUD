/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dao.EmpleadoDao;
import com.mycompany.model.Empleat;
import org.junit.jupiter.api.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class EmpleadoDaoTest {

    static EmpleadoDao dao = new EmpleadoDao();
    static int idEmpleado;

    @Test
    @Order(1)
    public void testAfegirEmpleado() {
        Empleat e = new Empleat("Test Empleado", "test@empresa.com", "Testing");
        dao.afegirEmpleado(e);
        List<Empleat> empleat = dao.llistarEmpleats();
        Empleat ultimo = empleat.get(empleat.size() - 1);
        idEmpleado = ultimo.getId();

        assertEquals("Test Empleado", ultimo.getNom());
    }

    @Test
    @Order(2)
    public void testLlistarEmpleados() {
        List<Empleat> empleados = dao.llistarEmpleats();
        assertTrue(empleados.size() > 0);
    }

    @Test
    @Order(3)
    public void testActualitzarEmpleado() {
        Empleat e = new Empleat(idEmpleado, "Modificado", "mod@empresa.com", "IT");
        dao.actualitzarEmpleado(e);

        List<Empleat> empleados = dao.llistarEmpleats();
        Empleat mod = empleados.stream().filter(emp -> emp.getId() == idEmpleado).findFirst().orElse(null);

        assertNotNull(mod);
        assertEquals("Modificado", mod.getNom());
    }

    @Test
    @Order(4)
    public void testEliminarEmpleado() {
        dao.eliminarEmpleado(idEmpleado);
        List<Empleat> empleados = dao.llistarEmpleats();

        boolean existe = empleados.stream().anyMatch(emp -> emp.getId() == idEmpleado);
        assertFalse(existe);
    }
}

