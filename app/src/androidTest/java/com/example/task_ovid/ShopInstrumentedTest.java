package com.example.task_ovid;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.task_ovid.stats.Monedas;
import com.example.task_ovid.stats.Vida;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ShopInstrumentedTest {

    @Rule
    public ActivityScenarioRule<TiendaBeta> shopRule =
            new ActivityScenarioRule<>(TiendaBeta.class);

    @Before
    public void setUp(){
        Vida.setVidaActual(50);
        Monedas.setMonedasUsuario(1000);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.task_ovid", appContext.getPackageName());
    }

    @Test
    public void PocimaClickTest() {

        //Activamos la función pócima simulando que compramos una pócima
        shopRule.getScenario().onActivity(shop -> shop.pocima(Vida.getVidaActual(), Vida.getMaxVida(), Monedas.getMonedasUsuario()));
        //Comprobamos que resta correctamente las monedas
        assertEquals(900, Monedas.getMonedasUsuario());
    }

    @Test
    public void PocimaSuperClickTest() {
        //Activamos la función pócima super simulando que compramos una pócima
        shopRule.getScenario().onActivity(shop -> shop.pocimasuper(Vida.getVidaActual(),Vida.getMaxVida(),Monedas.getMonedasUsuario()));
        //Comprobamos que resta correctamente las monedas
        assertEquals(700,Monedas.getMonedasUsuario());

    }

}