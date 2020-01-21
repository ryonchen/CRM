package com.cn.crm.dao;

import com.cn.crm.bean.SysRoleT;

public interface SysRoleTMapper {
    int deleteByPrimaryKey(Integer role_id);

    int insert(SysRoleT record);

    int insertSelective(SysRoleT record);

    SysRoleT selectByPrimaryKey(Integer role_id);

    int updateByPrimaryKeySelective(SysRoleT record);

    int updateByPrimaryKey(SysRoleT record);
}