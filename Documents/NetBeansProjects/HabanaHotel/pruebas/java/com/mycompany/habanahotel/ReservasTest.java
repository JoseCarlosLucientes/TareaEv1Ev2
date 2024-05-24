/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.habanahotel;

import static com.mycompany.habanahotel.Reservas.*;
import java.awt.event.ActionEvent;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import javax.swing.*;

/**
 * Clase de prueba para la clase Reservas. Contiene métodos de prueba para
 * verificar el funcionamiento de la clase Reservas.
 *
 * @author José Carlos Lucientes Casaos
 */
public class ReservasTest {

    private Reservas reservas;

    /**
     * Configuración inicial para cada prueba. Inicializa una instancia de
     * Reservas y resetea la matriz de reservas.
     */
    @BeforeEach
    public void setUp() {
        reservas = new Reservas(new JFrame(), true);
        Reservas.matriz = new String[10][10];  // Resetting the matriz for each test
    }

    /**
     * Prueba para verificar el guardado de una reserva con todos los datos
     * completos.
     */
    @Test //Guardado datos completos
    public void testGuardarReservaConDatosCompletos() {
        // Preparación de datos
        reservas.txtNombre.setText("John Doe");
        reservas.txtTelefono.setText("123456789");
        reservas.cmbEvento.setSelectedItem("CONGRESO");
        reservas.txtJornadas.setValue(2);
        reservas.chkHabitaciones.setSelected(true);
        reservas.cmbTipoCocina.setSelectedItem("BUFE");
        reservas.txtNumPersonas.setValue(100);
        reservas.cldCalendario.setDate(new java.util.Date());

        // Ejecución del método
        // reservas.btnGuardarActionPerformed(null);
        reservas.triggerGuardarAction();

        // Verificación
        boolean result = Reservas.matriz[0][CONST_NOMBRE].equals("John Doe")
                && Reservas.matriz[0][CONST_TELEFONO].equals("123456789")
                && Reservas.matriz[0][CONST_TIPOEVENTO].equals("CONGRESO")
                && Reservas.matriz[0][CONST_JORNADAS].equals("2")
                && Reservas.matriz[0][CONST_HABITACIONES].equals("SI")
                && Reservas.matriz[0][CONST_COCINA].equals("BUFE")
                && Reservas.matriz[0][CONST_PERSONAS].equals("100")
                && Reservas.matriz[0][CONST_FECHA] != null;

        if (result) {
            System.out.println("Resultado de la prueba testGuardarReservaConDatosCompletos: Ok");
        } else {
            System.out.println("Resultado de la prueba testGuardarReservaConDatosCompletos: No Ok");
        }
    }

    /**
     * Prueba para verificar el guardado de una reserva sin el nombre.
     */
    @Test
    public void testGuardarReservaSinNombre() {
        // Preparación de datos
        reservas.txtNombre.setText("");
        reservas.txtTelefono.setText("123456789");
        reservas.cmbEvento.setSelectedItem("BANQUETE");
        reservas.txtJornadas.setValue(0);
        reservas.chkHabitaciones.setSelected(false);
        reservas.cmbTipoCocina.setSelectedItem("BUFE");
        reservas.txtNumPersonas.setValue(50);
        reservas.cldCalendario.setDate(new java.util.Date());

        // Capturar el mensaje de error
        //reservas.btnGuardarActionPerformed(null);
        reservas.triggerGuardarAction();

        // Verificación
        boolean result = !JOptionPane.getRootFrame().isVisible();

        if (result) {
            System.out.println("Resultado de la prueba testGuardarReservaSinNombre: Ok");
        } else {
            System.out.println("Resultado de la prueba testGuardarReservaSinNombre: No Ok");
        }
    }

    /**
     * Prueba para verificar el borrado de los datos de la pantalla de reserva.
     */
    @Test
    public void testBorrarReserva() {
        // Preparación de datos
        reservas.txtNombre.setText("John Doe");
        reservas.txtTelefono.setText("123456789");
        reservas.cmbEvento.setSelectedItem("BANQUETE");
        reservas.txtJornadas.setValue(2);
        reservas.chkHabitaciones.setSelected(true);
        reservas.cmbTipoCocina.setSelectedItem("BUFE");
        reservas.txtNumPersonas.setValue(100);
        reservas.cldCalendario.setDate(new java.util.Date());

        // Ejecución del método
        reservas.triggerBorrarAction();

        // Verificación
        boolean result = reservas.txtNombre.getText().isEmpty()
                && reservas.txtTelefono.getText().isEmpty()
                && reservas.cmbEvento.getSelectedItem().equals("Selecciona")
                && ((int) reservas.txtJornadas.getValue()) == 0
                && !reservas.chkHabitaciones.isSelected()
                && reservas.cmbTipoCocina.getSelectedItem().equals("Selecciona")
                && ((int) reservas.txtNumPersonas.getValue()) == 0
                && reservas.cldCalendario.getDate() == null;

        if (result) {
            System.out.println("Resultado de la prueba testBorrarReserva: Ok");
        } else {
            System.out.println("Resultado de la prueba testBorrarReserva: No Ok");
        }
    }

    /**
     * Prueba para verificar la selección del tipo de evento como "CONGRESO".
     */
    @Test
    public void testCmbEventoActionPerformed_CongresoSelected() {
        // Preparación de datos
        reservas.cmbEvento.setSelectedItem("CONGRESO");

        // Simulación de evento de cambio de selección
        ActionEvent event = new ActionEvent(reservas.cmbEvento, ActionEvent.ACTION_PERFORMED, "");
        reservas.cmbEvento.getActionListeners()[0].actionPerformed(event);

        // Verificación
        boolean result = reservas.lblJornadas.isEnabled()
                && reservas.txtJornadas.isEnabled()
                && reservas.lblHabitaciones.isEnabled()
                && reservas.chkHabitaciones.isEnabled();
        if (result) {
            System.out.println("Resultado de la prueba testCmbEventoActionPerformed_CongresoSelected: Ok");
        } else {
            System.out.println("Resultado de la prueba testCmbEventoActionPerformed_CongresoSelected: No Ok");
        }
    }

    /**
     * Prueba para verificar la selección de un tipo de evento diferente a
     * "CONGRESO".
     */
    @Test
    public void testCmbEventoActionPerformed_OtherSelected() {
        // Preparación de datos
        reservas.cmbEvento.setSelectedItem("BANQUETE");

        // Simulación de evento de cambio de selección
        ActionEvent event = new ActionEvent(reservas.cmbEvento, ActionEvent.ACTION_PERFORMED, "");
        reservas.cmbEvento.getActionListeners()[0].actionPerformed(event);

        // Verificación
        boolean result = !reservas.lblJornadas.isEnabled()
                && !reservas.txtJornadas.isEnabled()
                && !reservas.lblHabitaciones.isEnabled()
                && !reservas.chkHabitaciones.isEnabled();
        if (result) {
            System.out.println("Resultado de la prueba testCmbEventoActionPerformed_OtherSelected: Ok");
        } else {
            System.out.println("Resultado de la prueba testCmbEventoActionPerformed_OtherSelected: No Ok");
        }
    }
}
