package com.exafluence.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exafluence.main.model.User;




public interface UserRepository extends MongoRepository<User, String> {
User findByEmail(String email);

}
