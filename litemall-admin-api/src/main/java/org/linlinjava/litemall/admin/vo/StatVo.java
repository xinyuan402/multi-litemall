package org.linlinjava.litemall.admin.vo;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Setter
@Getter
public class StatVo {
    private String[] columns = new String[0];
    private List<Map> rows = new ArrayList<>();

    public void add(Map... r) {
        rows.addAll(Arrays.asList(r));
    }
}
