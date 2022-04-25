package com.yang.springcloud.controller;

import com.yang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/25/22:20
 */
@RestController
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping( "/payment/hystrix/ok/{id}" )
    public String payment_ok(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_OK(id);
    }

    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return paymentService.paymentInfo_timeOut(id);
    }
}
