package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import springfox.documentation.swagger2.annotations.EnableSwagger2WebFlux;

@SpringBootApplication
@EnableSwagger2WebFlux
@EnableMongoRepositories ("com.project.repository")
public class ProyectBootCampParentsApplication {

  public static void main(String[] args) {
    SpringApplication.run(ProyectBootCampParentsApplication.class, args);
  }

}
