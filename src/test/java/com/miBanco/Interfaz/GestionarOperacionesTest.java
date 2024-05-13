package com.miBanco.Interfaz;

import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import com.miBanco.Clases_sb.Cuenta;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GestionarOperacionesTest {

    private Banco banco;
    private GestionarOperaciones gestionarOperaciones;
    private Cliente cliente;
    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        banco = new Banco("Milabank");
        gestionarOperaciones = new GestionarOperaciones();
        cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
        cuenta = new Cuenta();
        cuenta.setId(1);
        cliente.getCuentas().add(cuenta);
    }

    @Test
    @DisplayName("Ver movimientos exitosamente")
    void testVerMovimientos() {
        String input = "1\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarOperaciones.renderMenuOperacion(cuenta, banco);
        //verifica que el método termina sin errores
    }

    @Test
    @DisplayName("Realizar transferencia exitosamente")
    void testTransferir() {
        Cuenta cuenta2 = new Cuenta();
        cuenta2.setId(2);
        cliente.getCuentas().add(cuenta2);
        cuenta.setBalance(100.0);

        String input = "2\n12345678\n2\n50.0\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarOperaciones.renderMenuOperacion(cuenta, banco);
        assertEquals(50.0, cuenta.getBalance());
        assertEquals(50.0, cuenta2.getBalance());
    }

    @Test
    @DisplayName("Depositar exitosamente")
    void testDepositar() {
        String input = "3\n50.0\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarOperaciones.renderMenuOperacion(cuenta, banco);
        assertEquals(50.0, cuenta.getBalance());
    }

    @Test
    @DisplayName("Retirar exitosamente")
    void testRetirar() {
        cuenta.setBalance(100.0);
        String input = "4\n50.0\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarOperaciones.renderMenuOperacion(cuenta, banco);
        assertEquals(50.0, cuenta.getBalance());
    }

    @Test
    @DisplayName("Consultar saldo exitosamente")
    void testConsultarSaldo() {
        cuenta.setBalance(100.0);
        String input = "5\n6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarOperaciones.renderMenuOperacion(cuenta, banco);
        // No hay aserción aquí, solo se verifica que el método termina sin errores
    }

    @Test
    @DisplayName("Salir exitosamente")
    void testSalir() {
        String input = "6";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarOperaciones.renderMenuOperacion(cuenta, banco);
        // No hay aserción aquí, solo se verifica que el método termina sin errores
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // Restaurar System.in al valor original
    }
}
