package com.yang.springcloud.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/26/22:08
 */
@Service
@FeignClient("cloud-provider-hystrix-payment")
public interface OrderFeignService {
    @RequestMapping( "/payment/hystrix/ok/{id}" )
    public String payment_ok(@PathVariable("id") Integer id);

    @RequestMapping("/payment/hystrix/timeout/{id}")
    public String payment_timeout(@PathVariable("id") Integer id);
}
