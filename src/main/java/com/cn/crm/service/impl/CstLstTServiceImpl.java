package com.cn.crm.service.impl;

import com.cn.crm.bean.CstLstT;
import com.cn.crm.dao.CstLstTMapper;
import com.cn.crm.service.CstLstTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("cstLstTService")
public class CstLstTServiceImpl implements CstLstTService {

    @Autowired(required = false)
    private CstLstTMapper cstLstTMapper;

//    @Override
//    public List<SalPlanT> selectByChcId(Integer chcId, Integer page, Integer rows, String sort, String order){
//        return salPlanTMapper.selectByChcId(chcId, page, rows, sort, order);
//    }

    @Override
    public int insertSelective(CstLstT cstLstT){
        return cstLstTMapper.insertSelective(cstLstT);
    }

    @Override
    public int updateByPrimaryKeySelective(CstLstT cstLstT){
        return cstLstTMapper.updateByPrimaryKeySelective(cstLstT);
    }

    @Override
    public int deleteByPrimaryKey(Integer lstId){
        return cstLstTMapper.deleteByPrimaryKey(lstId);
    }

}
