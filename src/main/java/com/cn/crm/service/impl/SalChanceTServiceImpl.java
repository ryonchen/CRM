package com.cn.crm.service.impl;

import com.cn.crm.bean.SalChanceT;
import com.cn.crm.dao.SalChanceTMapper;
import com.cn.crm.service.SalChanceTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("salChanceServiceT")
public class SalChanceTServiceImpl implements SalChanceTService{

    @Autowired(required = false)
    private SalChanceTMapper salChanceTMapper;

    @Override
    public List<SalChanceT> selectByCreateTime(Long beginDate, Long endDate, String custName, String title, String linkman,Integer page, Integer rows, String sort, String order){
        return salChanceTMapper.selectByCreateTime(beginDate, endDate, custName, title, linkman, page, rows, sort, order);
    }

    @Override
    public int insertSelective(SalChanceT salChanceT){
        return salChanceTMapper.insertSelective(salChanceT);
    }

    @Override
    public int updateByPrimaryKeySelective(SalChanceT salChanceT){
        return salChanceTMapper.updateByPrimaryKeySelective(salChanceT);
    }

    @Override
    public int deleteByPrimaryKey(Integer chcId){
        return salChanceTMapper.deleteByPrimaryKey(chcId);
    }

    @Override
    public  int deleteByPrimaryKeys(Integer[] chcIds){
        return salChanceTMapper.deleteByPrimaryKeys(chcIds);
    }

    @Override
    public long countByCreateTime(Long beginDate, Long endDate, String custName, String title, String linkman,Integer page, Integer rows, String sort, String order){
        return salChanceTMapper.countByCreateTime(beginDate, endDate, custName, title, linkman, page, rows, sort, order);
    }



}
