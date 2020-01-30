package com.cn.crm.service.impl;

import com.cn.crm.bean.CstServiceT;
import com.cn.crm.bean.SalPlanT;
import com.cn.crm.dao.CstServiceTMapper;
import com.cn.crm.dao.SalPlanTMapper;
import com.cn.crm.service.CstServiceTService;
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
@Service("cstServiceTService")
public class CstServiceTServiceImpl implements CstServiceTService {

    @Autowired(required = false)
    private CstServiceTMapper cstServiceTMapper;

//    @Override
//    public List<SalPlanT> selectByChcId(Integer chcId, Integer page, Integer rows, String sort, String order){
//        return salPlanTMapper.selectByChcId(chcId, page, rows, sort, order);
//    }

    @Override
    public int insertSelective(CstServiceT cstServiceT){
        return cstServiceTMapper.insertSelective(cstServiceT);
    }

    @Override
    public int updateByPrimaryKeySelective(CstServiceT cstServiceT){
        return cstServiceTMapper.updateByPrimaryKeySelective(cstServiceT);
    }

    @Override
    public int deleteByPrimaryKey(Integer svcId){
        return cstServiceTMapper.deleteByPrimaryKey(svcId);
    }

}
