package com.cn.crm.dao;

import com.cn.crm.bean.cstActivityT;

public interface cstActivityTMapper {
    int deleteByPrimaryKey(Integer atv_id);

    int insert(cstActivityT record);

    int insertSelective(cstActivityT record);

    cstActivityT selectByPrimaryKey(Integer atv_id);

    int updateByPrimaryKeySelective(cstActivityT record);

    int updateByPrimaryKeyWithBLOBs(cstActivityT record);

    int updateByPrimaryKey(cstActivityT record);
}