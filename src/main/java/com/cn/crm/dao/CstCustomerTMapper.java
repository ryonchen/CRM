package com.cn.crm.dao;

import com.cn.crm.bean.CstCustomerT;

public interface CstCustomerTMapper {
    int deleteByPrimaryKey(Integer cst_id);

    int insert(CstCustomerT record);

    int insertSelective(CstCustomerT record);

    CstCustomerT selectByPrimaryKey(Integer cst_id);

    int updateByPrimaryKeySelective(CstCustomerT record);

    int updateByPrimaryKey(CstCustomerT record);
}