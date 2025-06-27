/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import dao.SalaDao;
import com.mycompany.model.Sala;
import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SalaDaoTest {

    private static SalaDao salaDao;
    private static int salaAfegidaId;

    @BeforeAll
    static void setup() {
        salaDao = new SalaDao();
    }

    @Test
    @Order(1)
    void testAfegirSala() {
        Sala novaSala = new Sala(0, "Sala Test", 15, "Proyector, TV");
        salaDao.afegirSala(novaSala);

        List<Sala> sales = salaDao.llistarSales();
        Sala ultima = sales.get(sales.size() - 1);

        assertEquals("Sala Test", ultima.getNom());
        salaAfegidaId = ultima.getId();
    }

    @Test
    @Order(2)
    void testLlistarSales() {
        List<Sala> sales = salaDao.llistarSales();
        assertNotNull(sales);
        assertTrue(sales.size() > 0);
    }

    @Test @Order(3)
void testActualitzarSala() {
    SalaDao dao = new SalaDao();

    Sala s = new Sala(0, "Temporal", 5, "Proyector");
    dao.afegirSala(s);

    List<Sala> llista = dao.llistarSales();
    Sala salaAfegida = llista.stream()
        .filter(sa -> sa.getNom().equals("Temporal"))
        .reduce((first, second) -> second) 
        .orElse(null);

    assertNotNull(salaAfegida);

    salaAfegida.setNom("Actualizada");
    salaAfegida.setCapacitat(8);
    salaAfegida.setRecursos("Pizarra, Televisor");
    dao.actualitzarSala(salaAfegida);
    
    List<Sala> actualitzada = dao.llistarSales();
    Sala sFinal = actualitzada.stream()
        .filter(sa -> sa.getId() == salaAfegida.getId())
        .findFirst()
        .orElse(null);

    assertNotNull(sFinal);
    assertEquals("Actualizada", sFinal.getNom());
    assertEquals(8, sFinal.getCapacitat());
    assertEquals("Pizarra, Televisor", sFinal.getRecursos());
}


    @Test
    @Order(4)
    void testEliminarSala() {
        salaDao.eliminarSala(salaAfegidaId);

        List<Sala> sales = salaDao.llistarSales();
        boolean existeix = sales.stream()
                .anyMatch(s -> s.getId() == salaAfegidaId);

        assertFalse(existeix);
    }

    @Test
    void testAfegirSalaCapacitatNegativa() {
        Sala salaInvalida = new Sala(0, "Sala Error", -5, "Ninguno");

        assertThrows(Exception.class, () -> {
            salaDao.afegirSala(salaInvalida);
        });
    }
}

