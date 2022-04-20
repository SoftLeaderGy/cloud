package com.yang.ribbon.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: Ribbon负载均衡策略配置类
 * @Author: Guo.Yang
 * @Date: 2022/04/19/09:43
 */
@Configuration
public class MyRule {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }
}
