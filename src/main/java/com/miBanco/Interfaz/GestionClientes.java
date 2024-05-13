package com.miBanco.Interfaz;
import java.util.Scanner;
import com.miBanco.Clases_sb.Banco;
import com.miBanco.Logica.Lcliente;

public class GestionClientes {
    private Scanner scanner = new Scanner(System.in);

    public void renderMenuClientes(Banco banco) {
        boolean exit = false;
        while (!exit) {
           
            System.out.println("Gestionar clientes");   
            System.out.println("1. Crear Cliente");
            System.out.println("2. Modificar Cliente");
            System.out.println("3. Eliminar Cliente");  
            System.out.println("4. Mostrar Clientes");
            System.out.println("5. Salir");
            System.out.print("Ingrese su opción (1-5): ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            Lcliente lcliente = new Lcliente();
            
            switch (choice) {
                case 1:
                    lcliente.CrearClientes(banco);
                    break;
                case 2:
                    lcliente.modificarCliente(banco);

                break;
                case 3:
                    lcliente.eliminarCliente(banco);
                    break;
                case 4:
                    lcliente.mostrarCliente(banco);
                    
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Opción inválida. Por favor seleccione 1-5.");
            }
        }
    }
}
