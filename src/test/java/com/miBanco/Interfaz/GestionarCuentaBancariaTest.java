package com.miBanco.Interfaz;

import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import com.miBanco.Clases_sb.Cuenta;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class GestionarCuentaBancariaTest {

    private Banco banco;
    private GestionarCuentaBancaria gestionarCuentaBancaria;
    private Cliente cliente;
    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        banco = new Banco("Milabank");
        gestionarCuentaBancaria = new GestionarCuentaBancaria();
        cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
        cuenta = new Cuenta();
        cuenta.setId(1);
        cliente.getCuentas().add(cuenta);
    }

    @Test
    @DisplayName("Crear cuenta exitosamente")
    void testCrearCuenta() {
        String input = "1\n12345678\nCuenta Corriente\n3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    
        gestionarCuentaBancaria.renderMenuCuenta(banco);
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
    @DisplayName("Realizar operaciones exitosamente")
    void testRealizarOperaciones() {
        String input = "2\n12345678\n1\n50.0\n3\n3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarCuentaBancaria.renderMenuCuenta(banco);
        assertEquals(50.0, cuenta.getBalance());
    }

    @Test
    @DisplayName("Salir exitosamente")
    void testSalir() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        gestionarCuentaBancaria.renderMenuCuenta(banco);
        //verifica que el método termina sin errores
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // restaurar system.in al valor original
    }
}
