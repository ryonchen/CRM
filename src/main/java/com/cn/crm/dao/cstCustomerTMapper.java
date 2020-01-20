package com.cn.crm.dao;

import com.cn.crm.bean.cstCustomerT;

public interface cstCustomerTMapper {
    int deleteByPrimaryKey(Integer cst_id);

    int insert(cstCustomerT record);

    int insertSelective(cstCustomerT record);

    cstCustomerT selectByPrimaryKey(Integer cst_id);

    int updateByPrimaryKeySelective(cstCustomerT record);

    int updateByPrimaryKey(cstCustomerT record);
}