package com.cn.crm.service;

import com.cn.crm.bean.SalPlanT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface SalPlanTService {
    List<SalPlanT> selectByChcId(Integer chcId, Integer page, Integer rows, String sort, String order);

    int insertSelective(SalPlanT salPlanT);

    int updateByPrimaryKeySelective(SalPlanT salPlanT);

    int deleteByPrimaryKey(Integer planId);


}
