package com.yang.springcloud.service;

import com.yang.springcloud.entity.CommonResult;
import com.yang.springcloud.entity.Payment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/15/00:25
 */
@Service
public interface PaymentService {
    CommonResult create(Payment payment);
    CommonResult<Payment> getPaymentById(Long id);
}
