package com.team1.cs5500.bdd;

import com.team1.cs5500.Cs5500Application;
import org.junit.Before;
import org.springframework.boot.test.context.SpringBootContextLoader;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = WebEnvironment.DEFINED_PORT)
@ContextConfiguration(classes = Cs5500Application.class, loader = SpringBootContextLoader.class)
public class Cs5500ApplicationContextConfiguration {

  @Before
  public void setUp() {

  }
}