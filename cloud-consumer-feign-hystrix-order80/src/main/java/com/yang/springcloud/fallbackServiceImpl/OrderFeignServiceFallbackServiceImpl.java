package com.yang.springcloud.fallbackServiceImpl;

import com.yang.springcloud.feign.OrderFeignService;
import org.springframework.stereotype.Component;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/05/03/19:22
 */
@Component
public class OrderFeignServiceFallbackServiceImpl implements OrderFeignService {
    @Override
    public String payment_ok(Integer id) {
        return "payment_ok--> fallback";
    }

    @Override
    public String payment_timeout(Integer id) {
        return "payment_timeout--> fallback";
    }
}
