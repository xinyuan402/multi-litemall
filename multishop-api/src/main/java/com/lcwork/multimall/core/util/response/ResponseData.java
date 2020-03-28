package com.lcwork.multimall.core.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseData<T> {

    private int errno;
    private String errmsg;
    private T data;

    public ResponseData(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

}
