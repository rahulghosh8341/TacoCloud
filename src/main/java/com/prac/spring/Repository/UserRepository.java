package com.prac.spring.Repository;

import org.springframework.data.repository.CrudRepository;

import com.prac.spring.Model.User;


public interface UserRepository extends CrudRepository<User, Long> {
    User findByUsername(String username);
}