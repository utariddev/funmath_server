package org.utarid.funmath.controller;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.entity.UserEntity;
import org.utarid.funmath.model.ResponseModel;
import org.utarid.funmath.service.UserService;

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
            return new ResponseModel("1", "1", "user could not be saved");
        }
    }
}
