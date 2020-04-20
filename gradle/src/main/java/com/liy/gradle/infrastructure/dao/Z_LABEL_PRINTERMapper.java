package com.liy.gradle.infrastructure.dao;

import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;
import com.liy.gradle.infrastructure.util.SqlUtil;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface Z_LABEL_PRINTERMapper {

    @Select(value = "select * from Z_LABEL_PRINTER")
    @ResultMap("LabelBaseResultMap")
    List<Z_LABEL_PRINTER> selectAll();

    @SelectProvider(type = SqlUtil.class, method = "selectPrint")
    @ResultMap("LabelBaseResultMap")
    List<Z_LABEL_PRINTER> selectPrint(Z_LABEL_PRINTER zLabelPrinterModel);

    @Insert(value = "insert into Z_LABEL_PRINTER values ( " +
            "#{handle}, #{site}, #{rawLabel}, #{resource1}, #{printerName}, #{createUser}, #{createDate} " +
            ")")
    int insert(Z_LABEL_PRINTER zLabelPrinterModel);

    @Update(value = "update Z_LABEL_PRINTER set printer_name = #{printerName} " +
            " where raw_label = #{rawLabel}" +
            " and resource1 = #{resource1}")
    int update(Z_LABEL_PRINTER zLabelPrinterModel);

    @Delete(value = "delete from Z_LABEL_PRINTER" +
            " where raw_label = #{rawLabel} " +
            " and resource1 = #{resource1}")
    int delete(Z_LABEL_PRINTER zLabelPrinterModel);

    @Select("Select * from Z_LABEL_PRINTER" +
            " where raw_label = #{label}" +
            " and resource1 = #{resrc}")
    Z_LABEL_PRINTER check(@Param("label") String label,
                          @Param("resrc") String resrc);
}
