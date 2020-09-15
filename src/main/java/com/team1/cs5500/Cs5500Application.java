package com.team1.cs5500;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.team1.cs5500.mapper")
public class Cs5500Application {

  public static void main(String[] args) {
    SpringApplication.run(Cs5500Application.class, args);
  }

}
