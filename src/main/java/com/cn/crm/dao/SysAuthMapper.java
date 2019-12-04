package com.cn.crm.dao;

import com.cn.crm.bean.SysAuth;

public interface SysAuthMapper {
    int deleteByPrimaryKey(Integer authId);

    int insert(SysAuth record);

    int insertSelective(SysAuth record);

    SysAuth selectByPrimaryKey(Integer authId);

    int updateByPrimaryKeySelective(SysAuth record);

    int updateByPrimaryKey(SysAuth record);


}