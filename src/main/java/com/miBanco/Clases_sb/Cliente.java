package com.miBanco.Clases_sb;
import java.util.HashSet;
import java.util.Set;

public class Cliente {
    private String dni; 
    private String nombre;
    private String apellido;
    private String direccion;
    private String telefono;

    private Set<Cuenta> cuentas = new HashSet<>();

    public void setCuentas(Set<Cuenta> cuentas) {   
    }
   
    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    // Método para mostrar la información del cliente
    @Override
    public String toString() {
        return "Cliente{" +
                "DNI= " + dni +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", direccion='" + direccion + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }

    public Set<Cuenta> getCuentas() {
        
        return cuentas;
    }
    
}
