package com.liy.gradle.infrastructure.controller;

import com.alibaba.fastjson.JSONObject;
import com.liy.gradle.application.service.Z_LABEL_PRINTERService;
import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Z_LABEL_PRINTERController {

    @Autowired
    private Z_LABEL_PRINTERService zLabelPrinterRepository;

    @GetMapping(value = "/LabelPrinter")
    public List<Z_LABEL_PRINTER> findAll() {
        return zLabelPrinterRepository.selectAll();
    }

    @PostMapping(value = "/LabelPrinter")
    public JSONObject findLabel(@RequestBody(required = false) Z_LABEL_PRINTER zLabelPrinter) {
        return zLabelPrinterRepository.selectPrint(zLabelPrinter);
    }

    @PutMapping(value = "/LabelPrinter")
    public int insert(@RequestBody Z_LABEL_PRINTER zLabelPrinter) {
        return zLabelPrinterRepository.insert(zLabelPrinter);
    }

    @PatchMapping
    public int update(@RequestBody Z_LABEL_PRINTER zLabelPrinter) {
        return zLabelPrinterRepository.update(zLabelPrinter);
    }

    @DeleteMapping(value = "/LabelPrinter")
    public int delete(@RequestBody Z_LABEL_PRINTER zLabelPrinter) {
        return zLabelPrinterRepository.delete(zLabelPrinter);
    }
}
