package com.cn.crm.dao;

import com.cn.crm.bean.basProductT;

public interface basProductTMapper {
    int deleteByPrimaryKey(Integer pro_id);

    int insert(basProductT record);

    int insertSelective(basProductT record);

    basProductT selectByPrimaryKey(Integer pro_id);

    int updateByPrimaryKeySelective(basProductT record);

    int updateByPrimaryKey(basProductT record);
}