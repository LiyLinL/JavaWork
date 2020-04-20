package com.liy.gradle.infrastructure.repository.impl;

import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;
import com.liy.gradle.infrastructure.dao.Z_LABEL_PRINTERMapper;
import com.liy.gradle.infrastructure.repository.Z_LABEL_PRINTERRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class Z_LABEL_PRINTERRepositoryImpl implements Z_LABEL_PRINTERRepository {

    @Autowired
    private Z_LABEL_PRINTERMapper zLabelPrinterMapper;

    @Override
    public List<Z_LABEL_PRINTER> selectAll() {
        return zLabelPrinterMapper.selectAll();
    }

}
