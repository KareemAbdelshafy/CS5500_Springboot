package com.team1.cs5500.service.impl;

import com.team1.cs5500.bean.CustomerVisit;
import com.team1.cs5500.bean.Scenario;
import com.team1.cs5500.mapper.ScenarioMapper;
import com.team1.cs5500.service.ScenarioService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScenarioServiceImpl implements ScenarioService {

  @Autowired
  ScenarioMapper scenarioMapper;

  @Override
  public List<Scenario> getAllScenario() {
    List<Scenario> scenarioList = scenarioMapper.selectAllScenario();
    return scenarioList;
  }

  @Override
  public List<CustomerVisit> getCustomerById(int scenarioId, String customerType, String weatherType, String holidayType) {
    List<CustomerVisit> customVisits = scenarioMapper.selectVisitByScenarioId(scenarioId);
    return customerFilter(customVisits, customerType, weatherType, holidayType);
  }

  @Override
  public List<CustomerVisit> getCustomerByDate(int scenarioId, LocalDate date, String customerType, String weatherType, String holidayType) {
    List<CustomerVisit> customVisits = scenarioMapper.selectVisitByDate(scenarioId, date);
    return customerFilter(customVisits, customerType, weatherType, holidayType);
  }

  @Override
  public CustomerVisit getCustomerById(int scenarioId, int customerId) {
    CustomerVisit customVisit = scenarioMapper.selectVisitByCustomerId(scenarioId, customerId);
    return customVisit;
  }

  /*
  * filter by each categories
  * can be done in single traverse
  * */
  //TODO: modify the method to do the filter in single traverse
  private List<CustomerVisit> customerFilter(List<CustomerVisit> customVisits, String customerType, String weatherType, String holidayType) {
    //filter all visit
    if (customerType!= null) {
      customVisits = customVisits.stream().
              filter(customerVisit -> customerVisit.getCustomerDescription().equals(customerType)).
              collect(Collectors.toList());
    }
    if (weatherType!= null) {
      customVisits = customVisits.stream().
              filter(customerVisit -> customerVisit.getWeatherDescription().equals(weatherType)).
              collect(Collectors.toList());
    }
    if (holidayType!= null) {
      customVisits = customVisits.stream().
              filter(customerVisit -> customerVisit.getHolidayDescription().equals(holidayType)).
              collect(Collectors.toList());
    }
    return customVisits;
  }


}
