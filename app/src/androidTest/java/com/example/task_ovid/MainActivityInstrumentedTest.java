package com.example.task_ovid;

import android.content.Context;
import android.view.InputDevice;
import android.view.MotionEvent;
import android.view.View;

import androidx.lifecycle.Lifecycle;
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
import androidx.test.rule.ActivityTestRule;

import com.example.task_ovid.stats.Monedas;
import com.example.task_ovid.stats.Nivel;
import com.example.task_ovid.stats.Vida;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
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
        onView(withId(R.id.lista)).perform(clickXY(150,150));
        assertEquals(Monedas.getMonedasUsuario(),100);
        assertEquals(Nivel.getExperiencia(),50);
        assertEquals(Nivel.getNivel(),2);

        onView(withId(R.id.lista)).perform(clickXY(250,250)).check(matches(isDisplayed()));
        assertEquals(Monedas.getMonedasUsuario(),200);
        assertEquals(Nivel.getExperiencia(),30);
        assertEquals(Nivel.getNivel(),3);

        onView(withId(R.id.lista)).perform(swipeUp());

        onView(withId(R.id.lista)).perform(clickXY(750,750)).check(matches(isDisplayed()));
        assertEquals(Monedas.getMonedasUsuario(),200);
        assertEquals(Nivel.getExperiencia(),30);
        int vida = Vida.getVidaActual();
        assertEquals(Vida.getVidaActual(),75);

        onView(withId(R.id.lista)).perform(clickXY(950,950)).check(matches(isDisplayed()));
        assertEquals(Monedas.getMonedasUsuario(),200);
        assertEquals(Nivel.getExperiencia(),30);
        assertEquals(Vida.getVidaActual(),50);

        activityRule.getScenario().close();
    }

    public static ViewAction clickXY(final int x, final int y){
        return new GeneralClickAction(
                Tap.SINGLE,
                new CoordinatesProvider() {
                    @Override
                    public float[] calculateCoordinates(View view) {

                        final int[] screenPos = new int[2];
                        view.getLocationOnScreen(screenPos);

                        final float screenX = screenPos[0] + x;
                        final float screenY = screenPos[1] + y;
                        float[] coordinates = {screenX, screenY};

                        return coordinates;
                    }
                },
                Press.FINGER,
                InputDevice.SOURCE_MOUSE,
                MotionEvent.BUTTON_PRIMARY);
    }

    public static ViewAction swipeUp() {
        return new GeneralSwipeAction(Swipe.FAST, GeneralLocation.BOTTOM_CENTER,
                GeneralLocation.TOP_CENTER, Press.FINGER);
    }
}