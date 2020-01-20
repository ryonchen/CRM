package com.cn.crm.dao;

import com.cn.crm.bean.sysUserT;

public interface sysUserTMapper {
    int deleteByPrimaryKey(Integer user_id);

    int insert(sysUserT record);

    int insertSelective(sysUserT record);

    sysUserT selectByPrimaryKey(Integer user_id);

    int updateByPrimaryKeySelective(sysUserT record);

    int updateByPrimaryKey(sysUserT record);
}