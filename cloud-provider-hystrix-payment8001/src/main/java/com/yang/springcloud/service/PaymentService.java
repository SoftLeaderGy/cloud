package com.yang.springcloud.service;

import java.util.concurrent.TimeUnit;
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
    public String paymentInfo_timeOut(Integer id){
        Integer timeOutNum = 3;
        // 延时3秒
        TimeUnit.SECONDS.sleep(3);
        return "线程池" + Thread.currentThread().getName() + "paymentInfo_timeOut ,id : " + id + "延时了" + timeOutNum + "秒";
    }
}
