package com.liy.gradle.infrastructure.util;

import com.liy.gradle.domain.entity.Z_LABEL_PRINTER;

public class SqlUtil {

    public String selectPrint(Z_LABEL_PRINTER zLabelPrinter) {
        StringBuilder sql = new StringBuilder();
        sql.append(" select * from Z_LABEL_PRINTER ");
        sql.append(" where 1 = 1 ");
        if ( zLabelPrinter != null ) {
            if (zLabelPrinter.getRawLabel() != null && zLabelPrinter.getRawLabel() != "") {
                sql.append(" and raw_label = '" + zLabelPrinter.getRawLabel() + "'");
            }
            if (zLabelPrinter.getResource1() != null && zLabelPrinter.getResource1() != "") {
                sql.append(" and resource1 = '" + zLabelPrinter.getResource1() + "'");
            }
            if (zLabelPrinter.getPrinterName() != null && zLabelPrinter.getPrinterName() != "") {
                sql.append(" and printer_name like '%" + zLabelPrinter.getPrinterName() + "%'");
            }
        }
        return sql.toString();
    }
}
