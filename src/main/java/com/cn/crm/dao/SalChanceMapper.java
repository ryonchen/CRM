package com.cn.crm.dao;

import com.cn.crm.bean.SalChance;

public interface SalChanceMapper {
    int deleteByPrimaryKey(Integer chcId);

    int insert(SalChance record);

    int insertSelective(SalChance record);

    SalChance selectByPrimaryKey(Integer chcId);

    int updateByPrimaryKeySelective(SalChance record);

    int updateByPrimaryKey(SalChance record);

    SalChance selectByCreateTime (Integer beginDate, Integer endDate);
}