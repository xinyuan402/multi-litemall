package com.lcwork.multishop.core.util.response;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DataList<T> {

    private long total;

    private int page;

    private int limit;

    private int pages;

    private List<T> list;
}
