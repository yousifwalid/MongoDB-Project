package com.example.task.controller;

import com.example.task.model.User;
import com.example.task.service.userServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class userController {

    private final userServiceImpl userService;

    @Operation(summary = "Create User",
            description = "This method is used to create the user",
            responses = {@ApiResponse(responseCode = "201", description = "User created"),
                    @ApiResponse(responseCode = "500", description = "Creation failure")})
    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.createUser(user);
    }

    @Operation(summary = "Get User Data",
            description = "This method is used to get the data that the user created by his id.",
            responses = {@ApiResponse(responseCode = "200", description = "Successfully returned user data"),
                    @ApiResponse(responseCode = "404", description = "User not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping("/search/{userId}")
    public List<User> getUserData(@PathVariable int userId) {
        return userService.getUserData(userId);
    }

    @Operation(summary = "Get User Data by time",
            description = "This method is used to get the data that the user created between two dates.",
            responses = {@ApiResponse(responseCode = "200", description = "Successfully returned user data"),
                    @ApiResponse(responseCode = "404", description = "User not found"),
                    @ApiResponse(responseCode = "500", description = "Internal server error")})
    @GetMapping("/searchByDate")
    public List<User> getData(@RequestParam("startDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startDate,
                              @RequestParam("endDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date endDate) {

        return userService.getDocuments(startDate, endDate);
    }

    @Operation(summary = "Delete User",
            description = "This method is used to delete the user by Id",
            responses = {@ApiResponse(responseCode = "204", description = "User deleted"),
                    @ApiResponse(responseCode = "404", description = "User not found"),
                    @ApiResponse(responseCode = "500", description = "Deletion failure")})
    @DeleteMapping("/delete/{userId}")
    public void deleteUser(@PathVariable int userId) {
        userService.deleteUser(userId);
    }
}