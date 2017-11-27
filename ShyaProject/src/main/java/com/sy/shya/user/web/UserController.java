package com.sy.shya.user.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.shya.user.domain.User;
import com.sy.shya.user.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping( "/api" )
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping( "/users" )
	public ResponseEntity<List<User>> findAll() {
		List<User> users = userRepository.findAll();
		
		return new ResponseEntity<>( users, HttpStatus.OK );
	}

	@GetMapping( "/users/{id}" )
	public ResponseEntity<User> findOne( @PathVariable String id ) {
		User user = userRepository.findOne( id );

		return new ResponseEntity<>( user, HttpStatus.OK );
	}

	@GetMapping( "/users/name/{name}" )
	public ResponseEntity<List<User>> findByNameContaining( @PathVariable String name ) {
		List<User> users = userRepository.findByNameContaining( name );
		
		return new ResponseEntity<>( users, HttpStatus.OK );
	}

	@PostMapping( "/users" )
	public ResponseEntity<Void> save( @RequestBody User user ) {
		userRepository.save( user );

		return new ResponseEntity<>( HttpStatus.OK );
	}
}
