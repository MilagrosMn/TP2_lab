package com.miBanco.Clases_sb;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class BancoTest {

    private Banco banco;

    @BeforeEach
    void setUp() {
        banco = new Banco("Mi Banco");
    }

    @Test
    @DisplayName("Obtener nombre del banco exitosamente")
    void testGetNombreBanco() {
        assertEquals("Mi Banco", banco.getNombreBanco());
    }

    @Test
    @DisplayName("Obtener clientes exitosamente")
    void testGetClientes() {
        Cliente cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
        assertFalse(banco.getClientes().isEmpty(), "La lista de clientes no debería estar vacía");
        Cliente clienteObtenido = banco.getClientes().get(0);
        assertEquals("12345678", clienteObtenido.getDni());
    }

    @Test
    @DisplayName("Establecer clientes exitosamente")
    void testSetClientes() {
        Cliente cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
        Cliente cliente2 = new Cliente();
        cliente2.setDni("87654321");
        banco.getClientes().add(cliente2);
        assertEquals(2, banco.getClientes().size());
    }

    @AfterEach
    void tearDown() {
        // Limpieza después de cada test si es necesario
    }
}
