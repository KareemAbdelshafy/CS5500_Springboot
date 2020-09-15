package com.team1.cs5500.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import com.team1.cs5500.bean.CustomerVisit;
import com.team1.cs5500.bean.Scenario;
import com.team1.cs5500.service.ScenarioService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/v1")
@RestController
public class ScenarioController {

  private static class CustomerVisitList extends ArrayList<CustomerVisit> {

  }

  private static class ObjectList extends ArrayList<Object> {

  }

  @Autowired
  ScenarioService scenarioService;

  @RequestMapping(value = "scenario", method = GET)
  public List<Scenario> getAllScenario() {
    List<Scenario> scenarioList = scenarioService.getAllScenario();
    return scenarioList;
  }

  @RequestMapping(value = "scenario/{scenarioId}", method = GET)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "request accepted, scenario returned", content = @Content(schema = @Schema(implementation = CustomerVisitList.class))),
      @ApiResponse(responseCode = "202", description = "request accepted, no scenario available to return", content = @Content(schema = @Schema(implementation = ObjectList.class, maxLength = 0))),
      @ApiResponse(responseCode = "400", description = "request not accepted, invalid input", content = @Content(schema = @Schema(implementation = String.class)))
  })
  public ResponseEntity<?> getScenarioById(
      @Parameter(name = "scenarioId", required = true, example = "1", schema = @Schema(implementation = Integer.class))
      @PathVariable String scenarioId
      ,
      @Parameter(name = "customerType", required = false, example = "Senior", schema = @Schema(implementation = String.class))
          String customerType
      ,
      @Parameter(name = "weatherType", required = false, example = "Unknown", schema = @Schema(implementation = String.class))
          String weatherType
      ,
      @Parameter(name = "holidayType", required = false, example = "Holiday", schema = @Schema(implementation = String.class))
          String holidayType) {

    try {
      int intScenarioId = Integer.valueOf(scenarioId);
      List<CustomerVisit> customerVisitList = scenarioService
          .getCustomerById(intScenarioId, customerType, weatherType, holidayType);

      if (customerVisitList.size() > 0) {
        return new ResponseEntity<>(customerVisitList, HttpStatus.OK);
      }
      return new ResponseEntity<>(customerVisitList, HttpStatus.ACCEPTED);
    } catch (NumberFormatException e) {
      return new ResponseEntity<>("Scenario ID must be integer.", HttpStatus.BAD_REQUEST);
    }
  }


  @RequestMapping(value = "scenario/{scenarioId}/{date}", method = GET)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "request accepted, scenario returned", content = @Content(schema = @Schema(implementation = CustomerVisitList.class))),
      @ApiResponse(responseCode = "202", description = "request accepted, no scenario available to return", content = @Content(schema = @Schema(implementation = ObjectList.class, maxLength = 0))),
      @ApiResponse(responseCode = "400", description = "request not accepted, invalid input", content = @Content(schema = @Schema(implementation = String.class)))
  })
  public ResponseEntity<?> getCustomerByDate(
      @Parameter(name = "scenarioId", required = true, example = "1", schema = @Schema(implementation = Integer.class))
      @PathVariable String scenarioId,
      @Parameter(name = "date", required = true, example = "2020-05-23", schema = @Schema(implementation = String.class))
      @PathVariable String date
      ,
      @Parameter(name = "customerType", required = false, example = "Senior", schema = @Schema(implementation = String.class))
          String customerType
      ,
      @Parameter(name = "weatherType", required = false, example = "Unknown", schema = @Schema(implementation = String.class))
          String weatherType
      ,
      @Parameter(name = "holidayType", required = false, example = "Holiday", schema = @Schema(implementation = String.class))
          String holidayType) {

    try {
      int scenarioIdInt = Integer.valueOf(scenarioId);
      LocalDate localDate = LocalDate.parse(date);

      List<CustomerVisit> customerList = customerList = scenarioService
          .getCustomerByDate(scenarioIdInt, localDate, customerType,
              weatherType, holidayType);

      if (customerList.size() > 0) {
        return new ResponseEntity<>(customerList, HttpStatus.OK);
      }
      return new ResponseEntity<>(customerList, HttpStatus.ACCEPTED);
    } catch (NumberFormatException e) {
      return new ResponseEntity<>("Scenario ID must be integer", HttpStatus.BAD_REQUEST);
    } catch (DateTimeParseException pe) {
      return new ResponseEntity<>("Date must be in format yyyy-MM-dd", HttpStatus.BAD_REQUEST);
    }
  }

  @RequestMapping(value = "scenario/{scenarioId}/customers/{customerId}", method = GET)
  @ApiResponses(value = {
      @ApiResponse(responseCode = "200", description = "request accepted, scenario returned", content = @Content(schema = @Schema(implementation = CustomerVisit.class))),
      @ApiResponse(responseCode = "202", description = "request accepted, no scenario available to return", content = @Content(schema = @Schema(implementation = ObjectList.class, maxLength = 0))),
      @ApiResponse(responseCode = "400", description = "request not accepted, invalid input", content = @Content(schema = @Schema(implementation = String.class)))
  })
  public ResponseEntity<?> getCustomerByCustomerId(
      @Parameter(name = "scenarioId", required = true, example = "1", schema = @Schema(implementation = Integer.class))
      @PathVariable String scenarioId,
      @Parameter(name = "customerId", required = true, example = "801", schema = @Schema(implementation = Integer.class))
      @PathVariable String customerId) {

    try {
      int scenarioIdInt = Integer.valueOf(scenarioId);
      int customerIdInt = Integer.valueOf(customerId);

      CustomerVisit customer = scenarioService
          .getCustomerById(scenarioIdInt, customerIdInt);

      return new ResponseEntity<>(customer, HttpStatus.OK);
    } catch (NumberFormatException e) {
      return new ResponseEntity<>("Scenario ID and Customer ID must be integers", HttpStatus.BAD_REQUEST);
    }
  }


}
