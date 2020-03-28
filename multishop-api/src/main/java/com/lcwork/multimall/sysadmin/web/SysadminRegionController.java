package com.lcwork.multimall.sysadmin.web;

import com.lcwork.multimall.core.util.ResponseUtil;
import com.lcwork.multimall.db.domain.generate.MultimallRegion;
import com.lcwork.multimall.db.service.MultimallRegionService;
import com.lcwork.multimall.sysadmin.vo.RegionVo;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/sysadmin/region")
@Validated
public class SysadminRegionController {
    private final Log logger = LogFactory.getLog(SysadminRegionController.class);

    @Autowired
    private MultimallRegionService regionService;

    @GetMapping("/clist")
    public Object clist(@NotNull Integer id) {
        List<MultimallRegion> regionList = regionService.queryByPid(id);
        return ResponseUtil.okList(regionList);
    }

    @GetMapping("/list")
    public Object list() {
        List<RegionVo> regionVoList = new ArrayList<>();

        List<MultimallRegion> litemallRegions = regionService.getAll();
        Map<Byte, List<MultimallRegion>> collect = litemallRegions.stream().collect(Collectors.groupingBy(MultimallRegion::getType));
        byte provinceType = 1;
        List<MultimallRegion> provinceList = collect.get(provinceType);
        byte cityType = 2;
        List<MultimallRegion> city = collect.get(cityType);
        Map<Integer, List<MultimallRegion>> cityListMap = city.stream().collect(Collectors.groupingBy(MultimallRegion::getPid));
        byte areaType = 3;
        List<MultimallRegion> areas = collect.get(areaType);
        Map<Integer, List<MultimallRegion>> areaListMap = areas.stream().collect(Collectors.groupingBy(MultimallRegion::getPid));

        for (MultimallRegion province : provinceList) {
            RegionVo provinceVO = new RegionVo();
            provinceVO.setId(province.getId());
            provinceVO.setName(province.getName());
            provinceVO.setCode(province.getCode());
            provinceVO.setType(province.getType());

            List<MultimallRegion> cityList = cityListMap.get(province.getId());
            List<RegionVo> cityVOList = new ArrayList<>();
            for (MultimallRegion cityVo : cityList) {
                RegionVo cityVO = new RegionVo();
                cityVO.setId(cityVo.getId());
                cityVO.setName(cityVo.getName());
                cityVO.setCode(cityVo.getCode());
                cityVO.setType(cityVo.getType());

                List<MultimallRegion> areaList = areaListMap.get(cityVo.getId());
                List<RegionVo> areaVOList = new ArrayList<>();
                for (MultimallRegion area : areaList) {
                    RegionVo areaVO = new RegionVo();
                    areaVO.setId(area.getId());
                    areaVO.setName(area.getName());
                    areaVO.setCode(area.getCode());
                    areaVO.setType(area.getType());
                    areaVOList.add(areaVO);
                }

                cityVO.setChildren(areaVOList);
                cityVOList.add(cityVO);
            }
            provinceVO.setChildren(cityVOList);
            regionVoList.add(provinceVO);
        }

        return ResponseUtil.okList(regionVoList);
    }
}
