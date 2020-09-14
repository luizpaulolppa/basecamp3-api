package com.basecamp3api.controller;

import com.basecamp3api.dto.UserAuthDTO;
import com.basecamp3api.dto.UserDTO;
import com.basecamp3api.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService userService;

    @PostMapping
    public ResponseEntity<UserAuthDTO> authUser(@RequestBody UserDTO user) {
        return new ResponseEntity<UserAuthDTO>(userService.authUser(user), HttpStatus.CREATED);
    }

}
