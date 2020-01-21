package com.cn.crm.dao;

import com.cn.crm.bean.BasProductT;

public interface BasProductTMapper {
    int deleteByPrimaryKey(Integer pro_id);

    int insert(BasProductT record);

    int insertSelective(BasProductT record);

    BasProductT selectByPrimaryKey(Integer pro_id);

    int updateByPrimaryKeySelective(BasProductT record);

    int updateByPrimaryKey(BasProductT record);
}