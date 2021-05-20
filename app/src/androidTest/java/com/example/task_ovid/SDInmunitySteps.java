package com.example.task_ovid;


import com.example.task_ovid.stats.Resistencia;
import com.example.task_ovid.stats.Vida;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class SDInmunitySteps {

    @Given("^The user has already taken the second dose, so he/she has 3 points of immunity.$")
    public void the_user_has_already_taken_the_second_dose() throws Throwable {
        Vida.activarInmunidad();
    }

    @And("^The user life is 100 points$")
    public void the_user_life_is_100_points() throws Throwable {
        Vida.setVidaActual(100);
    }

    @And("^The user life is 80 points$")
    public void the_user_life_is_80_points() throws Throwable {
        Vida.setVidaActual(80);
    }

    @And("^The user resistence is 1$")
    public void the_user_resistence_is_1() throws Throwable {
        Resistencia.setResistenciaActual(1);
    }

    @When("^user presses the button 'olvidarse la mascarilla'$")
    public void user_presses_the_button_olvidarse_la_mascarilla() throws Throwable {
        Vida.decrementarVida();
    }

    @When("^user presses the button 'Salir de fiesta' four times$")
    public void user_presses_the_button_salir_de_fiesta_four_times() throws Throwable {
        for (int i = 0; i < 4; i++) {
            Vida.decrementarVida();
        }
    }

    @Then("^The user still has 100 health points and 2 immunity points left.$")
    public void user_life_is_still_100_points() throws Throwable {
        assertEquals(100,Vida.getVidaActual());
    }

    @Then("^The user's life is reduced to 55 points and he is no longer immune.$")
    public void user_life_is_reduced_to_55_points() throws Throwable {
        assertEquals(55,Vida.getVidaActual());
    }

}