package com.cn.crm.dao;

import com.cn.crm.bean.CstLstT;

public interface CstLstTMapper {
    int deleteByPrimaryKey(Integer lstId);

    int insert(CstLstT record);

    int insertSelective(CstLstT record);

    CstLstT selectByPrimaryKey(Integer lstId);

    int updateByPrimaryKeySelective(CstLstT record);

    int updateByPrimaryKey(CstLstT record);
}