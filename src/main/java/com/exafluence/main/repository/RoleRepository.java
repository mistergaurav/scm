package com.exafluence.main.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.exafluence.main.model.Role;

public interface RoleRepository extends MongoRepository<Role, String> {
Role findByRole(String role);

}
