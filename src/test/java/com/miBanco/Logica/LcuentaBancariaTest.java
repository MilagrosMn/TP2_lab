package com.miBanco.Logica;
import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import com.miBanco.Clases_sb.Cuenta;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.time.LocalDateTime;

class LcuentaBancariaTest {

    private Banco banco;
    private LcuentaBancaria lcuentaBancaria;
    private Cliente cliente;

    @BeforeEach
    void setUp() {
        banco = new Banco("Milabank");
        lcuentaBancaria = new LcuentaBancaria();
        cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
    }

    @Test
    @DisplayName("Crear cuenta exitosamente")
    void testCrearCuenta() {
        String input = "12345678\nCuenta Corriente";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        lcuentaBancaria.crearCuenta(banco);
        assertFalse(cliente.getCuentas().isEmpty(), "La lista de cuentas no debería estar vacía");

        Cuenta cuentaBuscada = null;
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getTipoCuenta().equals("Cuenta Corriente")) {
                cuentaBuscada = cuenta;
                break;
            }
        }
        assertNotNull(cuentaBuscada, "La cuenta debería existir");
        assertEquals("Cuenta Corriente", cuentaBuscada.getTipoCuenta());
    }
    

    @Test
    @DisplayName("Iniciar sesión con cuenta existente")
    void testIniciarSesion() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1);
        cliente.getCuentas().add(cuenta);

        String input = "12345678\n1";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        Cuenta resultado = lcuentaBancaria.iniciarSesion(banco);
        assertNotNull(resultado, "Debería haber encontrado una cuenta");
        assertEquals(1, resultado.getId());
    }

    @Test
    @DisplayName("Buscar cuenta existente")
    void testBuscarCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1);
        cliente.getCuentas().add(cuenta);

        Cuenta resultado = lcuentaBancaria.buscarCuenta(cliente, 1);
        assertNotNull(resultado, "Debería haber encontrado una cuenta");
        assertEquals(1, resultado.getId());
    }

    @Test
    @DisplayName("Ver estado de cuenta existente")
    void testVerEstadoCuenta() {
        Cuenta cuenta = new Cuenta();
        cuenta.setId(1);
        cuenta.setFechaCreacion(LocalDateTime.now());
        cuenta.setTipoCuenta("Cuenta Corriente");
        cuenta.setBalance(100.0);
        cliente.getCuentas().add(cuenta);

        lcuentaBancaria.verEstadoCuenta(cuenta);
        //verifica la salida en consola
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // restaurar system.in al valor original
    }
}
