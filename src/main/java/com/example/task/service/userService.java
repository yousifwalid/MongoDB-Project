package com.example.task.service;

import com.example.task.model.User;

import java.util.Date;
import java.util.List;

public interface userService {

    void createUser(User user);

    List<User> getUserData(int userId);

    List<User> getDocuments(Date startDate, Date endDate);

    void deleteUser(int userId);
}
