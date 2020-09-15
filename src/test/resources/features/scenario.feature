Feature: the list of scenarios can be retrieved

  Scenario: client wants to retrieve scenarios
    Given the client wants to retrieve all scenarios
    When the client calls /api/v1/scenario
    Then the client receives status code of 200

  Scenario: client wants to retrieve specific scenario
    Given the client wants to retrieve a single scenario
    When the client calls /api/v1/scenario/1
    Then the client receives status code of 200

  Scenario: client wants to retrieve scenario that doesn't exist
      Given the client wants to retrieve a single scenario
      When the client calls /api/v1/scenario/3
      Then the client receives status code of 202

  Scenario: client wants to retrieve scenario but specifies an illegal parameter
      Given the client wants to retrieve a single scenario
      When the client calls /api/v1/scenario/"bad"
      Then the client receives status code of 400