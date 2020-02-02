package com.cn.crm.service;

import com.cn.crm.bean.BasDictT;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface BasDictTService {
    List<BasDictT> selectByDictType(String dictType);

    int insertSelective(BasDictT basDictT);

    int updateByPrimaryKeySelective(BasDictT basDictT);

    int deleteByPrimaryKey(Integer dictId);

    BasDictT selectCstLevel(String dictValue);


}
