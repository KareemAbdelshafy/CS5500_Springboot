package com.team1.cs5500.bdd.stepdefs;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import cucumber.api.java8.En;

public class ScenarioListSteps extends AbstractSteps implements En {

  public ScenarioListSteps() {

    Given("the client wants to retrieve all scenarios", () -> {
      testContext().reset();
    });

    When("the client calls \\/api\\/v{int}\\/scenario", (Integer apiVersion) -> {
      executeGet("/api/v1/scenario");
    });

    Then("the client receives status code of {int}", (Integer statusCode) -> {
      int responseStatus = CONTEXT.getResponse().getStatusCode();
      assertThat("status code is incorrect : ", statusCode, is(responseStatus));
    });
  }

}
