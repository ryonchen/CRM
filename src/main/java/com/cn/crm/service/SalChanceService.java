package com.cn.crm.service;

import com.cn.crm.bean.SalChance;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface SalChanceService {
    SalChance getSaleChanceByCreateDate(Integer beginDate, Integer endDate);
}
