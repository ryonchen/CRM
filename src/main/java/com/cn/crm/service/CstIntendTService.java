package com.cn.crm.service;

import com.cn.crm.bean.CstIndentT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstIntendTService {
    List<CstIndentT> selectByCstId(Integer cstId);

    int insertSelective(CstIndentT cstIndentT);

    int updateByPrimaryKeySelective(CstIndentT cstIndentT);

    int deleteByPrimaryKey(Integer intendId);


}
