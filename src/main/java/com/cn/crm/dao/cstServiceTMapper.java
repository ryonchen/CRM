package com.cn.crm.dao;

import com.cn.crm.bean.cstServiceT;

public interface cstServiceTMapper {
    int deleteByPrimaryKey(Integer svc_id);

    int insert(cstServiceT record);

    int insertSelective(cstServiceT record);

    cstServiceT selectByPrimaryKey(Integer svc_id);

    int updateByPrimaryKeySelective(cstServiceT record);

    int updateByPrimaryKey(cstServiceT record);
}