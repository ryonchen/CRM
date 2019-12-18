package com.cn.crm.service.impl;

import com.cn.crm.bean.SalChance;
import com.cn.crm.dao.SalChanceMapper;
import com.cn.crm.service.SalChanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("salChanceService")
public class SalChanceServiceImpl implements SalChanceService{

    @Autowired(required = false)
    private SalChanceMapper salChanceMapper;

    @Override
    public SalChance getSaleChanceByCreateDate(Integer beginDate, Integer endDate){
        return salChanceMapper.selectByCreateTime(beginDate, endDate);
    }
}
