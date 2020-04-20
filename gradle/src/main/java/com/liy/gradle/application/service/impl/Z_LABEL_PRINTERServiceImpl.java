package com.liy.gradle.application.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.liy.gradle.application.service.Z_LABEL_PRINTERService;
import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;
import com.liy.gradle.infrastructure.dao.Z_LABEL_PRINTERMapper;
import com.liy.gradle.infrastructure.dao.repository.Z_LABEL_PRINTERRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import static com.liy.gradle.infrastructure.util.DateUtil.*;

@Service
public class Z_LABEL_PRINTERServiceImpl implements Z_LABEL_PRINTERService {

    @Autowired
    private Z_LABEL_PRINTERRepository zLabelPrinterRepository;

    @Autowired
    Z_LABEL_PRINTERMapper z_label_printerMapper;

    @Override
    public List<Z_LABEL_PRINTER> selectAll() {
        return z_label_printerMapper.selectAll();
    }

    @Override
    public JSONObject selectPrint(Z_LABEL_PRINTER z_label_printer) {
        JSONObject jso = new JSONObject();
        JSONArray jsonArray = new JSONArray();

        List<Z_LABEL_PRINTER> list = zLabelPrinterRepository.selectAll();//z_label_printerMapper.selectPrint(z_label_printer);
        AtomicInteger i = new AtomicInteger(0);
        list.forEach( z ->{
            JSONObject js = new JSONObject();
            js.put("seq", i.incrementAndGet());
            js.put("rawLabel", z.getRawLabel());
            js.put("desc", "Description");
            js.put("type", "R");
            js.put("printerName", z.getPrinterName());
            js.put("resource1", z.getResource1());
            js.put("createUser", z.getCreateUser());
            js.put("createDate", DatetoString(z.getCreateDate()));
            jsonArray.add(js);
        });
        jso.put("list", jsonArray);

        return jso;
    }

    @Override
    public int insert(Z_LABEL_PRINTER z_label_printer) {
        if ( z_label_printer != null ) {
            Z_LABEL_PRINTER zL = check(z_label_printer.getRawLabel(), z_label_printer.getResource1());
            if ( zL != null ) {
                return 0;
            }
        }

        return z_label_printerMapper.insert(z_label_printer);
    }

    @Override
    public int update(Z_LABEL_PRINTER z_label_printer) {
        return z_label_printerMapper.update(z_label_printer);
    }

    @Override
    public int delete(Z_LABEL_PRINTER z_label_printer) {
        return z_label_printerMapper.delete(z_label_printer);
    }

    @Override
    public Z_LABEL_PRINTER check(String label, String resrc) {
        return z_label_printerMapper.check(label, resrc);
    }
}
