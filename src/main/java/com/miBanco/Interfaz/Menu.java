package com.miBanco.Interfaz;
import java.util.Scanner;
import com.miBanco.Clases_sb.*;
public class Menu {
    boolean exit = false;
    private Scanner scanner = new Scanner(System.in);

    public void renderMenu(Banco banco) {

        while (!exit) {
            System.out.println("Bienveido a la aplicación de Banco" + banco.getNombreBanco());
            System.out.println("1. Gestionar clientes");
            System.out.println("2. Gestionar Cuenta");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            switch (choice) {
                case 1:
                    GestionClientes gestion = new GestionClientes();
                    gestion.renderMenuClientes(banco);
                    break;
                case 2:
                    GestionarCuentaBancaria gestionar = new GestionarCuentaBancaria();
                    gestionar.renderMenuCuenta(banco);
                    break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-3.");
            }
        }
    }
}