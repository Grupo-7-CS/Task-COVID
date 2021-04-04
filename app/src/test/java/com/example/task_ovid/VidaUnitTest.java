package com.example.task_ovid;

import com.example.task_ovid.stats.Resistencia;
import com.example.task_ovid.stats.Vida;

import org.junit.Test;

import static org.junit.Assert.*;

public class VidaUnitTest {
    @Test
    public void testGetMaxVida() {
        //La vida máxima es una constante con valor 100
        //Por tanto, el método getMaxVida() debe devolver 100
        assertEquals(100, Vida.getMaxVida());
    }

    @Test
    public void testGetVidaActual() {
        //Se establece que la vida actual es 0
        Vida.setVidaActual(0);
        //Por tanto el método getVidaActual() debe devolver 0
        assertEquals(0, Vida.getVidaActual());
    }

    @Test
    public void testSetVidaActual() {
        //Se establece que la vida actual es 50
        Vida.setVidaActual(50);
        //Por tanto el método getVidaActual() debe devolver 50
        assertEquals(50, Vida.getVidaActual());
        //Se establece que la vida actual es -50, pero como la vida no puede ser negativa este método
        //pondrá la vida a 0
        Vida.setVidaActual(-50);
        //Por tanto el método getVidaActual() debe devolver 0
        assertEquals(0, Vida.getVidaActual());
    }

    @Test
    public void testDecrementarVida() {
        //Se establece que la vida actual es 100
        Vida.setVidaActual(100);
        //Por tanto el método getVidaActual() debe devolver 100
        assertEquals(100, Vida.getVidaActual());
        //Se establece la resistencia a 1 para el test
        Resistencia.setResistenciaActual(1);
        //Se llama a decrementarVida que disminuye la vida en 25 con la resistencia a 1
        Vida.decrementarVida();
        //Por tanto el método getVidaActual() debe devolver 75
        assertEquals(75, Vida.getVidaActual());
    }

}
