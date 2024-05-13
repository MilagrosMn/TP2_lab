package com.miBanco.Logica;
// import java.util.Iterator;
import java.util.Scanner;
import com.miBanco.Clases_sb.Banco;
import com.miBanco.Clases_sb.Cliente;
import com.miBanco.Clases_sb.Cuenta;
import com.miBanco.Clases_sb.Movimiento;


public class Loperacion {
    public void consultarSaldo(Cuenta cuenta, Banco banco) {
        System.out.println("Numero de cuenta: " + cuenta.getId());
    
        System.out.println("Balance: " + cuenta.getBalance());  
    }

    public void depositar(Cuenta cuenta) {
        System.out.println("Depositar: ");
        Scanner scanner = new Scanner(System.in);
        double deposito = scanner.nextDouble();

        if (deposito <= 0) {
            System.out.println("No se puede depositar un valor negativo");
            return;
        }
        
        cuenta.setBalance(deposito + cuenta.getBalance());
        System.out.println("Se depositó: " + deposito);
        System.out.println("Su saldo es: " + cuenta.getBalance());

        Lmovimiento lmovimiento = new Lmovimiento();
                        Movimiento movimiento = lmovimiento.registrarDeposito(deposito);
                        cuenta.getMovimientos().add(movimiento);
                        return;

    }

    public void retirar(Cuenta cuenta) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Monto a retirar:");
        double saldo = scanner.nextDouble();

        if (saldo < 0) {
            System.out.println("El saldo no puede ser negativo");
            return;
        } else if (saldo > cuenta.getBalance()) {
            System.out.println("El saldo a retirar no puede ser mayor al saldo actual");
            return;
        }

        cuenta.setBalance(cuenta.getBalance() - saldo);
        System.out.println("Se retiró: " + saldo);
        System.out.println("Su saldo es: " + cuenta.getBalance());

        Lmovimiento lmovimiento = new Lmovimiento();
                        Movimiento movimiento = lmovimiento.registrarRetiro(saldo);
                        cuenta.getMovimientos().add(movimiento);
                        return;
    }

     public void transferir(Cuenta cuenta, Banco banco) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Ingrese el numero de cuenta a transferir");
        int id = scanner.nextInt();

        for (Cliente cliente : banco.getClientes()) {
            for (Cuenta cuentaCliente : cliente.getCuentas()) {
                if (cuentaCliente.getId() == id) {
                    System.out.println("Cuenta encontrada");
                    System.out.println("Ingrese el monto a transferir");
                    double saldo = scanner.nextDouble();

                    if (saldo < 0) {
                        System.out.println("El saldo no puede ser negativo");
                        return;
                    } else if (saldo > cuenta.getBalance()) {
                        System.out.println("El saldo a transferir no puede ser mayor al saldo actual");
                        return;
                    } else {
                        cuenta.setBalance(cuenta.getBalance() - saldo);
                        cuentaCliente.setBalance(cuentaCliente.getBalance() + saldo);
                        System.out.println("Transferencia realizada con éxito");
                        System.out.println("Saldo actual: " + cuenta.getBalance());

                        Lmovimiento lmovimiento = new Lmovimiento();
                        Movimiento movimiento = lmovimiento.registrarTransferencia(saldo);
                        cuenta.getMovimientos().add(movimiento);
                        return;
                    }
                }
            }
        }
        System.out.println("No se encontro la cuenta a transferir");
    }

    public void verMovimientos(Cuenta cuenta) {

        if (cuenta.getMovimientos().isEmpty()) {
            System.out.println("No hay movimientos");
        } else {
            System.out.println("Movimientos: ");
            for (Movimiento movimiento : cuenta.getMovimientos()) {
                System.out.println(movimiento.toString());
            }
        }

    }

}

