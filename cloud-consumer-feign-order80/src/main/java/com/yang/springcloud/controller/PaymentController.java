package com.yang.springcloud.controller;

import com.yang.springcloud.entity.CommonResult;
import com.yang.springcloud.entity.Payment;
import com.yang.springcloud.feign.PaymentFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/20/09:05
 */
@RestController
@RequestMapping("/feigenPayment")
public class PaymentController {

    // 注入我们写好的feign接口
    @Autowired
    private PaymentFeignService paymentFeignService;

    @GetMapping("/payment/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id ){
        // 调用feign接口中的方法，feign接口调用其他服务的接口，实现本服务调用其他服务的目的
        CommonResult<Payment> paymentById = paymentFeignService.getPaymentById(id);
        return paymentById;
    }
}
