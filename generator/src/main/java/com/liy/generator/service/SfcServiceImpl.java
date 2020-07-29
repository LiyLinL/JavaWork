package com.liy.generator.service;

import com.liy.generator.entity.Sfc;
import com.liy.generator.repository.SfcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SfcServiceImpl implements SfcService {

    @Autowired
    private SfcRepository sfcRepository;

    @Override
    public List<Sfc> selectSfc() {
        return sfcRepository.selectSfc();
    }
}
