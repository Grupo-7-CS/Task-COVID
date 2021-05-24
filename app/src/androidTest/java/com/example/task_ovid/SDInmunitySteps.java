package com.example.task_ovid;


import com.example.task_ovid.stats.Resistencia;
import com.example.task_ovid.stats.Vida;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertEquals;

public class SDInmunitySteps {

    @Given("el usuario se ha puesto la segunda dosis de la vacuna \\(gana {int} puntos de inmunidad)")
    public void el_usuario_se_ha_puesto_la_segunda_dosis_de_la_vacuna_gana_puntos_de_inmunidad(int arg0) {
        Vida.activarInmunidad();
    }

    @When("^pulsa el boton de 'olvidarse la mascarilla'$")
    public void pulsa_el_boton_de_olvidarse_la_mascarilla() {
        Vida.decrementarVida();
    }

    @When("^pulsa 4 veces el boton de 'Salir de fiesta'$")
    public void pulsa_4_veces_el_boton_de_salir_de_fiesta() {
        for (int i = 0; i < 4; i++) {
            Vida.decrementarVida();
        }
    }

    @Then("^el usuario sigue teniendo 100 puntos de vida$")
    public void el_usuario_sigue_teniendo_100_puntos_de_vida() {
        assertEquals(100, Vida.getVidaActual());
    }

    @Then("^la vida del usuario se reduce a 55 puntos$")
    public void la_vida_del_usuario_se_reduce_a_55_puntos() {
        assertEquals(55, Vida.getVidaActual());
    }

    @And("^tiene 100 puntos de vida$")
    public void tiene_100_puntos_de_vida() {
        Vida.setVidaActual(100);
    }

    @And("^le quedan 2 puntos de inmunidad.$")
    public void le_quedan_2_puntos_de_inmunidad() {
        assertEquals(2, Vida.getInmunidadActual());
    }

    @And("^tiene 80 puntos de vida$")
    public void tiene_80_puntos_de_vida() {
        Vida.setVidaActual(80);
    }

    @And("^tiene 1 punto de resistencia$")
    public void tiene_1_punto_de_resistencia() {
        Resistencia.setResistenciaActual(1);
    }

    @And("^tiene 0 puntos de inmunidad.$")
    public void tiene_0_puntos_de_inmunidad() throws Throwable {
        assertEquals(0, Vida.getInmunidadActual());
    }

}