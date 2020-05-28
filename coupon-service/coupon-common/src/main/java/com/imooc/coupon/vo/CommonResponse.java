package com.imooc.coupon.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <h1>通用响应对象定义</h1>
 * Created by oyj.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CommonResponse<T> implements Serializable {

    private Integer code;//状态码
    private String message;//状态信息
    private T data;//响应数据

    public CommonResponse(Integer code, String message) {

        this.code = code;
        this.message = message;
    }
}
