package com.cn.crm.dao;

import com.cn.crm.bean.SysRole;

public interface SysRoleMapper {
    int deleteByPrimaryKey(Integer roleId);

    int insert(SysRole record);

    int insertSelective(SysRole record);

    SysRole selectByPrimaryKey(Integer roleId);

    int updateByPrimaryKeySelective(SysRole record);

    int updateByPrimaryKey(SysRole record);
}