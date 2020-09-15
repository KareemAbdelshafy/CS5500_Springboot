package com.team1.cs5500.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Schema(name="Scenario", description="Scenario Parameters")
public class Scenario {
  private int scenarioID;
  private int trafficFactorID;
  private LocalDate startDate;
  private LocalDate endDate;
  private String scenarioDescription;
  private int numberOfRecords;

  public Scenario() {
  }

  public Scenario(int scenarioID, int trafficFactorID, LocalDate startDate, LocalDate endDate, String scenarioDescription, int numberOfRecords) {
    this.scenarioID = scenarioID;
    this.trafficFactorID = trafficFactorID;
    this.startDate = startDate;
    this.endDate = endDate;
    this.scenarioDescription = scenarioDescription;
    this.numberOfRecords = numberOfRecords;
  }

  public int getScenarioID() {
    return scenarioID;
  }

  public int getTrafficFactorID() {
    return trafficFactorID;
  }

  public LocalDate getStartDate() {
    return startDate;
  }

  public LocalDate getEndDate() {
    return endDate;
  }

  public String getScenarioDescription() {
    return scenarioDescription;
  }

  public void setScenarioID(int scenarioID) {
    this.scenarioID = scenarioID;
  }

  public void setTrafficFactorID(int trafficFactorID) {
    this.trafficFactorID = trafficFactorID;
  }

  public void setStartDate(LocalDate startDate) {
    this.startDate = startDate;
  }

  public void setEndDate(LocalDate endDate) {
    this.endDate = endDate;
  }

  public void setScenarioDescription(String scenarioDescription) {
    this.scenarioDescription = scenarioDescription;
  }

  public int getNumberOfRecords() {
    return numberOfRecords;
  }

  public void setNumberOfRecords(int numberOfRecords) {
    this.numberOfRecords = numberOfRecords;
  }
}
