package com.cn.crm.service;

import com.cn.crm.bean.CstCustomerT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstCustomerTService {
//    List<SalPlanT> selectByChcId(Integer chcId, Integer page, Integer rows, String sort, String order);

    int insertSelective(CstCustomerT cstCustomerT);

    int updateByPrimaryKeySelective(CstCustomerT cstCustomerT);

    int deleteByPrimaryKey(Integer cstId);


}
