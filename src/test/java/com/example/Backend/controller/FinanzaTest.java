/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.example.Backend.controller;

import com.example.Backend.dao.FinanzasService;
import com.example.Backend.model.Finanza;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

class FinanzaTest {

    @InjectMocks
    FinanzasController finanzasController;

    @Mock
    FinanzasService finanzasService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testListarId() {
        // Crear una finanza de prueba con una fecha específica
        LocalDate fecha = LocalDate.of(2023, 5, 15);
        Finanza finanza = new Finanza(1, "Donación de invitados", 100.0f, fecha, "Ingreso");

        // Simular el servicio para devolver la finanza de prueba
        when(finanzasService.listarId(anyInt())).thenReturn(finanza);

        // Llamar al método en el controlador
        Finanza resultado = finanzasController.listarId(1);

        // Verificar que el servicio fue llamado con el ID correcto
        verify(finanzasService, times(1)).listarId(1);

        // Verificar que se obtuvo la finanza esperada
        assertEquals(finanza, resultado);
    }

    @Test
    void testEditar() {
        // Crear una finanza de prueba con una fecha específica
        LocalDate fecha = LocalDate.of(2023, 5, 15);
        Finanza finanza = new Finanza(1, "Donación de invitados", 100.0f, fecha, "Ingreso");

        // Crear una finanza modificada
        Finanza finanzaModificada = new Finanza(1, "Donación de invitados", 200.0f, fecha, "Egreso");

        // Simular el servicio para devolver la finanza modificada
        when(finanzasService.edit(finanzaModificada)).thenReturn(finanzaModificada);

        // Llamar al método en el controlador
        Finanza resultado = finanzasController.editar(finanzaModificada, 1);

        // Verificar que el servicio fue llamado con la finanza modificada
        verify(finanzasService, times(1)).edit(finanzaModificada);

        // Verificar que se obtuvo la finanza modificada
        assertEquals(finanzaModificada, resultado);
    }

    @Test
    void testDelete() {
        // Crear una finanza de prueba con una fecha específica
        LocalDate fecha = LocalDate.of(2023, 5, 15);
        Finanza finanza = new Finanza(1, "Donación de invitados", 100.0f, fecha, "Ingreso");

        // Simular el servicio para devolver la finanza eliminada
        when(finanzasService.delete(anyInt())).thenReturn(finanza);

        // Llamar al método en el controlador
        Finanza resultado = finanzasController.delete(1);

        // Verificar que el servicio fue llamado con el ID correcto
        verify(finanzasService, times(1)).delete(1);

        // Verificar que se obtuvo la finanza eliminada
        assertEquals(finanza, resultado);
    }
}
