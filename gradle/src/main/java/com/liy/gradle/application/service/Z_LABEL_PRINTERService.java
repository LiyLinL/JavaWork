package com.liy.gradle.application.service;

import com.alibaba.fastjson.JSONObject;
import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;

import java.util.List;

public interface Z_LABEL_PRINTERService {

    List<Z_LABEL_PRINTER> selectAll();

    JSONObject selectPrint(Z_LABEL_PRINTER z_label_printer);

    int insert(Z_LABEL_PRINTER z_label_printer);

    int update(Z_LABEL_PRINTER z_label_printer);

    int delete(Z_LABEL_PRINTER z_label_printer);

    Z_LABEL_PRINTER check(String label, String resrc);
}
