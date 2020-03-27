package com.lcwork.multishop.db.mybatis;

import com.lcwork.multishop.db.enums.ShopStatus;
import org.apache.ibatis.type.EnumTypeHandler;

public class ShopStatusEnumTypeHandler extends EnumTypeHandler<ShopStatus> {

    public ShopStatusEnumTypeHandler(Class<ShopStatus> type) {
        super(type);
    }
}
