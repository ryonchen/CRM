package com.cn.crm.dao;

import com.cn.crm.bean.BasDictT;

import java.util.List;

public interface BasDictTMapper {
    int deleteByPrimaryKey(Integer dictId);

    int insert(BasDictT record);

    int insertSelective(BasDictT record);

    BasDictT selectByPrimaryKey(Integer dictId);

    int updateByPrimaryKeySelective(BasDictT record);

    int updateByPrimaryKey(BasDictT record);

    List<BasDictT> selectByDictType(String dictType);

    BasDictT selectCstLevel(String dictValue);

}