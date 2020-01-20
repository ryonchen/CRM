package com.cn.crm.dao;

import com.cn.crm.bean.cstLstT;

public interface cstLstTMapper {
    int deleteByPrimaryKey(Integer lst_id);

    int insert(cstLstT record);

    int insertSelective(cstLstT record);

    cstLstT selectByPrimaryKey(Integer lst_id);

    int updateByPrimaryKeySelective(cstLstT record);

    int updateByPrimaryKey(cstLstT record);
}