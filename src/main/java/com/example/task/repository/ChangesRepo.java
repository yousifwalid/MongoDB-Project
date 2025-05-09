package com.example.task.repository;

import com.example.task.model.ChangesLogging;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ChangesRepo extends MongoRepository<ChangesLogging, Integer> {
}
