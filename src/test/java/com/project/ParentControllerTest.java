package com.project;

import com.project.model.Parent;
import com.project.service.impl.ParentServiceImpl;
import java.util.Date;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.AutoConfigureWebTestClient;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;



import reactor.core.publisher.Mono;


/* Parent test controller */
@RunWith(SpringRunner.class)
@AutoConfigureWebTestClient
@SpringBootTest
public class ParentControllerTest {
  
  @Autowired private WebTestClient client;

  @Autowired private ParentServiceImpl parentService;

  @Test
  public void create() {
    Parent parent = new Parent("432dsffa22", "Padre", "female",
        new Date(), "DNI", "43434343","famcode1");

    client
    .post()
    .uri("/api/v1.0/")
    .contentType(MediaType.APPLICATION_JSON_UTF8)
    .accept(MediaType.APPLICATION_JSON_UTF8)
    .body(Mono.just(parent), Parent.class)
    .exchange()
    .expectStatus()
    .isCreated()
    .expectHeader()
    .contentType(MediaType.APPLICATION_JSON_UTF8)
      .expectBodyList(Parent.class);
  }
  
  


}
