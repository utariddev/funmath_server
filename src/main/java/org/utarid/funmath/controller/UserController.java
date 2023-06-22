package org.utarid.funmath.controller;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.model.ResponseModel;
import org.utarid.funmath.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/funmath/v1/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/saveUser")
    public ResponseModel saveUser(@Validated @RequestBody UserDTO user) {
        if (userService.saveUser(user)) {
            return new ResponseModel();
        } else {
            return new ResponseModel("1", List.of("user could not be saved"));
        }
    }

    @PostMapping(value = "/getUser")
    public ResponseModel getUser(@Validated @RequestBody UserDTO user) {
        if (userService.getUser(user)) {
            return new ResponseModel();
        } else {
            return new ResponseModel("1", List.of("user could not be found"));
        }
    }
}
