package com.vegetable.practice.repository;

import com.vegetable.practice.entity.Dog;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DogRepo extends MongoRepository<Dog, UUID> {

    Dog findByName(String name);

}
