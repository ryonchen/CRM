package com.cn.crm.dao;

import com.cn.crm.bean.sysRoleT;

public interface sysRoleTMapper {
    int deleteByPrimaryKey(Integer role_id);

    int insert(sysRoleT record);

    int insertSelective(sysRoleT record);

    sysRoleT selectByPrimaryKey(Integer role_id);

    int updateByPrimaryKeySelective(sysRoleT record);

    int updateByPrimaryKey(sysRoleT record);
}