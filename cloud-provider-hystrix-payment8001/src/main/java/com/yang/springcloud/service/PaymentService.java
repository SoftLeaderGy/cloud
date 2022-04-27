package com.yang.springcloud.service;

import java.util.concurrent.TimeUnit;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.SneakyThrows;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/25/22:13
 */
@Service("PaymentService")
public class PaymentService {

    /**
     * 正常访问
     * @param id
     * @return
     */
    public String paymentInfo_OK(Integer id){
        return "线程池" + Thread.currentThread().getName() +  "paymentInfo_OK,id: " + id;
    }

    /**
     * 超时访问，演示降级
     * @param id
     * @return
     */
    @SneakyThrows
    @HystrixCommand(fallbackMethod = "paymentInfo_timeOutFallback",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")
    })
    public String paymentInfo_timeOut(Integer id){
        Integer timeOutNum = 5;
        // 延时3秒
        TimeUnit.SECONDS.sleep(3);
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_timeOut ,id : " + id + "延时了" + timeOutNum + "秒";
    }

    /**
     * @HystrixCommand 注解里边配置的fallbackMethod 方法
     * 也就是说 当被标记的方法出问题了，就会降级到对应配置的降级方法
     * @param id
     * @return
     */
    public String paymentInfo_timeOutFallback(Integer id){
        return "线程池" + Thread.currentThread().getName() + "系统繁忙，请稍后再试 ,id : " + id ;
    }
}
