package com.cn.crm.service;

import com.cn.crm.bean.CstLinkmanT;
import com.cn.crm.bean.SalPlanT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstLinkmanTService {
    List<CstLinkmanT> selectByCstId(Integer cstId);

    int insertSelective(CstLinkmanT cstLinkmanT);

    int updateByPrimaryKeySelective(CstLinkmanT cstLinkmanT);

    int deleteByPrimaryKey(Integer linkId);


}
