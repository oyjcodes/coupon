package com.imooc.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>分发目标</h1>
 * Created by oyj.
 */
@Getter
@AllArgsConstructor
public enum DistributeTarget {

    //单用户模式需要用户去主动领取优惠券
    SINGLE("单用户", 1),
    //多用户模式用于系统批量发送优惠券到用户的数据表空间，不需要用户自己去领取
    MULTI("多用户", 2);

    /** 分发目标描述 */
    private String description;

    /** 分发目标编码 */
    private Integer code;

    public static DistributeTarget of(Integer code) {

        Objects.requireNonNull(code);

        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists!"));
    }
}
