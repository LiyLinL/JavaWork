package com.liy.generator.mapper;

import com.liy.generator.entity.Sfc;
import com.liy.generator.entity.SfcExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SfcMapper {

    int selectByExample( SfcExample example );

    List<Sfc> selectByExamplePage( @Param("example") SfcExample example, @Param("firstRow") int firstRow, @Param("lastRow") int lastRow );
}