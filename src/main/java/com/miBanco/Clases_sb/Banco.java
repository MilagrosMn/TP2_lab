package com.miBanco.Clases_sb;
import java.util.ArrayList;
import java.util.List;

public class Banco {

    private String nombreBanco;
    private List<Cliente> clientes = new ArrayList<>();

    public Banco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

    public String getNombreBanco() {
        return nombreBanco;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    public void setClientes(List<Cliente> clientes) {
        this.clientes = clientes;
    }

}