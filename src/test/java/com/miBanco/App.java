package com.miBanco;
import com.miBanco.Clases_sb.*;
import com.miBanco.Interfaz.Menu;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.AfterEach;

import static org.junit.jupiter.api.Assertions.*;

class AppTest {

    @SuppressWarnings("unused")
    private App app;
    private Banco miBanco;
    private Menu menu;

    @BeforeEach
    void setUp() {
        miBanco = new Banco("Milabank");
        menu = new Menu();
        app = new App();
    }

    @Test
    @DisplayName("Test Main Execution")
    void testMain() {
        assertDoesNotThrow(() -> App.main(new String[]{}));
    }

    @Test
    @DisplayName("Test Banco Creation")
    void testBancoCreation() {
        assertEquals("Milabank", miBanco.getNombreBanco());
    }

    @Test
    @DisplayName("Test Menu Rendering")
    void testMenuRendering() {
        assertDoesNotThrow(() -> menu.renderMenu(miBanco));
    }

    @AfterEach
    void tearDown() {
        app = null;
        miBanco = null;
        menu = null;
    }
}
