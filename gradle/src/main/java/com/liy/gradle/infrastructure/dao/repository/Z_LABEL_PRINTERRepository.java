package com.liy.gradle.infrastructure.dao.repository;

import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;

import java.util.List;

public interface Z_LABEL_PRINTERRepository {

    List<Z_LABEL_PRINTER> selectAll();
}
