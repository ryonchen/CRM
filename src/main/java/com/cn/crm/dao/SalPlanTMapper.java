package com.cn.crm.dao;

import com.cn.crm.bean.SalPlanT;

public interface SalPlanTMapper {
    int deleteByPrimaryKey(Integer plan_id);

    int insert(SalPlanT record);

    int insertSelective(SalPlanT record);

    SalPlanT selectByPrimaryKey(Integer plan_id);

    int updateByPrimaryKeySelective(SalPlanT record);

    int updateByPrimaryKey(SalPlanT record);
}