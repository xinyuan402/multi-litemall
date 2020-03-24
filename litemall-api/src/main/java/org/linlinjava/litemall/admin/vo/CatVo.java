package org.linlinjava.litemall.admin.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class CatVo {
    private Integer value;
    private String label;
    private List<CatVo> children;

}
