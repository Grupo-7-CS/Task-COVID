package com.example.task_ovid;

import com.example.task_ovid.stats.Nivel;

import org.junit.Test;

import static org.junit.Assert.*;

public class NivelUnitTest {
    @Test
    public void testIncrementarExperiencia() {
        //La experiencia necesaria para subir de nivel es 100
        //Se incrementa la experiencia en 50 por lo que no sube de nivel y debe devolver false
        assertFalse(Nivel.incrementarExperiencia(true));
        //Se incrementa la experiencia en 50 otra vez por lo que sube de nivel y debe devolver true
        assertTrue(Nivel.incrementarExperiencia(true));
        //AL subir de nivel la experiencia máxima ha pasado de 100 a 120 por tanto para subir de nivel ejecuntando el método
        //incrementarExperiencia(false) no deberá subir de nivel hasta la doceava llamada (Cada llamada
        //aumenta en 10 la experiencia actual).
        for (int i = 0; i < 11; i++) {
            assertFalse(Nivel.incrementarExperiencia(false));
        }
        //La doceava llamada debe ser true
        assertTrue(Nivel.incrementarExperiencia(false));
    }
}
