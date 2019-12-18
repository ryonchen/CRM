package com.cn.crm.dao;

import com.cn.crm.bean.SysAuth;

import java.util.List;

public interface SysAuthMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(SysAuth record);

    int insertSelective(SysAuth record);

    SysAuth selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(SysAuth record);

    int updateByPrimaryKey(SysAuth record);

    List<SysAuth> selectByPrimaryKeyList(List<Integer> authIds);

    List<SysAuth> selectParentByRoleId(Integer roleId);

    List<SysAuth> selectByAuthParentId(Integer authId);


}