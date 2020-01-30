package com.cn.crm.service.impl;

import com.cn.crm.bean.SalPlanT;
import com.cn.crm.dao.SalPlanTMapper;
import com.cn.crm.service.SalPlanTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("salPlanServiceT")
public class SalPlanTServiceImpl implements SalPlanTService {

    @Autowired(required = false)
    private SalPlanTMapper salPlanTMapper;

    @Override
    public List<SalPlanT> selectByChcId(Integer chcId, Integer page, Integer rows, String sort, String order){
        return salPlanTMapper.selectByChcId(chcId, page, rows, sort, order);
    }

    @Override
    public int insertSelective(SalPlanT salPlanT){
        return salPlanTMapper.insertSelective(salPlanT);
    }

    @Override
    public int updateByPrimaryKeySelective(SalPlanT salPlanT){
        return salPlanTMapper.updateByPrimaryKeySelective(salPlanT);
    }

    @Override
    public int deleteByPrimaryKey(Integer planId){
        return salPlanTMapper.deleteByPrimaryKey(planId);
    }

}
