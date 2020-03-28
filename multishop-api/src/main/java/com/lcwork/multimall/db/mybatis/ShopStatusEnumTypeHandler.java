package com.lcwork.multimall.db.mybatis;

import com.lcwork.multimall.db.enums.ShopStatus;
import org.apache.ibatis.type.EnumTypeHandler;

public class ShopStatusEnumTypeHandler extends EnumTypeHandler<ShopStatus> {

    public ShopStatusEnumTypeHandler(Class<ShopStatus> type) {
        super(type);
    }
}
