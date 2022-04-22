package com.yang.springcloud.controller;

import com.yang.springcloud.entity.CommonResult;
import com.yang.springcloud.entity.Payment;
import com.yang.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/15/00:33
 */
@RestController
@RequestMapping("/payment")
@Slf4j
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DiscoveryClient discoveryClient;
    @PostMapping("/create")
    public CommonResult create(@RequestBody Payment payment){
        return paymentService.create(payment);
    }

    @GetMapping("/getPaymentById/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentService.getPaymentById(id);
    };
    @GetMapping("/getPaymentById/discovery")
    public Object discovery(){
        // 获取注册进eureka的所有服务
        List<String> services = discoveryClient.getServices();
        for (String service : services) {
            log.info("service: "+ service);
        }

        // 获取某个服务中的所有实例信息
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info("实例："+ instance);
            log.info("服务主机："+ instance.getHost() + "端口："+ instance.getPort() + "地址：" + instance.getUri());
        }
        return discoveryClient;
    }


    /**
     * 服务提供者超时方法，测试Feign接口调用服务超时
     * @return
     */
    @GetMapping("/feign/timeout")
    public Integer paymentFeignTimeOut(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 123;
    }
}
