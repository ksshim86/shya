package com.sy.shya.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sy.shya.user.domain.User;

public interface UserRepository extends JpaRepository<User, String> {
	
}
