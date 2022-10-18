package com.springRest.controller;

import com.springRest.model.User;
import com.springRest.service.RoleService;
import com.springRest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(RoleService roleService, UserService userService) {
        this.userService = userService;
    }

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public ResponseEntity<User> getUserByUsername (Principal principal) { //перенеси в изер контроллер
        User user = userService.findByUsername(principal.getName());
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
