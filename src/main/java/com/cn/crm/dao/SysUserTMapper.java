package com.cn.crm.dao;

import com.cn.crm.bean.SysUserT;

public interface SysUserTMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(SysUserT record);

    int insertSelective(SysUserT record);

    SysUserT selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(SysUserT record);

    int updateByPrimaryKey(SysUserT record);
}