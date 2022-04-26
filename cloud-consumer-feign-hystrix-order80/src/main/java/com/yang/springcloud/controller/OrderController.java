package com.yang.springcloud.controller;

import com.yang.springcloud.feign.OrderFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/26/22:06
 */
@RestController
public class OrderController {

    @Autowired
    private OrderFeignService orderFeignService;

    @RequestMapping( "/consumer/payment/hystrix/ok/{id}" )
    public String payment_ok(@PathVariable("id") Integer id){
        return orderFeignService.payment_ok(id);
    }

    @RequestMapping("/consumer/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id){
        return orderFeignService.payment_timeout(id);
    }
}
