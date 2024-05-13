package com.miBanco.Clases_sb;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

public class Cuenta {
    int id;
    LocalDateTime fechaCreacion;
    double balance;
    String tipoCuenta;

    private Set<Movimiento> movimientos = new HashSet<>();

    public Set<Movimiento> getMovimientos() {

        return movimientos;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(LocalDateTime fechaCreacion) {
        this.fechaCreacion = fechaCreacion;

    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }
}
