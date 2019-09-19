package com.project.controller;

import com.project.model.Parent;
import com.project.service.ParentInterface;
import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequestMapping("api/v1.0")
@RestController
public class ParentController {

  @Autowired private ParentInterface parentService;
  
  /**.
   * method to create
   */
  @PostMapping
  public Mono<ResponseEntity<Map<String, Object>>> create(
      @Valid @RequestBody Mono<Parent> studentMono) {
    Map<String, Object> reply = new HashMap<String, Object>();
    return studentMono.flatMap(parent -> {
      if (parent.getBirthdate() == null) {
        parent.setBirthdate(new Date());
      }
      return parentService.save(parent).map(
        p -> {
          reply.put("parent", p);
          reply.put("message", "Parent created successfully");
          reply.put("dateTime", new Date());
          return ResponseEntity.created(URI.create("/api/v1.0".concat(p.getIdParent())))
            .contentType(MediaType.APPLICATION_JSON_UTF8).body(reply);
        });
    });
  }
  
  /**.
   * method to list students
   */
  @GetMapping("/parent")
  public Mono<ResponseEntity<Flux<Parent>>> findAll() {
    return Mono.just(ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8)
    .body(parentService.findAll()));
  }

  /**.
   * method to search students by id
   */
  @GetMapping("/parent/{idParent}")
  public Mono<ResponseEntity<Parent>>  findById(@PathVariable String idParent) {
    return parentService.findById(idParent).map(p -> ResponseEntity.ok()
    .contentType(MediaType.APPLICATION_JSON_UTF8)
    .body(p)).defaultIfEmpty(ResponseEntity.notFound().build());
  }

  /**.
   * method to search by document number
   */
  @GetMapping("numberDocument/{numberDocument}")
  public Mono<ResponseEntity<Parent>> findBynumberDocument(@PathVariable String numberDocument) {
    return parentService.findBynumberDocument(numberDocument)
    .map(p -> ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
    .defaultIfEmpty(ResponseEntity.notFound().build());
  }
 
  /**.
   * method to search by full name
   */
  @GetMapping("fullName/{fullName}")
  public Mono<ResponseEntity<Parent>> findFullName(@PathVariable String fullName) {
    return parentService.findByFullName(fullName).map(p -> ResponseEntity.ok()
    .contentType(MediaType.APPLICATION_JSON_UTF8).body(p))
    .defaultIfEmpty(ResponseEntity.notFound().build());
  }
 
  
  /**.
   * method to update a parent
   */
  @PutMapping("/{id}")
  public Mono<ResponseEntity<Parent>> save(@RequestBody Parent parent,
      @PathVariable String idParent) {
    return parentService.findById(idParent).flatMap(
      s -> {
        s.setFullName(parent.getFullName());
        s.setGender(parent.getGender());
        s.setBirthdate(parent.getBirthdate());
        s.setTypeDocument(parent.getTypeDocument());
        s.setNumberDocument(parent.getNumberDocument());
    
        return parentService.save(s);
      }).map(
          s -> ResponseEntity.created(
         URI.create("/api/v1.0".concat(s.getIdParent())))
          .contentType(MediaType.APPLICATION_JSON_UTF8).body(s)).defaultIfEmpty(ResponseEntity
          .notFound().build());
  }
  
  /**.
   * method to delete a student by id
   */
  @DeleteMapping("/{idParent}")
  public void delete(@PathVariable("idParent") String idParent) {
    parentService.delete(idParent).subscribe();
  }
  
  /**.
   * method to search by dates
   */
  @GetMapping("parent/date/{birthdate}/{birthdate1}")
  public Flux<Parent> findByBirthdateBetween(@PathVariable("birthdate")
      @DateTimeFormat(iso = ISO.DATE) Date birthdate,@PathVariable("birthdate1")
      @DateTimeFormat(iso = ISO.DATE) Date birthdate1) {
    return parentService.findByBirthdateBetween(birthdate, birthdate1);
  }
  
}
