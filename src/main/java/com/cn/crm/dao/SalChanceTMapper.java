package com.cn.crm.dao;

import com.cn.crm.bean.SalChanceT;

public interface SalChanceTMapper {
    int deleteByPrimaryKey(Integer chc_id);

    int insert(SalChanceT record);

    int insertSelective(SalChanceT record);

    SalChanceT selectByPrimaryKey(Integer chc_id);

    int updateByPrimaryKeySelective(SalChanceT record);

    int updateByPrimaryKey(SalChanceT record);
}