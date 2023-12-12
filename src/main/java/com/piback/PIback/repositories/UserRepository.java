package com.piback.PIback.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.repository.CrudRepository;


import java.util.Optional;

import com.piback.PIback.models.User;

public interface UserRepository extends JpaRepository<User,Long> {
    
    Optional<User> findByUsername(String username);
}
