package com.cn.crm.dao;

import com.cn.crm.bean.CstLinkmanT;

import java.util.List;

public interface CstLinkmanTMapper {
    int deleteByPrimaryKey(Integer linkId);

    int insert(CstLinkmanT record);

    int insertSelective(CstLinkmanT record);

    CstLinkmanT selectByPrimaryKey(Integer linkId);

    int updateByPrimaryKeySelective(CstLinkmanT record);

    int updateByPrimaryKey(CstLinkmanT record);

    List<CstLinkmanT> selectByCstId(Integer cstId);
}