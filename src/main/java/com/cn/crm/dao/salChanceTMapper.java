package com.cn.crm.dao;

import com.cn.crm.bean.salChanceT;

public interface salChanceTMapper {
    int deleteByPrimaryKey(Integer chc_id);

    int insert(salChanceT record);

    int insertSelective(salChanceT record);

    salChanceT selectByPrimaryKey(Integer chc_id);

    int updateByPrimaryKeySelective(salChanceT record);

    int updateByPrimaryKey(salChanceT record);
}