package com.liy.gradle.infrastructure.controller;

import com.liy.gradle.infrastructure.script.ScriptRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GradleController {

    @Autowired
    private ScriptRun scriptRun;

    @RequestMapping(value = "/gradle")
    public String index(@RequestParam(value = "index", defaultValue = "Hello") String i) {
        System.out.println(i);
        scriptRun.executeSqlFile();
        return "index";
    }

}
