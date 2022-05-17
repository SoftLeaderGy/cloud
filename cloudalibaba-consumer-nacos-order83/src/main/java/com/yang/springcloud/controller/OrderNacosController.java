package com.yang.springcloud.controller;

import com.yang.springcloud.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/05/17/11:21
 */
@RestController
public class OrderNacosController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private OrderFeign orderFeign;

    @GetMapping("cunsumer/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id){
        return "端口号："+ serverPort + " " +  orderFeign.getPayment(id);
    }
}
