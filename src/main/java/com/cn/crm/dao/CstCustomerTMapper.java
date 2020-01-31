package com.cn.crm.dao;

import com.cn.crm.bean.CstCustomerT;

import java.util.List;

public interface CstCustomerTMapper {
    int deleteByPrimaryKey(Integer cst_id);

    int insert(CstCustomerT record);

    int insertSelective(CstCustomerT record);

    CstCustomerT selectByPrimaryKey(Integer cstId);

    int updateByPrimaryKeySelective(CstCustomerT record);

    int updateByPrimaryKey(CstCustomerT record);

    List<CstCustomerT> selectByUser(String userCode);
}