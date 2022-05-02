package com.yang.springcloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
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
@DefaultProperties(defaultFallback = "payment_Global_FallbackMethod") // 配置全局的服务降级
public class OrderController {

    @Autowired
    private OrderFeignService orderFeignService;

    @RequestMapping( "/consumer/payment/hystrix/ok/{id}" )
    public String payment_ok(@PathVariable("id") Integer id){
        return orderFeignService.payment_ok(id);
    }

    /**
     * 消费端服务 的服务降级应用场景：
     *  对于服务端来说 接口3秒返回是在正常的范围之内的，但是对于服务消费端来说，
     *  接口返回有有效时间为1秒， 这样就会跳到消费端服务的降级方法中去
     * @param id
     * @return
     */
    @RequestMapping("/consumer/payment/hystrix/timeout/{id}")
//    @HystrixCommand(fallbackMethod = "payment_timeoutFallback",commandProperties = {
//            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "1000")
//    })
    @HystrixCommand //加了@DefaultProperties属性注解，并且没有写具体方法名字，就用统一全局的
    public String payment_timeout(@PathVariable("id") Integer id){
//        int a = 10/0;
        return orderFeignService.payment_timeout(id);
    }

    public String payment_timeoutFallback(@PathVariable("id") Integer id){
        return "我是消费者 80, 对方支付系统繁忙请 10 秒钟后再试或者自己运行出错请检查自己,o(╥﹏╥)o ";
    }

    public String payment_Global_FallbackMethod() {
        return"Global 异常处理信息，请稍后再试， /( ㄒ o ㄒ )/~~" ;
    }
}
