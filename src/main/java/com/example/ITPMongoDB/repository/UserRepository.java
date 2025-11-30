package com.example.ITPMongoDB.repository;

import com.example.ITPMongoDB.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}
