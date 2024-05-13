package com.miBanco.Clases_sb;

import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class ClienteTest {

    private Cliente cliente;

    @BeforeEach
    void setUp() {
        cliente = new Cliente();
    }

    @Test
    @DisplayName("Establecer y obtener DNI exitosamente")
    void testSetGetDni() {
        cliente.setDni("12345678");
        assertEquals("12345678", cliente.getDni());
    }

    @Test
    @DisplayName("Establecer y obtener nombre exitosamente")
    void testSetGetNombre() {
        cliente.setNombre("Milagros");
        assertEquals("Milagros", cliente.getNombre());
    }

    @Test
    @DisplayName("Establecer y obtener apellido exitosamente")
    void testSetGetApellido() {
        cliente.setApellido("Muñoz N.");
        assertEquals("Muñoz N.", cliente.getApellido());
    }

    @Test
    @DisplayName("Establecer y obtener dirección exitosamente")
    void testSetGetDireccion() {
        cliente.setDireccion("Calle Falsa 123");
        assertEquals("Calle Falsa 123", cliente.getDireccion());
    }

    @Test
    @DisplayName("Establecer y obtener teléfono exitosamente")
    void testSetGetTelefono() {
        cliente.setTelefono("555-1234");
        assertEquals("555-1234", cliente.getTelefono());
    }

    @Test
    @DisplayName("Establecer y obtener cuentas exitosamente")
    void testSetGetCuentas() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1);
        cliente.getCuentas().add(cuenta);
        assertFalse(cliente.getCuentas().isEmpty(), "La lista de cuentas no debería estar vacía");
        Cuenta cuentaObtenida = cliente.getCuentas().iterator().next();
        assertEquals(1, cuentaObtenida.getId());
    }

    @Test
    @DisplayName("Mostrar información del cliente exitosamente")
    void testToString() {
        cliente.setDni("12345678");
        cliente.setNombre("Milagros");
        cliente.setApellido("Muñoz N.");
        cliente.setDireccion("Calle Falsa 123");
        cliente.setTelefono("555-1234");
        String expected = "Cliente{DNI= 12345678, nombre='Milagros', apellido='Muñoz N.', direccion='Calle Falsa 123', telefono='555-1234'}";
        assertEquals(expected, cliente.toString());
    }

    @AfterEach
    void tearDown() {
        // Limpieza después de cada test si es necesario
    }
}
