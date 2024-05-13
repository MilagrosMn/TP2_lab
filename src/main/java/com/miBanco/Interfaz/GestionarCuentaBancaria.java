package com.miBanco.Interfaz;
import java.util.Scanner;
import com.miBanco.Logica.LcuentaBancaria;
import com.miBanco.Clases_sb.Cuenta;
import com.miBanco.Clases_sb.Banco;

public class GestionarCuentaBancaria {
    boolean exit = false;
    private Scanner scanner = new Scanner(System.in);
    public void renderMenuCuenta(Banco banco) {

        while (!exit) {
           
            System.out.println("Gestionar Cuenta Bancaria");   
            System.out.println("1. Crear Cuenta");
            System.out.println("2. Realizar Operaciones");
            System.out.println("3. Salir");
            System.out.print("Ingrese su opción (1-3): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            LcuentaBancaria lcuenta = new LcuentaBancaria();
            
            
            switch (choice) {
                case 1:
                    lcuenta.crearCuenta(banco);
                    break;
                case 2:
                    Cuenta cuenta = new LcuentaBancaria().iniciarSesion(banco);
                    if (cuenta != null) {
                        GestionarOperaciones gestionar = new GestionarOperaciones();
                        gestionar.renderMenuOperacion(cuenta, banco);
                    } 
                break;
                case 3:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-5.");
            }
        }
    }
    
}
