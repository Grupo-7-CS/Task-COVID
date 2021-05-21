package com.example.task_ovid;

import android.content.Context;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;

import com.example.task_ovid.stats.Monedas;
import com.example.task_ovid.stats.Vida;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
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

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.task_ovid", appContext.getPackageName());
    }

    @Test
    public void ShopClickTest() {
        //Set up
        Vida.setVidaActual(50);
        Monedas.setMonedasUsuario(1000);

        shopRule.getScenario().onActivity(shop -> shop.pocima(Vida.getVidaActual(),Vida.getMaxVida(),Monedas.getMonedasUsuario()));
        assertEquals(900,Monedas.getMonedasUsuario());

        //Set up
        Vida.setVidaActual(50);

        shopRule.getScenario().onActivity(shop -> shop.pocimasuper(Vida.getVidaActual(),Vida.getMaxVida(),Monedas.getMonedasUsuario()));
        assertEquals(600,Monedas.getMonedasUsuario());

    }

}