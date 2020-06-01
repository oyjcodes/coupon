package com.imooc.coupon.service;

import com.imooc.coupon.entity.CouponTemplate;

/**
 * <h1>异步服务接口定义</h1>
 * Created by oyj.
 */
public interface IAsyncService {

    /**
     * <h2>根据模板异步的创建优惠券码</h2>
     * @param template {@link CouponTemplate} 优惠券模板实体
     * */
    void asyncConstructCouponByTemplate(CouponTemplate template);
}
