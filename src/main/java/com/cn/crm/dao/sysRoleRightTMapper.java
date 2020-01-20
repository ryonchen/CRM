package com.cn.crm.dao;

import com.cn.crm.bean.sysRoleRightTKey;

public interface sysRoleRightTMapper {
    int deleteByPrimaryKey(sysRoleRightTKey key);

    int insert(sysRoleRightTKey record);

    int insertSelective(sysRoleRightTKey record);
}