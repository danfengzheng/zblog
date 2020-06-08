package com.zblog.manager.operation.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zblog.mapper.operation.CategoryMapper;
import com.zblog.pojo.operation.Category;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @program: zblog
 * @description: 分类管理
 * @author: xxx
 * @create: 2020-06-04 16:33
 */
@Slf4j
@Service
public class CategoryService extends ServiceImpl<CategoryMapper, Category> {

    static BigDecimal a = new BigDecimal("10100");
    static BigDecimal b = new BigDecimal("9900");

    public static void main(String[] args) {
        System.out.println();
        /*初始账户*/
        for (int i = 1; i < 60; i++) {
            a();
        }
    }


    /*冻结账户余额计算*/
    public static void a() {
        BigDecimal c = new BigDecimal(150);
        if (b.compareTo(new BigDecimal(10000)) < 0) {
            /*当日可挖矿最大额度*/
            c = b.multiply(new BigDecimal("0.015"));

        }
        /*计算盈利*/
        BigDecimal d = a.multiply(new BigDecimal(0.03));
        /*超过最大额度*/
        if (d.compareTo(c) > 0) {
            d = c;
        }
        System.out.println(d.toBigInteger());
        a = a.add(d);
        b = b.subtract(d);
        log.info("当日可用金额：{} , 当前挖矿账户余额为：{}", a.toPlainString(), b.toPlainString());
    }
}
