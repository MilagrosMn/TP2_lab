package com.miBanco.Logica;

import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import com.miBanco.Clases_sb.Cuenta;
import com.miBanco.Clases_sb.Movimiento;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class LoperacionTest {

    private Banco banco;
    private Loperacion loperacion;
    private Cliente cliente;
    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        banco = new Banco("Milabank");
        loperacion = new Loperacion();
        cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
        cuenta = new Cuenta();
        cuenta.setId(1);
        cliente.getCuentas().add(cuenta);
    }

    @Test
    @DisplayName("Consultar saldo exitosamente")
    void testConsultarSaldo() {
        cuenta.setBalance(100.0);
        loperacion.consultarSaldo(cuenta, banco);
        //verifica la salida en consola
    }

    @Test
    @DisplayName("Depositar exitosamente")
    void testDepositar() {
        String input = "50.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        loperacion.depositar(cuenta);
        assertEquals(50.0, cuenta.getBalance());
    }

    @Test
    @DisplayName("Retirar exitosamente")
    void testRetirar() {
        cuenta.setBalance(100.0);
        String input = "50.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        loperacion.retirar(cuenta);
        assertEquals(50.0, cuenta.getBalance());
    }

    @Test
    @DisplayName("Transferir exitosamente")
    void testTransferir() {
        Cuenta cuenta2 = new Cuenta();
        cuenta2.setId(2);
        cliente.getCuentas().add(cuenta2);
        cuenta.setBalance(100.0);

        String input = "2\n50.0";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        loperacion.transferir(cuenta, banco);
        assertEquals(50.0, cuenta.getBalance());
        assertEquals(50.0, cuenta2.getBalance());
    }

    @Test
    @DisplayName("Ver movimientos exitosamente")
    void testVerMovimientos() {
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoOperacion("Deposito");
        movimiento.setMonto(50.0);
        cuenta.getMovimientos().add(movimiento);

        loperacion.verMovimientos(cuenta);
        // No hay aserción aquí, solo se verifica la salida en consola
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // Restaurar System.in al valor original
    }
}
