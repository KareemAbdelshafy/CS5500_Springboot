package com.team1.cs5500.bean;

import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDateTime;

@Schema(name="CustomerVisit", description="A model of a customer")
public class CustomerVisit {
  private int CustomerVisitID;
  private String WeatherDescription;
  private String CustomerDescription;
  private String HolidayDescription;
  private LocalDateTime ArrivalTime;
  private int MinuteShopping;
  private int ScenarioID;

  public CustomerVisit() {
  }


  public CustomerVisit(int customerVisitID, String weatherDescription, String customerDescription, String holidayDescription, LocalDateTime arrivalTime, int minuteShopping, int scenarioID) {
    CustomerVisitID = customerVisitID;
    WeatherDescription = weatherDescription;
    CustomerDescription = customerDescription;
    HolidayDescription = holidayDescription;
    ArrivalTime = arrivalTime;
    MinuteShopping = minuteShopping;
    ScenarioID = scenarioID;
  }

  public int getCustomerVisitID() {
    return CustomerVisitID;
  }

  public String getWeatherDescription() {
    return WeatherDescription;
  }

  public String getCustomerDescription() {
    return CustomerDescription;
  }

  public String getHolidayDescription() {
    return HolidayDescription;
  }

  public LocalDateTime getArrivalTime() {
    return ArrivalTime;
  }

  public int getMinuteShopping() {
    return MinuteShopping;
  }

  public int getScenarioID() {
    return ScenarioID;
  }

  public void setCustomerVisitID(int customerVisitID) {
    CustomerVisitID = customerVisitID;
  }

  public void setWeatherDescription(String weatherDescription) {
    WeatherDescription = weatherDescription;
  }

  public void setCustomerDescription(String customerDescription) {
    CustomerDescription = customerDescription;
  }

  public void setHolidayDescription(String holidayDescription) {
    HolidayDescription = holidayDescription;
  }

  public void setArrivalTime(LocalDateTime arrivalTime) {
    ArrivalTime = arrivalTime;
  }

  public void setMinuteShopping(int minuteShopping) {
    MinuteShopping = minuteShopping;
  }

  public void setScenarioID(int scenarioID) {
    ScenarioID = scenarioID;
  }
}
