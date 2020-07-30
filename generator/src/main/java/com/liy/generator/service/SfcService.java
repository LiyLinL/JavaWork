package com.liy.generator.service;

import com.liy.generator.entity.Sfc;

import java.util.List;

public interface SfcService {

    List<Sfc> selectSfc( String site, String shopOrder, int firstRow, int lastRow );

    int cnt( String site, String order );
}
