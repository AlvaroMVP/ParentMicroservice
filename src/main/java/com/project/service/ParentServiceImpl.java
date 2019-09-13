package com.project.service;

import com.project.model.Parent;
import com.project.repository.ParentRepository;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParentServiceImpl implements ParentInterface {

  @Autowired
  ParentRepository parentRepository;

  @Override
  public void create(Parent p) {
    parentRepository.save(p).subscribe();
  }

  @Override
  public Flux<Parent> findAll() {
    return parentRepository.findAll();
  }

  @Override
  public Flux<Parent> findByFullName(String fullName) {
    return parentRepository.findByFullName(fullName);
  }

  @Override
  public Mono<Parent> findBynumberDocument(String numberDocument) {
    return parentRepository.findBynumberDocument(numberDocument);
  }

  @Override
  public Mono<Parent> findById(String idParent) {
    return parentRepository.findById(idParent);
  }

  @Override
  public Mono<Parent> save(Parent parent) {
    // TODO Auto-generated method stub
    return parentRepository.save(parent);
  }

  @Override
  public Mono<Void> delete(String idParent) {
    return parentRepository.deleteById(idParent);
  }

  @Override
  public Flux<Parent> findByBirthdateBetween(Date birthdate, Date birthdate1) {
    return parentRepository.findByBirthdateBetween(birthdate, birthdate1);
  }

}
