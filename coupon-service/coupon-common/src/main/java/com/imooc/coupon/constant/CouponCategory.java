package com.imooc.coupon.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

/**
 * <h1>优惠券分类</h1>
 * Created by oyj.
 */
@Getter
@AllArgsConstructor
public enum CouponCategory {

    MANJIAN("满减券", "001"),
    ZHEKOU("折扣券", "002"),
    LIJIAN("立减券", "003");

    /** 优惠券描述(分类) */
    private String description;

    /** 优惠券分类编码 */
    private String code;

    //通过code返回对应的枚举信息
    public static CouponCategory of(String code) {

        //code不允许为空，否则会抛出异常
        Objects.requireNonNull(code);


        /***
         * 1. 不需要参数,返回值为 5
         * () -> 5
         * 2. 接收一个参数(数字类型),返回其2倍的值
         * x -> 2 * x
         */
        //jdk8lamda表达式，将枚举数组values()转化为Stream流类型，通过lamda表达式获取想要的内容
        return Stream.of(values())
                .filter(bean -> bean.code.equals(code))
                .findAny() //到这一步，如果找到对应code的枚举则返回，否则执行下面的orElseThrow
                .orElseThrow(() -> new IllegalArgumentException(code + " not exists!"));
    }
}
