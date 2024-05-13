package com.miBanco.Logica;

import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LclienteTest {

    private Banco banco;
    private Lcliente lcliente;

    @BeforeEach
    void setUp() {
        banco = new Banco("Milabank");
        lcliente = new Lcliente();
        // Agregar clientes de prueba al banco si es necesario
    }

    @Test
    @DisplayName("Crear cliente exitosamente")
    void testCrearClientes() {
        String input = "Milagros\nMuñoz N.\n12345678\nCalle Falsa 123\n555-1234";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        lcliente.CrearClientes(banco);
        assertFalse(banco.getClientes().isEmpty(), "La lista de clientes no debería estar vacía");
        Cliente cliente = banco.getClientes().get(0);
        assertEquals("Milagros", cliente.getNombre());
        assertEquals("Muñoz N.", cliente.getApellido());
        assertEquals("12345678", cliente.getDni());
        assertEquals("Calle Falsa 123", cliente.getDireccion());
        assertEquals("555-1234", cliente.getTelefono());
    }

    @Test
    @DisplayName("Modificar cliente existente")
    void testModificarCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);

        String input = "12345678\n1\nJuan";
        InputStream in = new ByteArrayInputStream(input.getBytes()); //simula la entrada de datos a traves del Scanner
        System.setIn(in);

        lcliente.modificarCliente(banco);
        assertEquals("Milagros", banco.getClientes().get(0).getNombre());
    }

    @Test
    @DisplayName("Eliminar cliente existente")
    void testEliminarCliente() {
        Cliente cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);

        String input = "12345678";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        lcliente.eliminarCliente(banco);
        assertTrue(banco.getClientes().isEmpty(), "El cliente debería haber sido eliminado");
    }

    @Test
    @DisplayName("Mostrar cliente existente")
    void testMostrarCliente() {
        Cliente cliente = new Cliente();
        cliente.setNombre("Milagros");
        cliente.setApellido("Muñoz N.");
        cliente.setDni("12345678");
        cliente.setDireccion("Calle Falsa 123");
        cliente.setTelefono("555-1234");
        banco.getClientes().add(cliente);

        lcliente.mostrarCliente(banco);
        //verifica la salida en consola
    }

    @Test
    @DisplayName("Iniciar sesión con DNI existente")
    void testIniciarSesion() {
        Cliente cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);

        String input = "12345678";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Cliente resultado = lcliente.iniciarSesion(banco);
        assertNotNull(resultado, "Debería haber encontrado un cliente");
        assertEquals("12345678", resultado.getDni());
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // Restaurar System.in al valor original
    }
}

    