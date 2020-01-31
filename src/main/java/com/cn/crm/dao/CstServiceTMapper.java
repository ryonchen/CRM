package com.cn.crm.dao;

import com.cn.crm.bean.CstServiceT;

public interface CstServiceTMapper {
    int deleteByPrimaryKey(Integer svcId);

    int insert(CstServiceT record);

    int insertSelective(CstServiceT record);

    CstServiceT selectByPrimaryKey(Integer svcId);

    int updateByPrimaryKeySelective(CstServiceT record);

    int updateByPrimaryKey(CstServiceT record);
}