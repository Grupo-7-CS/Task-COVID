package com.example.task_ovid;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

public class SecondDoseSteps {

    @Given("^the user is level one with 0 experience points$")
    public void the_user_is_level_one_with_0_experience_points() throws Throwable {
        throw new PendingException();
    }

    @Given("^the user is level two with 0 experience points$")
    public void the_user_is_level_two_with_0_experience_points() throws Throwable {
        throw new PendingException();
    }

    @Given("^the user is level dour with 0 experience points$")
    public void the_user_is_level_dour_with_0_experience_points() throws Throwable {
        throw new PendingException();
    }

    @When("^user presses second dose button$")
    public void user_presses_second_dose_button() throws Throwable {
        throw new PendingException();
    }

    @Then("^user's experience increases by 150 and goes up to level 1, remaining at level 2 with 50 experience points\\.$")
    public void users_experience_increases_by_150_and_goes_up_to_level_1_remaining_at_level_2_with_50_experience_points() throws Throwable {
        throw new PendingException();
    }

    @Then("^user's experience increases by 150 and goes up to level 1, remaining at level 3 with 30 experience points\\.$")
    public void users_experience_increases_by_150_and_goes_up_to_level_1_remaining_at_level_3_with_30_experience_points() throws Throwable {
        throw new PendingException();
    }

    @Then("^user's experience increases by 150, but since 160 points are needed to go up to level 5, the user remains at level 4\\.$")
    public void users_experience_increases_by_150_but_since_160_points_are_needed_to_go_up_to_level_5_the_user_remains_at_level_4() throws Throwable {
        throw new PendingException();
    }

}
