package com.miBanco.Logica;

import com.miBanco.Clases_sb.Movimiento;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class LmovimientoTest {

    private Lmovimiento lmovimiento;

    @BeforeEach
    void setUp() {
        lmovimiento = new Lmovimiento();
    }

    @Test
    @DisplayName("Registrar transferencia exitosamente")
    void testRegistrarTransferencia() {
        double monto = 100.0;
        Movimiento movimiento = lmovimiento.registrarTransferencia(monto);
        assertEquals("Transferencia", movimiento.getTipoOperacion());
        assertEquals(monto, movimiento.getMonto());
    }

    @Test
    @DisplayName("Registrar retiro exitosamente")
    void testRegistrarRetiro() {
        double monto = 50.0;
        Movimiento movimiento = lmovimiento.registrarRetiro(monto);
        assertEquals("Retiro", movimiento.getTipoOperacion());
        assertEquals(monto, movimiento.getMonto());
    }

    @Test
    @DisplayName("Registrar depósito exitosamente")
    void testRegistrarDeposito() {
        double monto = 200.0;
        Movimiento movimiento = lmovimiento.registrarDeposito(monto);
        assertEquals("Deposito", movimiento.getTipoOperacion());
        assertEquals(monto, movimiento.getMonto());
    }

    @AfterEach
    void tearDown() {
        // Limpieza después de cada test si es necesario
    }
}
