package com.cn.crm.service;

import com.cn.crm.bean.CstActivityT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstActivityTService {

    int insertSelective(CstActivityT cstActivityT);

    int updateByPrimaryKeySelective(CstActivityT cstActivityT);

    int deleteByPrimaryKey(Integer atvId);


}
