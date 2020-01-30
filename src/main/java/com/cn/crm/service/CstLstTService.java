package com.cn.crm.service;

import com.cn.crm.bean.CstLstT;
import com.cn.crm.bean.SalPlanT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstLstTService {
//    List<SalPlanT> selectByChcId(Integer chcId, Integer page, Integer rows, String sort, String order);

    int insertSelective(CstLstT cstLstT);

    int updateByPrimaryKeySelective(CstLstT cstLstT);

    int deleteByPrimaryKey(Integer lstId);


}
