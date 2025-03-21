package com.springandjavascript.spjs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springandjavascript.spjs.dao.Repo;
import com.springandjavascript.spjs.entity.User;

@RestController
@RequestMapping("/api/users")
@CrossOrigin(origins="*")
public class Controller {
	@Autowired
	Repo repo;
	@PostMapping
	public ResponseEntity<User> addUser(@RequestBody User user){
		System.out.println("POST");
		repo.save(user);
		return new ResponseEntity<User>(user,HttpStatus.ACCEPTED);
	}
	@GetMapping
	public ResponseEntity<List<User>> getUsers(){
		System.out.println("GET");
		return new ResponseEntity<List<User>>(repo.findAll(),HttpStatus.CREATED);
	}
}
