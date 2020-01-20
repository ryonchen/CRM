package com.cn.crm.dao;

import com.cn.crm.bean.basDictT;

public interface basDictTMapper {
    int deleteByPrimaryKey(Integer dict_id);

    int insert(basDictT record);

    int insertSelective(basDictT record);

    basDictT selectByPrimaryKey(Integer dict_id);

    int updateByPrimaryKeySelective(basDictT record);

    int updateByPrimaryKey(basDictT record);
}