package com.miBanco.Logica;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import com.miBanco.Clases_sb.Cuenta;

public class LcuentaBancaria {

    private static int id = 1;

    public void crearCuenta(Banco banco) {
        Scanner scanner = new Scanner(System.in);

        // ver si clienmte existe - system out ya existe

        System.out.println("Ingrese el dni del cliente para crear la cuenta:");
        String dni = scanner.nextLine();
        List<Cliente> clientes = banco.getClientes();
        Cliente cliente = null;
        boolean existe = false;
        for (int i = 0; i < clientes.size(); i++) {
            cliente = clientes.get(i);
            if (cliente.getDni().equals(dni)) {
                System.out.println("Cliente encontrado: ");
                existe = true;
                break;
            }
        }
        if (!existe) {
            System.out.println("No se encontró el cliente con el DNI dado");
            return;
        }
        
        Cuenta cuenta = new Cuenta();
        cuenta.setId(id);
        cuenta.setFechaCreacion(LocalDateTime.now());
        cuenta.setBalance(0.0);
        
        System.out.println("Que tipo de cuenta desea crear?");
        String tipoCuenta = scanner.nextLine();
        cuenta.setTipoCuenta(tipoCuenta);
        System.out.println("Cuenta creada exitosamente!");
        
        cliente.getCuentas().add(cuenta);
        System.out.println("La cuenta es: " + id);

        id++; 
    }

    public Cuenta iniciarSesion(Banco banco) {
        Scanner scanner = new Scanner(System.in);
        Cliente cliente = new Lcliente().iniciarSesion(banco);

        if(cliente == null) {
            System.out.println("No se encontró el cliente con el DNI dado");
            return null;
            
        }
        
        if(cliente.getCuentas().isEmpty()) {
            System.out.println("El cliente no tiene cuentas");
            return null;
        }

        System.out.println("Ingrese el numero de cuenta:");
        int numeroCuenta = scanner.nextInt();
        scanner.nextLine();

        Cuenta cuenta = buscarCuenta(cliente, numeroCuenta);    

        if (cuenta == null) {
            System.out.println("No se encontró la cuenta con el DNI dado");
            return null;
        }
        return cuenta;
    }

    public Cuenta buscarCuenta(Cliente cliente, int numeroCuenta) {
        for (Cuenta cuenta : cliente.getCuentas()) {
            if (cuenta.getId() == numeroCuenta) {
                return cuenta;
            }
        }
        return null;
    }
    public void verEstadoCuenta(Cuenta cuenta) {
        System.out.println("Estado de la cuenta");
        System.out.println("Numero de cuenta: " + cuenta.getId());
        System.out.println("Fecha de creacion: " + cuenta.getFechaCreacion());
        System.out.println("Tipo de cuenta: " + cuenta.getTipoCuenta());
        System.out.println("Balance: " + cuenta.getBalance());
        
    }
}

