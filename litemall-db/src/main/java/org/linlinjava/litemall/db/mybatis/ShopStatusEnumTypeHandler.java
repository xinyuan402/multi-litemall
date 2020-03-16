package org.linlinjava.litemall.db.mybatis;

import org.apache.ibatis.type.EnumTypeHandler;
import org.linlinjava.litemall.db.enums.ShopStatus;

public class ShopStatusEnumTypeHandler extends EnumTypeHandler<ShopStatus> {

    public ShopStatusEnumTypeHandler(Class<ShopStatus> type) {
        super(type);
    }
}
