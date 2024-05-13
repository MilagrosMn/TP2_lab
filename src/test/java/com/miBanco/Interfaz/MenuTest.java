package com.miBanco.Interfaz;

import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import com.miBanco.Clases_sb.Cuenta;
import org.junit.jupiter.api.*;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

class MenuTest {

    private Banco banco;
    private Menu menu;
    private Cliente cliente;
    private Cuenta cuenta;

    @BeforeEach
    void setUp() {
        banco = new Banco("Milabank");
        menu = new Menu();
        cliente = new Cliente();
        cliente.setDni("12345678");
        banco.getClientes().add(cliente);
        cuenta = new Cuenta();
        cuenta.setId(1);
        cliente.getCuentas().add(cuenta);
    }

    @Test
    @DisplayName("Gestionar clientes exitosamente")
    void testGestionarClientes() {
        String input = "1\n5\n3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.renderMenu(banco);
        // No hay aserción aquí, solo se verifica que el método termina sin errores
    }

    @Test
    @DisplayName("Gestionar cuenta exitosamente")
    void testGestionarCuenta() {
        String input = "2\n5\n3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.renderMenu(banco);
        // No hay aserción aquí, solo se verifica que el método termina sin errores
    }

    @Test
    @DisplayName("Salir exitosamente")
    void testSalir() {
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        menu.renderMenu(banco);
        // No hay aserción aquí, solo se verifica que el método termina sin errores
    }

    @AfterEach
    void tearDown() {
        System.setIn(System.in); // restaurar system.in al valor original
    }
}
