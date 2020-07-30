package com.liy.generator.repository;

import com.liy.generator.entity.Sfc;

import java.util.List;

public interface SfcRepository {

    List<Sfc> selectSfc( String site, String shopOrder, int firstRow, int lastRow );

    int cnt( String site, String shopOrde );
}
