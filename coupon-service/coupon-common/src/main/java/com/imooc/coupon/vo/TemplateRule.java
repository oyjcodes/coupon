package com.imooc.coupon.vo;

import com.imooc.coupon.constant.PeriodType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

/**
 * <h1>优惠券规则对象定义，最后会以json的格式保存到数据表记录中</h1>
 * Created by oyj.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TemplateRule {

    /** 优惠券过期规则 */
    private Expiration expiration;

    /** 折扣 */
    private Discount discount;

    /** 每个人最多领几张的限制 */
    private Integer limitation;

    /** 使用范围: 地域 + 商品类型 */
    private Usage usage;

    /** 权重(可以和哪些优惠券叠加使用, 同一类的优惠券一定不能叠加): list[], 优惠券的唯一编码 */
    private String weight;

    /**
     * <h2>校验功能</h2>
     * */
    public boolean validate() {

        return expiration.validate() && discount.validate()
                && limitation > 0 && usage.validate()
                && StringUtils.isNotEmpty(weight);
    }



    /**
     * <h2>有效期限规则，需要与PeriodType类型配合决定</h2>
     * */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Expiration {

        /** 有效期规则, 对应 PeriodType 的 code 字段 */
        private Integer period;

        /** 有效间隔: 只对变动性有效期有效 */
        private Integer gap;

        /** 优惠券模板的失效日期, 两类规则都有效 */
        private Long deadline;

        boolean validate() {
            // 最简化校验
            return null != PeriodType.of(period) && gap > 0 && deadline > 0;
        }
    }

    /**
     * <h2>折扣, 需要与CouponCategory类型配合决定</h2>
     * */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Discount {

        /** 额度: 满减(20), 折扣(85), 立减(10) */
        private Integer quota;

        /** 基准, 需要满多少才可用 */
        private Integer base;

        boolean validate() {

            return quota > 0 && base > 0;
        }
    }

    /**
     * <h2>使用范围</h2>
     * */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Usage {

        /** 省份 */
        private String province;

        /** 城市 */
        private String city;

        /** 商品类型, list[文娱, 生鲜, 家居, 全品类] */
        private String goodsType;

        boolean validate() {

            return StringUtils.isNotEmpty(province)
                    && StringUtils.isNotEmpty(city)
                    && StringUtils.isNotEmpty(goodsType);
        }
    }
}
