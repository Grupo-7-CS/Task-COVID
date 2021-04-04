package com.example.task_ovid;

import com.example.task_ovid.stats.Monedas;

import org.junit.Test;

import static org.junit.Assert.*;

public class MonedasUnitTest {
    @Test
    public void testGetMonedasUsuario() {
        //Se establece que el usuario tiene 0 monedas
        Monedas.setMonedasUsuario(0);
        //Por tanto, el método get debe devolver que el usuario tiene 0 monedas
        assertEquals(0, Monedas.getMonedasUsuario());
    }

    @Test
    public void testSetMonedasUsuario() {
        //Se establece que el usuario tiene 100 monedas
        Monedas.setMonedasUsuario(100);
        //El usuario por tanto debe tener 100 monedas
        assertEquals(100, Monedas.getMonedasUsuario());
        //Se establece que el usuario tiene -100 monedas
        Monedas.setMonedasUsuario(-100);
        //Como el usuario no puede tener monedas negativas debe devolver 0
        assertEquals(0, Monedas.getMonedasUsuario());
    }

    @Test
    public void testIncrementarMonedas() {
        //Se establece que el usuario tiene 0 monedas
        Monedas.setMonedasUsuario(0);
        //Por tanto, el método get debe devolver que el usuario tiene 0 monedas
        assertEquals(0, Monedas.getMonedasUsuario());
        //Se incrementa en 100 las monedas del usuario
        Monedas.incrementarMonedas(100);
        //Por tanto el usuario debe tener 0 + 100 = 100 monedas
        assertEquals(100, Monedas.getMonedasUsuario());
        //Se incrementa en 50 las monedas del usuario
        Monedas.incrementarMonedas(50);
        //Por tanto el usuario debe tener 100 + 50 = 150 monedas
        assertEquals(150, Monedas.getMonedasUsuario());
    }
}
