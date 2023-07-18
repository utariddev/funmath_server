package org.utarid.funmath.controller;

import jakarta.validation.constraints.Null;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.utarid.funmath.dto.ResultDTO;
import org.utarid.funmath.dto.UserDTO;
import org.utarid.funmath.model.ResponseModel;
import org.utarid.funmath.model.SetResultResponseModel;
import org.utarid.funmath.service.FunMathService;

import java.util.List;

@RestController
@RequestMapping("/funmath/v1")
public class FunMathController {

    private final FunMathService funMathService;

    public FunMathController(FunMathService funMathService) {
        this.funMathService = funMathService;
    }

    @GetMapping("/version")
    public String getVersion() {
        return "1";
    }

    @PostMapping(value = "/saveUser")
    public ResponseModel<Object> saveUser(@Validated @RequestBody UserDTO user) {
        if (funMathService.saveUser(user)) {
            return new ResponseModel<>();
        } else {
            return new ResponseModel<>("1", List.of("user could not be saved"));
        }
    }

    @PostMapping(value = "/getUser")
    public ResponseModel<Object> getUser(@Validated @RequestBody UserDTO user) {
        if (funMathService.getUser(user)) {
            return new ResponseModel<>();
        } else {
            return new ResponseModel<>("2", List.of("user could not be found"));
        }
    }

    @PostMapping(value = "/saveResult")
    public ResponseModel<SetResultResponseModel> saveResult(@Validated @RequestBody ResultDTO result) {
        return funMathService.saveResult(result);
    }
}
