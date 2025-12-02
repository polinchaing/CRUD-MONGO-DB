package com.example.ITPMongoDB.repository;

import com.example.ITPMongoDB.domain.User;
import com.example.ITPMongoDB.filter.FilterableRepository;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserRepository extends MongoRepository<User, String>,
        FilterableRepository<User>
{

    // $options: "i": Makes the regex case-insensitive (i = ignore case).
    @Query("{name:  {$regex: ?0,$options: 'i'}}")
    List<User> filterByName(String name);

    @Query("{$or: [{city: ?0},{age: {$lt: ?1}}]}")
    List<User> filter(String city, Integer age);

    @Query("{name: {$regex: '^?0',$options: 'i'}}")
    List<User> filterByNameStartingWith(String prefix);


}
