/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.habanahotel;

import java.awt.Color;
import java.awt.Font;
import org.junit.jupiter.api.Test;

/**
 * Clase de prueba para la clase Listado. Contiene métodos de prueba para
 * verificar el funcionamiento de la clase Listado.
 *
 * @author José Carlos Lucientes Casaos
 */
public class ListadoTest {

    private Listado listado;
    /**
     * Prueba la funcionalidad de carga de reservas en el listado.
     */
    @Test
    public void testCargarReservas() {
        // Preparación de datos de prueba
        Reservas.matriz[0][Reservas.CONST_NOMBRE] = "John Doe";
        Reservas.matriz[0][Reservas.CONST_TELEFONO] = "123456789";
        Reservas.matriz[0][Reservas.CONST_TIPOEVENTO] = "CONGRESO";
        Reservas.matriz[0][Reservas.CONST_JORNADAS] = "2";
        Reservas.matriz[0][Reservas.CONST_HABITACIONES] = "true";
        Reservas.matriz[0][Reservas.CONST_FECHA] = "2024-05-20";
        Reservas.matriz[0][Reservas.CONST_COCINA] = "BUFE";
        Reservas.matriz[0][Reservas.CONST_PERSONAS] = "100";

        // Método a probar
        listado = new Listado();

        // Ejecución del método
        listado.cargarReservas();

        // Verificación
        boolean result
                = listado.tblListado.getValueAt(0, Reservas.CONST_NOMBRE).equals("John Doe")
                && listado.tblListado.getValueAt(0, Reservas.CONST_TELEFONO).equals("123456789")
                && listado.tblListado.getValueAt(0, Reservas.CONST_TIPOEVENTO).equals("CONGRESO")
                && listado.tblListado.getValueAt(0, Reservas.CONST_JORNADAS).equals("2")
                && listado.tblListado.getValueAt(0, Reservas.CONST_HABITACIONES).equals("true")
                && listado.tblListado.getValueAt(0, Reservas.CONST_FECHA).equals("2024-05-20")
                && listado.tblListado.getValueAt(0, Reservas.CONST_COCINA).equals("BUFE")
                && listado.tblListado.getValueAt(0, Reservas.CONST_PERSONAS).equals("100");

        if (result) {
            System.out.println("Resultado de la prueba testCargarReservas: Ok");
        } else {
            System.out.println("Resultado de la prueba testCargarReservas: No Ok");
        }
    }

    /**
     * Prueba la funcionalidad de cambiar la cabecera de la tabla.
     */
    @Test
    public void testCambiarCabeceraTabla() {
        // Método a probar
        Listado listado = new Listado();
        listado.cambiarCabeceraTabla();

        // Verificación
        boolean result = listado.tblListado.getTableHeader().getFont().getFontName().equals("Arial Rounded MT Bold")
                && listado.tblListado.getTableHeader().getFont().getStyle() == Font.BOLD
                && listado.tblListado.getTableHeader().getFont().getSize() == 14;

        if (result) {
            System.out.println("Resultado de la prueba testCambiarCabeceraTabla: Ok");
        } else {
            System.out.println("Resultado de la prueba testCambiarCabeceraTabla: No Ok");
        }
    }

    /**
     * Prueba la funcionalidad de cambiar el estilo de la tabla.
     */
    @Test
    public void testCambiarEstiloTabla() {
        // Método a probar
        Listado listado = new Listado();

        // Simulación de presionar el botón varias veces
        listado.cambiarEstiloTabla();
        Font font1 = listado.tblListado.getTableHeader().getFont();
        Color headerColor1 = listado.tblListado.getTableHeader().getBackground();
        Color rowColor1 = listado.tblListado.getBackground();

        listado.cambiarEstiloTabla();
        Font font2 = listado.tblListado.getTableHeader().getFont();
        Color headerColor2 = listado.tblListado.getTableHeader().getBackground();
        Color rowColor2 = listado.tblListado.getBackground();

        listado.cambiarEstiloTabla();
        Font font3 = listado.tblListado.getTableHeader().getFont();
        Color headerColor3 = listado.tblListado.getTableHeader().getBackground();
        Color rowColor3 = listado.tblListado.getBackground();

        // Verificación
        boolean result1 = font1.equals(new Font("Arial Rounded MT Bold", Font.BOLD, 14))
                && headerColor1.equals(Color.LIGHT_GRAY)
                && rowColor1.equals(Color.WHITE);

        boolean result2 = font2.equals(new Font("Verdana", Font.ITALIC, 12))
                && headerColor2.equals(Color.DARK_GRAY)
                && rowColor2.equals(Color.LIGHT_GRAY);

        boolean result3 = font3.equals(new Font("SansSerif", Font.PLAIN, 16))
                && headerColor3.equals(Color.BLUE)
                && rowColor3.equals(Color.CYAN);

        if (result1 && result2 && result3) {
            System.out.println("Resultado de la prueba testCambiarEstiloTabla: Ok");
        } else {
            System.out.println("Resultado de la prueba testCambiarEstiloTabla: No Ok");
        }
    }

}