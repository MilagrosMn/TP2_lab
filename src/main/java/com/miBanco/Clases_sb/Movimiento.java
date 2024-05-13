package com.miBanco.Clases_sb;
import java.time.LocalDateTime;

public class Movimiento {
    private LocalDateTime fechaHora;
    private String tipoOperacion;
    private double monto;

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }
    public void setTipoOperacion(String tipoOperacion) {
        this.tipoOperacion = tipoOperacion;
    }
    public String getTipoOperacion() {
        return tipoOperacion;
    }
    public double getMonto() {
        return monto;
    }
    public void setMonto(double monto) {
        this.monto = monto;
    }

    @Override
    public String toString() {
        return "Movimiento{" +
               ", fechaHora=" + fechaHora +
               ", tipoOperacion='" + tipoOperacion + '\'' +
               ", monto=" + monto +
               '}';
    }
}
