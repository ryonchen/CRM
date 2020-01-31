package com.cn.crm.dao;

import com.cn.crm.bean.CstIndentT;

import java.util.List;

public interface CstIndentTMapper {
    int deleteByPrimaryKey(Integer indentId);

    int insert(CstIndentT record);

    int insertSelective(CstIndentT record);

    CstIndentT selectByPrimaryKey(Integer indentId);

    int updateByPrimaryKeySelective(CstIndentT record);

    int updateByPrimaryKey(CstIndentT record);

    List<CstIndentT> selectByCstId(Integer cstId);
}