package com.cn.crm.dao;

import com.cn.crm.bean.CstIndentT;

public interface CstIndentTMapper {
    int deleteByPrimaryKey(Integer indent_id);

    int insert(CstIndentT record);

    int insertSelective(CstIndentT record);

    CstIndentT selectByPrimaryKey(Integer indent_id);

    int updateByPrimaryKeySelective(CstIndentT record);

    int updateByPrimaryKey(CstIndentT record);
}