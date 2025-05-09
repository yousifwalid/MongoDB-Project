package com.example.task.service;

import com.example.task.model.User;
import com.example.task.repository.userRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class userServiceImpl implements userService {

    private final userRepo UserRepo;

    @Override
    public void createUser(User user) {
        user.setTime(new Date());
        UserRepo.save(user);
        logChange("Insert", user.getUserId());
    }

    @Override
    public List<User> getUserData(int userId) {
        return UserRepo.findDataByUserId(userId);
    }

    @Override
    public List<User> getDocuments(Date startDate, Date endDate) {
        log.info("Searching for users between {} and {}", startDate, endDate);
        return UserRepo.findDataByTime(startDate, endDate);
    }

    @Override
    public void deleteUser(int userId) {
        UserRepo.deleteById(userId);
        logChange("Delete", userId);
    }
    private void logChange(String OperationType, int userId) {
        try (FileWriter writer = new FileWriter("log.txt", true)) {
            writer.write("Operation: " + OperationType + ", is performed by user id: " + userId + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
//
//    private void logChange(String OperationType, int userId) {
//        System.out.println("Operation: " + OperationType + ", is performed by userId no. : " + userId);
//    }