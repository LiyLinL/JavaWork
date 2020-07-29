package com.liy.generator.mapper;

import com.liy.generator.entity.Sfc;
import com.liy.generator.entity.SfcExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SfcMapper {
    long countByExample(SfcExample example);

    int deleteByExample(SfcExample example);

    int insert(Sfc record);

    int insertSelective(Sfc record);

    List<Sfc> selectByExample(SfcExample example);

    int updateByExampleSelective(@Param("record") Sfc record, @Param("example") SfcExample example);

    int updateByExample(@Param("record") Sfc record, @Param("example") SfcExample example);
}