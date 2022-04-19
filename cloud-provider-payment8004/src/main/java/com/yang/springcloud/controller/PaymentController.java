package com.yang.springcloud.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/17/22:43
 */
@RestController
public class PaymentController {
    @Value("${server.port}")
    private String serverPort ;

    @RequestMapping("/payment/zk")
    public String payment(){
        return "springcloud with zookeeper" + serverPort + "\t" + UUID.randomUUID().toString();
    }
}
