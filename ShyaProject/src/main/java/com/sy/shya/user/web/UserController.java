package com.sy.shya.user.web;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sy.shya.user.domain.User;
import com.sy.shya.user.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping( "/api/user" )
public class UserController {
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping( "/users" )
	public ResponseEntity<List<User>> getAllUsers() {
//		List<User> users = userRepository.findAll();
		List<User> users = new ArrayList<User>();
		User user1 = new User( "ksshim", "심규승", "1234" );
		User user2 = new User( "yangji", "양지윤", "9999" );
		
		users.add( user1 );
		users.add( user2 );
		
		return new ResponseEntity<>( users, HttpStatus.OK );
	}
}
