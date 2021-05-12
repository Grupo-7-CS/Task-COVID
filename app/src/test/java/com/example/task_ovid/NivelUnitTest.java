package com.example.task_ovid;

import com.example.task_ovid.stats.Nivel;

import org.junit.Test;

import static org.junit.Assert.*;

public class NivelUnitTest {
   @Test
    public void testIncrementarExperiencia() {
        //Se establece que el usuario tiene nivel 1 y 0 experiencia
        Nivel.setNivelActual(1);
        Nivel.setMaxExperiencia(100);
        Nivel.setExperiencia(0);
        //La experiencia necesaria para subir de nivel es 100
        //Se incrementa la experiencia en 50 por lo que no sube de nivel y debe devolver false
        assertFalse(Nivel.incrementarExperiencia(true,false,false));
        //Se incrementa la experiencia en 50 otra vez por lo que sube de nivel y debe devolver true
        assertTrue(Nivel.incrementarExperiencia(true,false,false));
        //AL subir de nivel la experiencia máxima ha pasado de 100 a 120 por tanto para subir de nivel ejecuntando el método
        //incrementarExperiencia(false) no deberá subir de nivel hasta la doceava llamada (Cada llamada
        //aumenta en 10 la experiencia actual).
        for (int i = 0; i < 11; i++) {
            assertFalse(Nivel.incrementarExperiencia(false,false,false));
        }
        //La doceava llamada debe ser true
        assertTrue(Nivel.incrementarExperiencia(false,false,false));
    }

    @Test
    public void testPonerVacuna(){
        //Given: El usuario es nivel 0 y tiene 0 experiencia
        //Se establece la experiencia del usuario a 0
        Nivel.setExperiencia(0);
        Nivel.setMaxExperiencia(100);
        //Se establece que el nivel del usuario es 0
        Nivel.setNivelActual(0);
        //When: EL usuario pulsa en el botón "Ponerse la vacuna"
        boolean subidaDeNivel=Nivel.incrementarExperiencia(false,true,false);
        //Then: La experiencia del usuario aumenta en 100 y sube de nivel
        assertTrue(subidaDeNivel);
    }

    @Test
    public void testPonerVacunaNoSubirNivel(){
        //Given: El usuario es nivel 2 y tiene 0 experiencia
        //Se establece que el nivel del usuario es 2
        Nivel.setNivelActual(2);
        Nivel.setMaxExperiencia(120);
        //Se establece que la experiencia del usuario es 0
        Nivel.setExperiencia(0);
        //When: EL usuario pulsa en el botón "Ponerse la vacuna"
        boolean subidaDeNivel=Nivel.incrementarExperiencia(false,true,false);
        //Then: La experiencia del usuario aumenta en 100, pero como necesita 120 para
        //subir al nivel 3 el usuario sigue en nivel 2 y el método debe devolver false
        assertFalse(subidaDeNivel);
    }
}
