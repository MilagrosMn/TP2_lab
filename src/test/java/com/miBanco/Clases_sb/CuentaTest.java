package com.miBanco.Clases_sb;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDateTime;

class CuentaTest {

    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        cuenta = new Cuenta();
    }

    @Test
    @DisplayName("Establecer y obtener ID exitosamente")
    void testSetGetId() {
        cuenta.setId(1);
        assertEquals(1, cuenta.getId());
    }

    @Test
    @DisplayName("Establecer y obtener fecha de creación exitosamente")
    void testSetGetFechaCreacion() {
        LocalDateTime fechaCreacion = LocalDateTime.now();
        cuenta.setFechaCreacion(fechaCreacion);
        assertEquals(fechaCreacion, cuenta.getFechaCreacion());
    }

    @Test
    @DisplayName("Establecer y obtener balance exitosamente")
    void testSetGetBalance() {
        cuenta.setBalance(100.0);
        assertEquals(100.0, cuenta.getBalance());
    }

    @Test
    @DisplayName("Establecer y obtener tipo de cuenta exitosamente")
    void testSetGetTipoCuenta() {
        cuenta.setTipoCuenta("Cuenta Corriente");
        assertEquals("Cuenta Corriente", cuenta.getTipoCuenta());
    }

    @Test
    @DisplayName("Establecer y obtener movimientos exitosamente")
    void testSetGetMovimientos() {
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoOperacion("Deposito");
        movimiento.setMonto(50.0);
        cuenta.getMovimientos().add(movimiento);
        assertFalse(cuenta.getMovimientos().isEmpty(), "La lista de movimientos no debería estar vacía");
        Movimiento movimientoObtenido = cuenta.getMovimientos().iterator().next();
        assertEquals("Deposito", movimientoObtenido.getTipoOperacion());
        assertEquals(50.0, movimientoObtenido.getMonto());
    }

    @AfterEach
    void tearDown() {
        // Limpieza después de cada test si es necesario
    }
}
