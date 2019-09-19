package com.project.service.impl;

import com.project.model.Parent;
import com.project.repository.ParentRepository;
import com.project.service.ParentInterface;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ParentServiceImpl implements ParentInterface {


  public ParentRepository parentRepository;

  @Override
  public Flux<Parent> findAll() {
    return parentRepository.findAll();
  }

  @Override
  public Mono<Parent> findByFullName(String fullName) {
    return parentRepository.findByFullName(fullName);
  }
  
  @Override
  public Flux<Parent> findByDate(String birthdate) {
    return null;
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
