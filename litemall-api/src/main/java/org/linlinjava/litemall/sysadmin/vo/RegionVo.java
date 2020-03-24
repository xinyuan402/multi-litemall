package org.linlinjava.litemall.sysadmin.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class RegionVo {
    private Integer id;
    private String name;
    private Byte type;
    private Integer code;

    private List<RegionVo> children;

}
