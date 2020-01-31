package com.cn.crm.service;

import com.cn.crm.bean.CstActivityT;
import com.cn.crm.bean.CstCustomerT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstActivityTService {
    List<CstActivityT> selectByCstId(Integer cstId);

    int insertSelective(CstActivityT cstActivityT);

    int updateByPrimaryKeySelective(CstActivityT cstActivityT);

    int deleteByPrimaryKey(Integer atvId);


}
