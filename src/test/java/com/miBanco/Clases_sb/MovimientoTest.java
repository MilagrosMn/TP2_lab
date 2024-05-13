package com.miBanco.Clases_sb;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class MovimientoTest {

    private Movimiento movimiento;

    @BeforeEach
    void setUp() {
        movimiento = new Movimiento();
    }

    @Test
    @DisplayName("Establecer y obtener fecha y hora exitosamente")
    void testSetGetFechaHora() {
        LocalDateTime fechaHora = LocalDateTime.now();
        movimiento.setFechaHora(fechaHora);
        assertEquals(fechaHora, movimiento.getFechaHora());
    }

    @Test
    @DisplayName("Establecer y obtener tipo de operación exitosamente")
    void testSetGetTipoOperacion() {
        movimiento.setTipoOperacion("Deposito");
        assertEquals("Deposito", movimiento.getTipoOperacion());
    }

    @Test
    @DisplayName("Establecer y obtener monto exitosamente")
    void testSetGetMonto() {
        movimiento.setMonto(100.0);
        assertEquals(100.0, movimiento.getMonto());
    }

    @Test
    @DisplayName("Mostrar información del movimiento exitosamente")
    void testToString() {
        movimiento.setFechaHora(LocalDateTime.now());
        movimiento.setTipoOperacion("Deposito");
        movimiento.setMonto(100.0);
        String expected = "Movimiento{, fechaHora=" + movimiento.getFechaHora() +
                          ", tipoOperacion='Deposito', monto=100.0}";
        assertEquals(expected, movimiento.toString());
    }

    @AfterEach
    void tearDown() {
        // Limpieza después de cada test si es necesario
    }
}
