package com.miBanco.Interfaz;
import java.util.Scanner;
import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cuenta;
import com.miBanco.Logica.Loperacion;

public class GestionarOperaciones {
    boolean exit = false;
    private Scanner scanner = new Scanner(System.in);
    public void renderMenuOperacion(Cuenta cuenta, Banco banco) {

        while (!exit) {
           
            System.out.println("Gestionar Cuenta Bancaria");
            System.out.println("1. Ver Movimientos");
            System.out.println("2. Transferencia");   
            System.out.println("3. Depositar: ");
            System.out.println("4. Retirar: "); 
            System.out.println("5. Consultar Saldo: ");
            System.out.println("6. Salir");
            System.out.print("Ingrese su opción (1-6): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); 

            Loperacion loperacion = new Loperacion();
        
            switch (choice) {
                case 1:
                    loperacion.verMovimientos(cuenta);
                    break;
                case 2:
                    loperacion.transferir(cuenta, banco);
                break;
                case 3:
                    loperacion.depositar(cuenta);
                    break;
                case 4:
                    loperacion.retirar(cuenta);
                    break;
                case 5:
                        loperacion.consultarSaldo(cuenta, banco);
                    break;
                case 6:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-6.");
            }
        }
    }
}