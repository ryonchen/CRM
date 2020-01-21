package com.cn.crm.dao;

import com.cn.crm.bean.SysRoleRightTKey;

public interface SysRoleRightTMapper {
    int deleteByPrimaryKey(SysRoleRightTKey key);

    int insert(SysRoleRightTKey record);

    int insertSelective(SysRoleRightTKey record);
}