package com.project.repository;

import com.project.model.Parent;

import java.util.Date;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ParentRepository extends ReactiveMongoRepository<Parent, String> {

  Flux<Parent> findByFullName(String fullName);

  Mono<Parent> findBynumberDocument(String numberDocument);

  Flux<Parent> findByBirthdateBetween(Date birthdate,Date birthdate1);
}
