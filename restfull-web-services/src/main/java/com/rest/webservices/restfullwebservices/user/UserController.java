package com.rest.webservices.restfullwebservices.user;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

@RestController
public class UserController {
	
	private UserDaoService service;
	//constructor injection
	public UserController(UserDaoService service) {
		this.service=service;
		
	}
	
	@GetMapping("/users")
	public List<Users> retrieveAllUsers(){
		return service.findAll();		
	}
	
	@GetMapping("/users/{id}")
	public Users retrieveUserbyId(@PathVariable int id){
		return service.findbyId(id);
	}
	
	@PostMapping("/users")
	public ResponseEntity<Users> createUser(@Valid @RequestBody Users user) {
		service.save(user);
		return ResponseEntity.created(null).build();		
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUser(@PathVariable int id){
		service.deletebyId(id);
	}

}
