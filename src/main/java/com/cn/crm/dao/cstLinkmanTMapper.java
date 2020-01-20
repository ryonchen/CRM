package com.cn.crm.dao;

import com.cn.crm.bean.cstLinkmanT;

public interface cstLinkmanTMapper {
    int deleteByPrimaryKey(Integer link_id);

    int insert(cstLinkmanT record);

    int insertSelective(cstLinkmanT record);

    cstLinkmanT selectByPrimaryKey(Integer link_id);

    int updateByPrimaryKeySelective(cstLinkmanT record);

    int updateByPrimaryKey(cstLinkmanT record);
}