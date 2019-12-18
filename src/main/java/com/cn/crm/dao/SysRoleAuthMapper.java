package com.cn.crm.dao;

import com.cn.crm.bean.SysRoleAuth;

import java.util.List;

public interface SysRoleAuthMapper {
    int deleteByPrimaryKey(Integer raId);



    int insert(SysRoleAuth record);

    int insertSelective(SysRoleAuth record);

    SysRoleAuth selectByPrimaryKey(Integer raId);

    int updateByPrimaryKeySelective(SysRoleAuth record);

    int updateByPrimaryKey(SysRoleAuth record);

    List<SysRoleAuth> selectByRoleId(Integer roleId);
}