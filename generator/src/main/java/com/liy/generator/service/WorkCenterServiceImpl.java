package com.liy.generator.service;

import com.liy.generator.entity.ViewWorkCenterMember;
import com.liy.generator.entity.ViewWorkCenterMemberExample;
import com.liy.generator.mapper.ViewWorkCenterMemberMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class WorkCenterServiceImpl {

    @Autowired
    private ViewWorkCenterMemberMapper workCenterMemberMapper;

    private Map<String, HashSet<String>> map;

    public void findResource() {
        map = new HashMap<>();
        ViewWorkCenterMemberExample example = new ViewWorkCenterMemberExample();
        example.createCriteria().andSiteEqualTo("1002");
        List<ViewWorkCenterMember> list = workCenterMemberMapper.selectByExample(example);

        // 循環所有工作中心
        for (ViewWorkCenterMember work : list) {
            if (work.getWorkCenterOrResourceGbo().contains("WorkCenterBO")) {
                // 若底下是工作中心，遞迴
                run(work.getWorkCenterOrResourceGbo());
            } else {
                // 分類工作中心 : [資源]
                if (map.get(work.getWorkCenter()) == null) {
                    map.put(work.getWorkCenter(), new HashSet<>(Arrays.asList(work.getWorkCenterOrResourceGbo())));
                } else {
                    map.get(work.getWorkCenter()).add(work.getWorkCenterOrResourceGbo());
                }
            }
        }
        map.forEach(( k, v ) -> {
            System.out.println(k + " = " + v);
//            v.forEach(System.out::println);
        });
    }

    public void run( String workCenterBo ) {
        ViewWorkCenterMemberExample example = new ViewWorkCenterMemberExample();
        example.createCriteria().andSiteEqualTo("1002")
                .andWorkCenterEqualTo(workCenterBo.split(",")[1]);
        List<ViewWorkCenterMember> list = workCenterMemberMapper.selectByExample(example);
        // 檢索該工作中心
        for (ViewWorkCenterMember w : list) {
            if (w.getWorkCenterOrResourceGbo().contains("WorkCenterBO")) {
                // 若還有工作中心，遞迴
                run(w.getWorkCenterOrResourceGbo());
            } else {
                // 分類工作中心 : [資源]
                if (map.get(w.getWorkCenter()) == null) {
                    map.put(w.getWorkCenter(), new HashSet<>(Arrays.asList(w.getWorkCenterOrResourceGbo())));
                } else {
                    map.get(w.getWorkCenter()).add(w.getWorkCenterOrResourceGbo());
                }
            }
        }
    }
}
