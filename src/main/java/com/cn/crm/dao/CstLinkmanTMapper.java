package com.cn.crm.dao;

import com.cn.crm.bean.CstLinkmanT;

public interface CstLinkmanTMapper {
    int deleteByPrimaryKey(Integer link_id);

    int insert(CstLinkmanT record);

    int insertSelective(CstLinkmanT record);

    CstLinkmanT selectByPrimaryKey(Integer link_id);

    int updateByPrimaryKeySelective(CstLinkmanT record);

    int updateByPrimaryKey(CstLinkmanT record);
}