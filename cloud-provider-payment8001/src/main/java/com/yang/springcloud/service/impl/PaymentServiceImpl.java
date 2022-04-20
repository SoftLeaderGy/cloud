package com.yang.springcloud.service.impl;

import com.yang.springcloud.dao.PaymentDao;
import com.yang.springcloud.entity.CommonResult;
import com.yang.springcloud.entity.Payment;
import com.yang.springcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Description:
 * @Author: Guo.Yang
 * @Date: 2022/04/15/00:27
 */
@Service("PaymentServiceImpl")
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentDao paymentDao;

    @Value("${server.port}")
    private String port;
    @Override
    public CommonResult create(Payment payment) {
        int i = paymentDao.create(payment);
        if (i > 0) {
            return new CommonResult<>(200,"添加成功 端口为："+ port);
        }
        return new CommonResult(444,"操作失败");
    }

    @Override
    public CommonResult<Payment> getPaymentById(Long id) {
        Payment paymentById = paymentDao.getPaymentById(id);
        return new CommonResult<Payment>(200,"查询成功 端口为："+ port,paymentById);
    }
}
