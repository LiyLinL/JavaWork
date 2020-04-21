package com.liy.gradle.infrastructure.controller;

import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;
import com.liy.gradle.infrastructure.script.ScriptRun;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Controller
public class GradleController {

    @Autowired
    private ScriptRun scriptRun;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/gradle")
    public String index(@RequestParam(value = "index", defaultValue = "Hello") String i) {
        System.out.println(i);
        return "index";
    }

    @ResponseBody
    @GetMapping("/test")
    public String test() {

        Z_LABEL_PRINTER[] list = restTemplate.getForObject("http://localhost:90/LabelPrinter", Z_LABEL_PRINTER[].class);
        List<Z_LABEL_PRINTER> list1 = Arrays.asList(list);
        list1.forEach( z -> {
            System.out.println(z.getHandle());
        });

        return "1";
    }

}
