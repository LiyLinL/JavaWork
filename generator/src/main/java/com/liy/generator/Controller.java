package com.liy.generator;

import com.liy.generator.entity.Sfc;
import com.liy.generator.service.SfcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private SfcService sfcService;

    @GetMapping("sfc")
    public List<Sfc> selectSfc() {
        return sfcService.selectSfc();
    }
}
