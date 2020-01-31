package com.cn.crm.service.impl;

import com.cn.crm.bean.CstActivityT;
import com.cn.crm.dao.CstActivityTMapper;
import com.cn.crm.service.CstActivityTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("cstActivityTService")
public class CstActivityTServiceImpl implements CstActivityTService {

    @Autowired(required = false)
    private CstActivityTMapper cstActivityTMapper;

    @Override
    public List<CstActivityT> selectByCstId(Integer cstId){
        return cstActivityTMapper.selectByCstId(cstId);
    }

    @Override
    public int insertSelective(CstActivityT cstActivityT){
        return cstActivityTMapper.insertSelective(cstActivityT);
    }

    @Override
    public int updateByPrimaryKeySelective(CstActivityT cstActivityT){
        return cstActivityTMapper.updateByPrimaryKeySelective(cstActivityT);
    }

    @Override
    public int deleteByPrimaryKey(Integer atvId){
        return cstActivityTMapper.deleteByPrimaryKey(atvId);
    }

}
