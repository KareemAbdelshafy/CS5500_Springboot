package com.team1.cs5500.bdd.stepdefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java8.En;

public class SpecificScenarioSteps extends AbstractSteps implements En {

  public SpecificScenarioSteps() {
    Given("the client wants to retrieve a single scenario", () -> {
      testContext().reset();
    });

    When("the client calls \\/api\\/v{int}\\/scenario\\/{int}", (Integer version, Integer scenarioId) -> {
      executeGet("/api/v" + version + "/scenario/" + scenarioId);
    });

    When("the client calls \\/api\\/v{int}\\/scenario\\/{string}", (Integer version, String scenarioId) -> {
      executeGet("/api/v" + version + "/scenario/" + scenarioId);
    });

  }

}
