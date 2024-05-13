package com.miBanco.Logica;
import java.util.List;
import java.util.Scanner;
import com.miBanco.Clases_sb.*;

public class Lcliente {
    // crear funcion CrearClientes
    public void CrearClientes(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Cliente();

        System.out.println("Ingrese el nombre del cliente:");
        String nombre = scanner.nextLine();
        cliente.setNombre(nombre);

        System.out.println("Ingrese el apellido del cliente:");
        String apellido = scanner.nextLine();
        cliente.setApellido(apellido);

        // setters
        System.out.println("Ingrese el dni del cliente:");
        String dni = scanner.nextLine();
        cliente.setDni(dni);

        System.out.println("Ingrese la dirección del cliente:");
        String Direccion = scanner.nextLine();
        cliente.setDireccion(Direccion);

        System.out.println("Ingrese el telefono del cliente:");
        String Telefono = scanner.nextLine();
        cliente.setTelefono(Telefono);

        banco.getClientes().add(cliente);

        System.out.println("Cliente creado exitosamente!");
        System.out.println("El cliente es: " + cliente.toString());
    }

    // crear funcion modificarCliente

    public void modificarCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente que desea modificar:");
        String dni = scanner.nextLine();

        List<Cliente> clientes = banco.getClientes();
        boolean encontrado = false;
        Cliente cliente = null;
        int indice = 0;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            if (cliente.getDni().equals(dni)) {
                // Se encontró el cliente con el DNI dado
                encontrado = true;
                indice = i;
                break;
            }
        }

        if (encontrado) {
            System.out.println("Ingrese el nuevo dato a modificar: ");
            System.out.println("1. Nombre");
            System.out.println("2. Apellido");
            System.out.println("3. Direccion");
            System.out.println("4. Telefono");
            System.out.println("5. Dni");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Ingrese el nuevo nombre:");
                    String nuevoNombre = scanner.nextLine();
                    cliente.setNombre(nuevoNombre);
                    break;
                case 2:
                    System.out.println("Ingrese el nuevo apellido:");
                    String nuevoApellido = scanner.nextLine();
                    cliente.setApellido(nuevoApellido);
                    break;
                case 3:
                    System.out.println("Ingrese la nueva Direccion:");
                    String nuevoDireccion = scanner.nextLine();
                    cliente.setDireccion(nuevoDireccion);
                    break;
                case 4:
                    System.out.println("Ingrese el nuevo telefono:");
                    String nuevoTelefono = scanner.nextLine();
                    cliente.setTelefono(nuevoTelefono);
                    break;
                case 5:
                    System.out.println("Ingrese el nuevo dni:");
                    String nuevoDni = scanner.nextLine();
                    cliente.setDni(nuevoDni);
                    break;
                default: 
                    System.out.println("Opcion inválida. Por favor seleccione 1-5.");
                    break;
            }
            clientes.set(indice, cliente);

        }
        else{
            System.out.println("No se encontro el cliente con el DNI dado.");
        }
    }
    public void eliminarCliente(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente que desea eliminar:");
        String dni = scanner.nextLine();

        List<Cliente> clientes = banco.getClientes();
        boolean encontrado = false;
        Cliente cliente = null;
        int indice = 0;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            if (cliente.getDni().equals(dni)) {
                // Se encontró el cliente con el DNI dado
                encontrado = true;
                indice = i;
                break;
            }
        }

        if (encontrado) {
            clientes.remove(indice);
            System.out.println("Cliente eliminado exitosamente!");
        }
        else {
            System.out.println("Cliente no encontrado."); 
        }
    }

    public void mostrarCliente(Banco banco) {
        List <Cliente> clientes = banco.getClientes();
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
        } else {
            System.out.println("Listado de clientes: ");
            for (Cliente cliente : clientes) {
                System.out.println(cliente.toString());
            }
        }
    }

    public Cliente iniciarSesion(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el dni del cliente:");
        String dni = scanner.nextLine();

        List<Cliente> clientes = banco.getClientes();
        Cliente cliente = null;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            if (cliente.getDni().equals(dni)) {  
                return cliente;
            }

        }
        return null;

      
    }

    
}

   
