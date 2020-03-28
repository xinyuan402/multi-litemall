package com.lcwork.multimall.sysadmin.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class PermVo {
    private String id;
    private String label;
    private String api;
    private List<PermVo> children;

}
