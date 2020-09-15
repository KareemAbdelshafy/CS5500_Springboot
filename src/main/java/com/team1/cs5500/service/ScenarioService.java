package com.team1.cs5500.service;

import com.team1.cs5500.bean.CustomerVisit;
import com.team1.cs5500.bean.Scenario;

import java.time.LocalDate;
import java.util.List;

public interface ScenarioService {

  /*get all scenario from database*/
  List<Scenario> getAllScenario();

  //renamed by getCustomerById
  //List<Scenario> getScenarioById(long scenarioId);
  List<CustomerVisit> getCustomerById(int scenarioId, String customerType, String weatherType, String holidayType);

  //add three optional parameters
  // List<Scenario> getCustomerByDate(int scenarioId, LocalDate date);
  List<CustomerVisit> getCustomerByDate(int scenarioId, LocalDate date, String customerType, String weatherType, String holidayType);

  CustomerVisit getCustomerById(int scenarioIdInt, int customerIdInt);
}
