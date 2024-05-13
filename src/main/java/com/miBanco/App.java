package com.miBanco;
import com.miBanco.Clases_sb.*;
import com.miBanco.Interfaz.Menu;

public class App {
    public static void main(String[] args) { // Crear una obj de la clase App

        Banco miBanco = new Banco("Milabank"); // Crear una obj de la clase Banco
        
        Menu menu = new Menu(); // Crear una obj de la clase Menu
        
        menu.renderMenu(miBanco); //llamar al menu
    
    }
}
