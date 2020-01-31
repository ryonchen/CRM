package com.cn.crm.dao;

import com.cn.crm.bean.CstActivityT;

import java.util.List;

public interface CstActivityTMapper {
    int deleteByPrimaryKey(Integer atv_id);

    int insert(CstActivityT record);

    int insertSelective(CstActivityT record);

    CstActivityT selectByPrimaryKey(Integer atv_id);

    int updateByPrimaryKeySelective(CstActivityT record);

    int updateByPrimaryKeyWithBLOBs(CstActivityT record);

    int updateByPrimaryKey(CstActivityT record);

    List<CstActivityT> selectByCstId(Integer cstId);
}