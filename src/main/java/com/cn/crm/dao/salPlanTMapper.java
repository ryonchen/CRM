package com.cn.crm.dao;

import com.cn.crm.bean.salPlanT;

public interface salPlanTMapper {
    int deleteByPrimaryKey(Integer plan_id);

    int insert(salPlanT record);

    int insertSelective(salPlanT record);

    salPlanT selectByPrimaryKey(Integer plan_id);

    int updateByPrimaryKeySelective(salPlanT record);

    int updateByPrimaryKey(salPlanT record);
}