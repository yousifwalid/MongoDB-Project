package com.example.task.repository;

import com.example.task.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface userRepo extends MongoRepository<User, Integer> {
    List<User> findDataByUserId(int userId);

    @Query("{'time': { $gte: ?0, $lte: ?1 }}")
    List<User> findDataByTime(Date startDate, Date endDate);
}
