package com.lcwork.multimall.wx.service;

import com.lcwork.multimall.db.domain.generate.MultimallRegion;
import com.lcwork.multimall.db.service.MultimallRegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author zhy
 * @date 2019-01-17 23:07
 **/
@Component
public class GetRegionService {

    private static List<MultimallRegion> litemallRegions;
    @Autowired
    private MultimallRegionService regionService;

    protected List<MultimallRegion> getMultimallRegions() {
        if (litemallRegions == null) {
            createRegion();
        }
        return litemallRegions;
    }

    private synchronized void createRegion() {
        if (litemallRegions == null) {
            litemallRegions = regionService.getAll();
        }
    }
}
