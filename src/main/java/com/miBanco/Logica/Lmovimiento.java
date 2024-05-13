package com.miBanco.Logica;
import com.miBanco.Clases_sb.Movimiento;
import java.time.LocalDateTime;

public class Lmovimiento{
    public Movimiento registrarTransferencia(double monto){
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoOperacion("Transferencia");
        movimiento.setMonto(monto);

        LocalDateTime fecha = LocalDateTime.now();

        movimiento.setFechaHora(fecha);
        return movimiento;
    }

    public Movimiento registrarRetiro(double monto){
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoOperacion("Retiro");
        movimiento.setMonto(monto);

        LocalDateTime fecha = LocalDateTime.now();
        movimiento.setFechaHora(fecha);
        return movimiento;
    }

    public Movimiento registrarDeposito(double monto){
        Movimiento movimiento = new Movimiento();
        movimiento.setTipoOperacion("Deposito");
        movimiento.setMonto(monto);

        LocalDateTime fecha = LocalDateTime.now();
        movimiento.setFechaHora(fecha);
        return movimiento;
    }

}
