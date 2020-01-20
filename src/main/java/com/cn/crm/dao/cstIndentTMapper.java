package com.cn.crm.dao;

import com.cn.crm.bean.cstIndentT;

public interface cstIndentTMapper {
    int deleteByPrimaryKey(Integer indent_id);

    int insert(cstIndentT record);

    int insertSelective(cstIndentT record);

    cstIndentT selectByPrimaryKey(Integer indent_id);

    int updateByPrimaryKeySelective(cstIndentT record);

    int updateByPrimaryKey(cstIndentT record);
}