package com.example.demo.controller;

import com.example.demo.DTO.UserDto;
import com.example.demo.Domain.UserModel;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody UserDto userDTO) {
        UserModel user = userService.registerUser(userDTO.getUserPhoneNumber());
        UserDto responseDTO = new UserDto(user.getId(), user.getUserPhoneNumber());
        return ResponseEntity.ok(responseDTO);
    }

    @GetMapping("/{phoneNumber}")
    public ResponseEntity<UserDto> getUserByPhoneNumber(@PathVariable String phoneNumber) {
        UserModel user = userService.getUserByPhoneNumber(phoneNumber);
        UserDto userDTO = new UserDto(user.getId(), user.getUserPhoneNumber());
        return ResponseEntity.ok(userDTO);
    }

    @PostMapping("/{userId}/books/{bookId}/borrow")
    public ResponseEntity<String> borrowBook(@PathVariable Character userId, @PathVariable String bookId) {
        boolean success = userService.borrowBook(userId, bookId);
        if (success) {
            return ResponseEntity.ok("Book borrowed successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to borrow book");
        }
    }

    @PostMapping("/{userId}/books/{bookId}/return")
    public ResponseEntity<String> returnBook(@PathVariable Character userId, @PathVariable String bookId) {
        boolean success = userService.returnBook(userId, bookId);
        if (success) {
            return ResponseEntity.ok("Book returned successfully");
        } else {
            return ResponseEntity.badRequest().body("Failed to return book");
        }
    }
}