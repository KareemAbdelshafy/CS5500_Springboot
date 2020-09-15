package com.team1.cs5500.mapper;

import com.team1.cs5500.bean.CustomerVisit;
import com.team1.cs5500.bean.Scenario;

import java.time.LocalDate;
import java.util.List;

public interface ScenarioMapper {

  List<Scenario> selectAllScenario();

  List<CustomerVisit> selectVisitByScenarioId(long scenarioId);

  List<CustomerVisit> selectVisitByDate(int scenarioId, LocalDate date);

  CustomerVisit selectVisitByCustomerId(int scenarioId, int customerId);
}
