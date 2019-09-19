package com.project.service;

import com.project.model.Parent;
import java.util.Date;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParentInterface {

  public Flux<Parent> findAll();
  
  public Flux<Parent> findByDate(String birthdate);

  public Flux<Parent> findByBirthdateBetween(Date birthdate, Date birthdate1);

  public Mono<Parent> findByFullName(String fullName);

  public Mono<Parent> findBynumberDocument(String numberDocument);
  
  public Mono<Parent> findById(String idParent);

  public Mono<Parent> save(Parent parent);

  public Mono<Void> delete(String idParent);

}
