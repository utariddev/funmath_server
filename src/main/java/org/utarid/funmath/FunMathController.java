package org.utarid.funmath;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/funmath/v1")
public class FunMathController {

    @GetMapping("/version")
    public String getVersion() {
        return "1";
    }
}
