package com.project.service;

import com.project.model.Parent;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParentInterface {

  void create(Parent p);

  Flux<Parent> findAll();

  Flux<Parent> findByFullName(String fullName);

  Flux<Parent> findByDate(String birthdate);

  Mono<Parent> findBynumberDocument(String numberDocument);

  Mono<Parent> findById(String idParent);

  Mono<Parent> save(Parent parent);

  Mono<Void> delete(String idParent);

}
