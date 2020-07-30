package com.liy.generator;

import com.liy.generator.entity.Sfc;
import com.liy.generator.service.SfcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private SfcService sfcService;

    @GetMapping("sfc")
    public List<Sfc> selectSfc( @RequestParam("site") String site,
                                @RequestParam("order") String order,
                                @RequestParam("first") int first,
                                @RequestParam("last") int last ) {
        return sfcService.selectSfc(site, order, first, last);
    }

    @GetMapping("sfc/cnt")
    public int cntSfc( @RequestParam("site") String site,
                       @RequestParam("order") String order ) {
        return sfcService.cnt(site, order);
    }
}
