package com.miBanco.Interfaz;

import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GestionClientesTest {

    private Banco banco;
    private GestionClientes gestionClientes;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        banco = new Banco("Milabank");
        gestionClientes = new GestionClientes();
        cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
    }

    @Test
    @DisplayName("Crear cliente exitosamente")
    void testCrearCliente() {
        String input = "1\nMilagros\nMuñoz N.\n12345678\nCalle Falsa 123\n555-1234\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionClientes.renderMenuClientes(banco);
        assertFalse(banco.getClientes().isEmpty(), "La lista de clientes no debería estar vacía");
        Cliente cliente = banco.getClientes().get(0);
        assertEquals("Milagros", cliente.getNombre());
        assertEquals("Muñoz N.", cliente.getApellido());
        assertEquals("12345678", cliente.getDni());
        assertEquals("Calle Falsa 123", cliente.getDireccion());
        assertEquals("555-1234", cliente.getTelefono());
    }

    @Test
    @DisplayName("Modificar cliente exitosamente")
    void testModificarCliente() {
        String input = "2\n12345678\n1\nMilagros\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionClientes.renderMenuClientes(banco);
        assertEquals("Milagros", cliente.getNombre());
    }

    @Test
    @DisplayName("Eliminar cliente exitosamente")
    void testEliminarCliente() {
        String input = "3\n12345678\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionClientes.renderMenuClientes(banco);
        assertTrue(banco.getClientes().isEmpty(), "La lista de clientes debería estar vacía");
    }

    @Test
    @DisplayName("Mostrar clientes exitosamente")
    void testMostrarClientes() {
        String input = "4\n5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionClientes.renderMenuClientes(banco);
        //verifica que el método termina sin errores
    }

    @Test
    @DisplayName("Salir exitosamente")
    void testSalir() {
        String input = "5";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionClientes.renderMenuClientes(banco);
        //verifica que el método termina sin errores
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // restaurar system.in al valor original
    }
}
