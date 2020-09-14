package com.basecamp3api.controller;

import com.basecamp3api.dto.UserDTO;
import com.basecamp3api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO user) {
        return new ResponseEntity<UserDTO>(userService.createNewUser(user), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<String>> getUser() {
        return new ResponseEntity<List<String>>(Arrays.asList("1", "2", "3"), HttpStatus.OK);
    }
}
