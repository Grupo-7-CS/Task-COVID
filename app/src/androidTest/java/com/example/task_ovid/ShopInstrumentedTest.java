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
        Monedas.setMonedasUsuario(1000);

        shopRule.getScenario().recreate();

        onView(withId(R.id.pocion1)).perform(click());
        assertEquals(Monedas.getMonedasUsuario(),900);

        shopRule.getScenario().recreate();

        onView(withId(R.id.pocion2)).perform(click());
        assertEquals(Monedas.getMonedasUsuario(),600);

    }

}