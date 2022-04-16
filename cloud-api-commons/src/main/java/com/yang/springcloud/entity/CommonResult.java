package com.yang.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description: 统一返回结果集
 * @Author: Guo.Yang
 * @Date: 2022/04/15/00:06
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    public CommonResult(Integer code,String message){
        this(code,message,null);
    }
}
