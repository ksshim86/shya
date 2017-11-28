package com.sy.shya.user.rest;

import java.util.List;

import javax.ws.rs.QueryParam;

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
import com.sy.shya.user.service.UserService;

@CrossOrigin
@RestController
@RequestMapping( "/users" )
public class UserRest {
	
	@Autowired
	private UserService userService;

	@GetMapping
	public ResponseEntity<List<User>> getAllUsers( @QueryParam( "name" ) String name ) {
		List<User> users = userService.getAllUsers( name );
		return new ResponseEntity<>( users, HttpStatus.OK );
	}

	@GetMapping( "/{id}" )
	public ResponseEntity<User> getUser( @PathVariable String id ) {
		User user = userService.getUser( id );
		return new ResponseEntity<>( user, HttpStatus.OK );
	}

	@PostMapping
	public ResponseEntity<Void> createUser( @RequestBody User user ) {
		userService.createUser( user);
		return new ResponseEntity<>( HttpStatus.OK );
	}
}
