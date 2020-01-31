package com.cn.crm.service.impl;

import com.cn.crm.bean.CstLinkmanT;
import com.cn.crm.dao.CstLinkmanTMapper;
import com.cn.crm.service.CstLinkmanTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("cstLinkmanTService")
public class CstLinkmanTServiceImpl implements CstLinkmanTService {

    @Autowired(required = false)
    private CstLinkmanTMapper cstLinkmanTMapper;

    @Override
    public List<CstLinkmanT> selectByCstId(Integer cstId){
        return cstLinkmanTMapper.selectByCstId(cstId);
    }

    @Override
    public int insertSelective(CstLinkmanT cstLinkmanT){
        return cstLinkmanTMapper.insertSelective(cstLinkmanT);
    }

    @Override
    public int updateByPrimaryKeySelective(CstLinkmanT cstLinkmanT){
        return cstLinkmanTMapper.updateByPrimaryKeySelective(cstLinkmanT);
    }

    @Override
    public int deleteByPrimaryKey(Integer linkId){
        return cstLinkmanTMapper.deleteByPrimaryKey(linkId);
    }

}
