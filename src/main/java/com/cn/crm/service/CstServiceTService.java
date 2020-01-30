package com.cn.crm.service;

import com.cn.crm.bean.CstServiceT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstServiceTService {
//    List<SalPlanT> selectByChcId(Integer chcId, Integer page, Integer rows, String sort, String order);

    int insertSelective(CstServiceT cstServiceT);

    int updateByPrimaryKeySelective(CstServiceT cstServiceT);

    int deleteByPrimaryKey(Integer svcId);


}
