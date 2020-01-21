package com.cn.crm.dao;

import com.cn.crm.bean.SysRightT;

public interface SysRightTMapper {
    int deleteByPrimaryKey(Integer right_id);

    int insert(SysRightT record);

    int insertSelective(SysRightT record);

    SysRightT selectByPrimaryKey(Integer right_id);

    int updateByPrimaryKeySelective(SysRightT record);

    int updateByPrimaryKey(SysRightT record);
}