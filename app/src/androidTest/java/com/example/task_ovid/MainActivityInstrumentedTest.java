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

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.task_ovid", appContext.getPackageName());
    }

    @Test
    public void ItemClickTest() {
        //Set up
        Monedas.setMonedasUsuario(0);
        Nivel.setNivelActual(1);
        Nivel.setMaxExperiencia(100);
        Nivel.setExperiencia(0);

        activityRule.getScenario().onActivity(main -> main.updateTask("*** Ponerse la segunda dosis 0",0));
        assertEquals(100,Monedas.getMonedasUsuario());
        assertEquals(50,Nivel.getExperiencia());
        assertEquals(2,Nivel.getNivel());

        activityRule.getScenario().onActivity(main -> main.updateTask("** Ponerse la vacuna 0",1));
        assertEquals(200,Monedas.getMonedasUsuario());
        assertEquals(30, Nivel.getExperiencia());
        assertEquals(3,Nivel.getNivel());


        //El usuario tiene inmunidad completa, inmunidad == 3
        assertEquals(3,Vida.getInmunidadActual());
        activityRule.getScenario().onActivity(main -> main.updateTask("- Frotarme los ojos o llevarme las manos a la boca en la calle 0",10));
        assertEquals(200,Monedas.getMonedasUsuario());
        assertEquals(30,Nivel.getExperiencia());
        //Como el usuario es inmune por la haberse puesto la segunda dosis no pierde vida aunque
        //haga una mala acción. Nota: la inmunidad te protege de tres malas acciones ya que se va
        //gastando
        assertEquals(100, Vida.getVidaActual());
        //El usuario a perdido un punto de inmunidad, inmunidad == 2
        assertEquals(2, Vida.getInmunidadActual());

        activityRule.getScenario().onActivity(main -> main.updateTask("- Estar con mis amigos sin mascarilla 0",11));
        assertEquals(200, Monedas.getMonedasUsuario());
        assertEquals(30, Nivel.getExperiencia());
        assertEquals(100, Vida.getVidaActual());
        assertEquals(1, Vida.getInmunidadActual());

        activityRule.getScenario().close();
    }
}