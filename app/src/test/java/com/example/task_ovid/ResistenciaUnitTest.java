package com.example.task_ovid;

import com.example.task_ovid.stats.Resistencia;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ResistenciaUnitTest {
    @Test
    public void testInit() {
        //Por defecto el usuario tiene 1 por restencia
        Resistencia.init();
        //Por tanto, el método get debe devolver que el usuario tiene 1 de resistencia
        assertEquals(1, Resistencia.getResistenciaActual(), 0);
    }

    @Test
    public void testSetResistenciaActualGetResistenciaActual() {
        //Se establece que el usuario tiene 0 de resistencia
        Resistencia.setResistenciaActual(0);
        //Por tanto, el método get debe devolver que el usuario tiene 0 de resistencia
        assertEquals(0, Resistencia.getResistenciaActual(), 0);
        //Se establece que el usuario tiene 10 de resistencia
        Resistencia.setResistenciaActual(10);
        //Por tanto, el método get debe devolver que el usuario tiene 10 de resistencia
        assertEquals(10, Resistencia.getResistenciaActual(), 0);
    }
}
