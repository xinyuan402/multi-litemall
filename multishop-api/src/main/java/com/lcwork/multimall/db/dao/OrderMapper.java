package com.lcwork.multimall.db.dao;

import com.lcwork.multimall.db.domain.generate.MultimallOrder;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") MultimallOrder order);
}
