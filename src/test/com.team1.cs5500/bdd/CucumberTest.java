package com.team1.cs5500.bdd;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "classpath:features")
public class CucumberTest extends Cs5500ApplicationContextConfiguration {

  public CucumberTest() {
    int t = 10;
  }
}