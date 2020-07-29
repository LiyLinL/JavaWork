package com.liy.generator.repository;

import com.liy.generator.entity.Sfc;
import com.liy.generator.entity.SfcExample;
import com.liy.generator.mapper.SfcMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SfcRepositoryImpl implements SfcRepository {

    @Autowired
    private SfcMapper sfcMapper;

    @Override
    public List<Sfc> selectSfc() {
        SfcExample example = new SfcExample();
        return sfcMapper.selectByExample(example);
    }
}
