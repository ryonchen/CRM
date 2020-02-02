package com.cn.crm.service.impl;

import com.cn.crm.bean.BasDictT;
import com.cn.crm.dao.BasDictTMapper;
import com.cn.crm.service.BasDictTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("basDictTService")
public class BasDictTServiceImpl implements BasDictTService {

    @Autowired(required = false)
    private BasDictTMapper basDictTMapper;

    @Override
    public List<BasDictT> selectByDictType(String dictType){
        return basDictTMapper.selectByDictType(dictType);
    }

    @Override
    public int insertSelective(BasDictT basDictT){
        return basDictTMapper.insertSelective(basDictT);
    }

    @Override
    public int updateByPrimaryKeySelective(BasDictT basDictT){
        return basDictTMapper.updateByPrimaryKeySelective(basDictT);
    }

    @Override
    public int deleteByPrimaryKey(Integer dictId){
        return basDictTMapper.deleteByPrimaryKey(dictId);
    }

    @Override
    public BasDictT selectCstLevel(String dictValue){
        return basDictTMapper.selectCstLevel(dictValue);
    }
}
