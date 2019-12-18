package com.cn.crm.dao;

import com.cn.crm.bean.SalPlan;

public interface SalPlanMapper {
    int deleteByPrimaryKey(Integer planId);

    int insert(SalPlan record);

    int insertSelective(SalPlan record);

    SalPlan selectByPrimaryKey(Integer planId);

    int updateByPrimaryKeySelective(SalPlan record);

    int updateByPrimaryKey(SalPlan record);
}