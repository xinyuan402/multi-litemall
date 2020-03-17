package org.linlinjava.litemall.core.util.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ResponseData<T> {

    public ResponseData(int errno, String errmsg) {
        this.errno = errno;
        this.errmsg = errmsg;
    }

    private int errno;

    private String errmsg;

    private T data;

}
