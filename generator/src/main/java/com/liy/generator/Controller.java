package com.liy.generator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    @GetMapping("test")
    public String test() {
        Utils.ThrowException("error.msg", null);
        return "Hello";
    }
}
