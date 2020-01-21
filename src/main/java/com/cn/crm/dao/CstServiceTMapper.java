package com.cn.crm.dao;

import com.cn.crm.bean.CstServiceT;

public interface CstServiceTMapper {
    int deleteByPrimaryKey(Integer svc_id);

    int insert(CstServiceT record);

    int insertSelective(CstServiceT record);

    CstServiceT selectByPrimaryKey(Integer svc_id);

    int updateByPrimaryKeySelective(CstServiceT record);

    int updateByPrimaryKey(CstServiceT record);
}