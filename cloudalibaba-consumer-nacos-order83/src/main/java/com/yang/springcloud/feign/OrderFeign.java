package com.yang.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/05/17/11:22
 */
@Service
@FeignClient("nacos-payment-provider")
public interface OrderFeign {
    @GetMapping("/payment/nacos/{id}")
    public String getPayment(@PathVariable("id") Integer id);
}
