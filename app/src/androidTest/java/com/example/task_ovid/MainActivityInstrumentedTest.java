package com.example.task_ovid;

import android.content.Context;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;

import androidx.test.espresso.ViewAction;
import androidx.test.espresso.action.CoordinatesProvider;
import androidx.test.espresso.action.GeneralClickAction;
import androidx.test.espresso.action.GeneralLocation;
import androidx.test.espresso.action.GeneralSwipeAction;
import androidx.test.espresso.action.Press;
import androidx.test.espresso.action.Swipe;
import androidx.test.espresso.action.Tap;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import com.example.task_ovid.stats.Monedas;
import com.example.task_ovid.stats.Nivel;
import com.example.task_ovid.stats.Vida;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class MainActivityInstrumentedTest {

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Before
    public void setUp() {
        //Inicializamos valores
        Monedas.setMonedasUsuario(0);
        Nivel.setNivelActual(1);
        Nivel.setMaxExperiencia(100);
        Nivel.setExperiencia(0);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.task_ovid", appContext.getPackageName());
    }

    @Test
    public void ItemSecondDoseTest() {

        //Comprobamos el botón de ponerse la segunda dosis
        activityRule.getScenario().onActivity(main -> main.updateTask("*** Ponerse la segunda dosis 0", 0));
        //Comprobamos que las monedas son 100, hemos ganado 50 de experiencia y subido
        //a nivel 2
        assertEquals(100, Monedas.getMonedasUsuario());
        assertEquals(50, Nivel.getExperiencia());
        assertEquals(2, Nivel.getNivel());
    }


    @Test
    public void ItemVaccineTest() {
        //Comprobamos el botón de ponerse la segunda dosis
        activityRule.getScenario().onActivity(main -> main.updateTask("** Ponerse la vacuna 0", 1));
        //Comprobamos que las monedas son 100 y hemos subido
        //a nivel 2
        assertEquals(100, Monedas.getMonedasUsuario());
        assertEquals(2, Nivel.getNivel());

    }


    @Test
    public void ItemHandsOnEyesTest() {
        //Comprobamos el botón de frotarse los ojos en la calle
        activityRule.getScenario().onActivity(main -> main.updateTask("- Frotarme los ojos o llevarme las manos a la boca en la calle 0", 10));
        //Comprobamos que no hemos ganado monedas y hemos perdido vida
        assertEquals(0, Monedas.getMonedasUsuario());
        assertEquals(75, Vida.getVidaActual());

    }

    @Test
    public void ItemNoFacemaskTest() {

        //Comprobamos el botón de estar sin mascarilla
        activityRule.getScenario().onActivity(main -> main.updateTask("- Estar con mis amigos sin mascarilla 0",11));
        //Comprobamos que no hemos ganado monedas y hemos perdido vida
        assertEquals(0, Monedas.getMonedasUsuario());
        assertEquals(75, Vida.getVidaActual());
    }
}