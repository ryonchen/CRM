package com.cn.crm.service;

import com.cn.crm.bean.SalChanceT;

import java.util.List;
import java.util.Map;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface SalChanceTService {
    List<SalChanceT> selectByCreateTime(Long beginDate, Long endDate);

    int insertSelective(SalChanceT salChanceT);

    int updateByPrimaryKeySelective(SalChanceT salChanceT);

    int deleteByPrimaryKey(Integer chcId);

}
