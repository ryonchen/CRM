package com.cn.crm.service;

import com.cn.crm.bean.CstIndentT;
import com.cn.crm.vo.IndentVo;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstIndendTService {
    List<IndentVo> selectByCstId(Integer cstId);

    int insertSelective(CstIndentT cstIndentT);

    int updateByPrimaryKeySelective(CstIndentT cstIndentT);

    int deleteByPrimaryKey(Integer intendId);



}
