package com.cn.crm.dao;

import com.cn.crm.bean.CstIndentT;
import com.cn.crm.vo.IndentVo;

import java.util.List;

public interface CstIndentTMapper {
    int deleteByPrimaryKey(Integer indentId);

    int insert(CstIndentT record);

    int insertSelective(CstIndentT record);

    CstIndentT selectByPrimaryKey(Integer indentId);

    int updateByPrimaryKeySelective(CstIndentT record);

    int updateByPrimaryKey(CstIndentT record);

    List<IndentVo> selectByCstId(Integer cstId);
}