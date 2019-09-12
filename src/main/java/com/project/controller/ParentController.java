package com.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.model.Parent;
import com.project.service.ParentInterface;
import com.project.service.ParentServiceImpl;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class ParentController {
	
	@Autowired
	private ParentInterface parentInterface;
	
	@GetMapping("/parent")
	public Flux<Parent> findAll(){
		return parentInterface.findAll();
	}
	
	@GetMapping("/parent/{id}")
	public Mono<Parent> getParent(@PathVariable String idParent) {
		return parentInterface.findById(idParent);
	}
	

	@GetMapping("parent/numberDocument")
	public Mono<Parent> findByDocument(@RequestParam("number") String numberDocument){
		return parentInterface.findBynumberDocument(numberDocument);
	}
	
	
	 @GetMapping("parent/fullName")
	    public Flux<Parent> findFullName(@RequestParam("filter") String fullName) {
	        return parentInterface.findByFullName(fullName);
	    }
	 
	 @PostMapping("/parent")
	 	public void create(@RequestBody Parent parent) {
		 parentInterface.create(parent);
	 }
	 
	 @PutMapping("/parent")
	 	public Mono<Parent> save(@RequestBody Parent parent){
		 	return parentInterface.save(parent);
	 }
	 
	 @DeleteMapping("/parent/{id}")
	 	public void delete(@PathVariable ("id") String idParent) {
		 	parentInterface.delete(idParent).subscribe();
		  };
}
