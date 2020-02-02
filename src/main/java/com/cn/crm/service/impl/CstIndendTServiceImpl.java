package com.cn.crm.service.impl;

import com.cn.crm.bean.CstIndentT;
import com.cn.crm.dao.CstIndentTMapper;
import com.cn.crm.service.CstIndendTService;
import com.cn.crm.vo.IndentVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("cstIntendTService")
public class CstIndendTServiceImpl implements CstIndendTService {

    @Autowired(required = false)
    private CstIndentTMapper cstIndentTMapper;

    @Override
    public List<IndentVo> selectByCstId(Integer cstId){
        return cstIndentTMapper.selectByCstId(cstId);
    }

    @Override
    public int insertSelective(CstIndentT cstIndentT){
        return cstIndentTMapper.insertSelective(cstIndentT);
    }

    @Override
    public int updateByPrimaryKeySelective(CstIndentT cstIndentT){
        return cstIndentTMapper.updateByPrimaryKeySelective(cstIndentT);
    }

    @Override
    public int deleteByPrimaryKey(Integer intendId){
        return cstIndentTMapper.deleteByPrimaryKey(intendId);
    }

}
