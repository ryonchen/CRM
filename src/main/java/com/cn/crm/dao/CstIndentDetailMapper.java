package com.cn.crm.dao;

import com.cn.crm.bean.CstIndentDetail;
import com.cn.crm.vo.IndentDetailVo;

import java.util.List;

public interface CstIndentDetailMapper {
    int deleteByPrimaryKey(Integer detailId);

    int insert(CstIndentDetail record);

    int insertSelective(CstIndentDetail record);

    CstIndentDetail selectByPrimaryKey(Integer detailId);

    int updateByPrimaryKeySelective(CstIndentDetail record);

    int updateByPrimaryKey(CstIndentDetail record);

    List<IndentDetailVo> selectByIndentId(Integer indentId);
}