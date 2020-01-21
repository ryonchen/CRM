package com.cn.crm.dao;

import com.cn.crm.bean.BasDictT;

public interface BasDictTMapper {
    int deleteByPrimaryKey(Integer dict_id);

    int insert(BasDictT record);

    int insertSelective(BasDictT record);

    BasDictT selectByPrimaryKey(Integer dict_id);

    int updateByPrimaryKeySelective(BasDictT record);

    int updateByPrimaryKey(BasDictT record);
}