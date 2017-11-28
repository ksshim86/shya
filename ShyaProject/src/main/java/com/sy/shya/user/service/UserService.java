package com.sy.shya.user.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sy.shya.user.domain.User;
import com.sy.shya.user.repository.UserRepository;

@Service
@Transactional
public class UserService {
    
    @Autowired
    private UserRepository userRepository;
    
    public List<User> getAllUsers( String name ) {
        if ( name == null || name.isEmpty() ) {
            return userRepository.findAll();
        } else {
            return userRepository.findByNameContaining( name );
        }
    }

    public User getUser( String id ) {
        return userRepository.findOne( id );
    }

    public void createUser( User user ) {
        userRepository.save( user );
    }

}
