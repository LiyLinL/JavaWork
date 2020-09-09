package com.liy.generator.repository;

import com.liy.generator.entity.Sfc;
import com.liy.generator.entity.SfcExample;
import com.liy.generator.mapper.SfcTestMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SfcRepositoryImpl implements SfcRepository {

    @Autowired
    private SfcTestMapper sfcMapper;

    @Override
    public List<Sfc> selectSfc( String site, String shopOrder, int firstRow, int lastRow ) {
        SfcExample example = new SfcExample();
        example.createCriteria().andSiteEqualTo(site)
                .andShopOrderBoEqualTo(shopOrder);
        return sfcMapper.selectByExamplePage(example, firstRow, lastRow);
    }

    @Override
    public int cnt( String site, String shopOrde ) {
        SfcExample example = new SfcExample();
        example.createCriteria().andSiteEqualTo(site)
                .andShopOrderBoEqualTo(shopOrde);
        return sfcMapper.selectByExample(example);
    }
}
