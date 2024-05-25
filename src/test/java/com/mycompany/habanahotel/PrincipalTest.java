/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.habanahotel;

import java.awt.Window;
import java.awt.event.MouseListener;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

/**
 * Clase de prueba para la clase Principal. Contiene métodos de prueba para
 * verificar el funcionamiento de la clase Principal.
 *
 * @author José Carlos Lucientes Casaos
 */
public class PrincipalTest {

    private Principal principal;

    /**
     * Configuración inicial para cada prueba.
     */
    @BeforeEach
    public void setUp() {
        principal = new Principal(new javax.swing.JFrame(), false);
    }

    /**
     * Prueba el método initComponents de la clase Principal. Verifica que los
     * componentes principales no sean null después de la inicialización.
     */
    @Test
    public void testInitComponents() {
        boolean result = principal != null
                && principal.btnNuevaReserva != null
                && principal.btnVerReservas != null
                && principal.mnNuevaReserva != null
                && principal.mnVerReservas != null;

        if (result) {
            System.out.println("Resultado de la prueba de testInitComponents: Ok");
        } else {
            System.out.println("Resultado de la prueba de testInitComponents: No Ok");
        }

        // Asegurando que el test falle si alguno de los componentes es null
        assertNotNull(principal);
        assertNotNull(principal.btnNuevaReserva);
        assertNotNull(principal.btnVerReservas);
        assertNotNull(principal.mnNuevaReserva);
        assertNotNull(principal.mnVerReservas);
    }

    /**
     * Prueba del método btnNuevaReservaActionPerformed. Verifica que la ventana
     * de nueva reserva se abra al hacer clic en el botón correspondiente.
     */
    @Test
    public void testBtnNuevaReservaActionPerformed() {
        principal.btnNuevaReserva.doClick();

        // Verifica si la ventana de nueva reserva está visible
        boolean isVisible = false;
        for (Window window : Window.getWindows()) {
            if (window instanceof Reservas) {
                isVisible = window.isVisible();
                window.dispose();  // Cierra la ventana después de verificar
            }
        }

        if (isVisible) {
            System.out.println("Resultado de la prueba de btnNuevaReservaActionPerformed: Ok");
        } else {
            System.out.println("Resultado de la prueba de btnNuevaReservaActionPerformed: No Ok");
        }

        assertTrue(isVisible, "The new reservation window should be visible.");
    }

    /**
     * Prueba del método btnVerReservasActionPerformed. Verifica que la ventana
     * de lista de reservas no se abra al hacer clic en el botón
     * correspondiente.
     */
    @Test
    public void testBtnVerReservasActionPerformed() {
        principal.btnVerReservas.doClick();

        // Verifica si la ventana de lista de reservas está visible
        boolean isVisible = false;
        for (Window window : Window.getWindows()) {
            if (window instanceof Listado) {
                isVisible = window.isVisible();
                window.dispose();  // Cierra la ventana después de verificar
            }
        }

        if (isVisible) {
            System.out.println("Resultado de la prueba de btnVerReservasActionPerformed: Ok");
        } else {
            System.out.println("Resultado de la prueba de btnVerReservasActionPerformed: No Ok");
        }

        assertFalse(isVisible, "La prueba ha fallado.");
    }

    /**
     * Prueba del método mnNuevaReservaMouseClicked. Verifica que la ventana de
     * nueva reserva se abra al hacer clic en el elemento de menú
     * correspondiente.
     */
    @Test
    public void testMnNuevaReservaMouseClicked() {
        // Simula un clic de ratón en el elemento de menú
        for (MouseListener listener : principal.mnNuevaReserva.getMouseListeners()) {
            listener.mouseClicked(null);
        }

        // Verifica si la ventana de nueva reserva está visible
        boolean isVisible = false;
        for (Window window : Window.getWindows()) {
            if (window instanceof Reservas) {
                isVisible = window.isVisible();
                window.dispose();  // Cierra la ventana después de verificar
            }
        }

        if (isVisible) {
            System.out.println("Resultado de la prueba de mnNuevaReservaMouseClicked: Ok");
        } else {
            System.out.println("Resultado de la prueba de mnNuevaReservaMouseClicked: No Ok");
        }

        assertTrue(isVisible, "La prueba ha fallado.");
    }

    /**
     * Prueba del método mnVerReservasMouseClicked. Verifica que la ventana de
     * lista de reservas no se abra al hacer clic en el elemento de menú
     * correspondiente.
     */
    @Test
    public void testMnVerReservasMouseClicked() {
        // Simula un clic de ratón en el elemento de menú
        for (MouseListener listener : principal.mnVerReservas.getMouseListeners()) {
            listener.mouseClicked(null);
        }

        // Verifica si la ventana de lista de reservas está visible
        boolean isVisible = false;
        for (Window window : Window.getWindows()) {
            if (window instanceof Listado) {
                isVisible = window.isVisible();
                window.dispose();  // Cierra la ventana después de verificar
            }
        }

        if (isVisible) {
            System.out.println("Resultado de la prueba de mnVerReservasMouseClicked: Ok");
        } else {
            System.out.println("Resultado de la prueba de mnVerReservasMouseClicked: No Ok");
        }

        assertFalse(isVisible, "La prueba ha fallado.");
    }
}