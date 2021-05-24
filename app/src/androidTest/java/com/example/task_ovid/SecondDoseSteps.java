package com.example.task_ovid;

import com.example.task_ovid.stats.Nivel;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class SecondDoseSteps {

    @Given("^el usuario es nivel 1$")
    public void el_usuario_es_nivel_1() {
        Nivel.setNivelActual(1);
        //Para que realmente sea de nivel 1 es necesario
        //establecer la experiencia máxima a 100
        Nivel.setMaxExperiencia(100);
    }

    @Given("^el usuario es nivel 4$")
    public void el_usuario_es_nivel_4() {
        Nivel.setNivelActual(4);
        //Para que realmente sea de nivel 4 es necesario
        //establecer la experiencia máxima a 160
        Nivel.setMaxExperiencia(160);
    }

    @When("^pulsa el boton de ponerse la segunda dosis$")
    public void pulsa_el_boton_de_ponerse_la_segunda_dosis() {
        Nivel.incrementarExperiencia(false, false, true);
    }

    @Then("^el usuario sube a nivel 2$")
    public void el_usuario_sube_a_nivel_2() {
        assertEquals(2, Nivel.getNivel());
    }

    @Then("^el usuario permanece a nivel 4$")
    public void el_usuario_permanece_a_nivel_4() {
        assertEquals(4, Nivel.getNivel());
        ;
    }

    @And("^tiene 0 puntos de experiencia$")
    public void tiene_0_puntos_de_experiencia() {
        Nivel.setExperiencia(0);
    }

    @And("^se queda con 50 puntos de experiencia.$")
    public void se_queda_con_50_puntos_de_experiencia() {
        assertEquals(50, Nivel.getExperiencia());
    }

    @And("^tiene 150 puntos de experiencia$")
    public void tiene_150_puntos_de_experiencia() {
        assertEquals(150, Nivel.getExperiencia());
    }
}
