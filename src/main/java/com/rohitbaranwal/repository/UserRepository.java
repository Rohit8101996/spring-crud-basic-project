package com.rohitbaranwal.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rohitbaranwal.model.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

}
