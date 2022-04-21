package com.yang.springcloud.feign;

import com.yang.springcloud.entity.CommonResult;
import com.yang.springcloud.entity.Payment;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Description: feign接口
 * @Author: Guo.Yang
 * @Date: 2022/04/20/09:02
 */
@Component
@FeignClient("cloud-payment-service") // 参数为：注册中心暴露的服务的名称
public interface PaymentFeignService {

    // 相当于调用注册中心中暴露的服务名称为：cloud-payment-service 下的服务
    // 并且路径为"/payment/getPaymentById/{id}" 的接口
    @GetMapping("/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id );
}
