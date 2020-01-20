package com.cn.crm.dao;

import com.cn.crm.bean.sysRightT;

public interface sysRightTMapper {
    int deleteByPrimaryKey(Integer right_id);

    int insert(sysRightT record);

    int insertSelective(sysRightT record);

    sysRightT selectByPrimaryKey(Integer right_id);

    int updateByPrimaryKeySelective(sysRightT record);

    int updateByPrimaryKey(sysRightT record);
}