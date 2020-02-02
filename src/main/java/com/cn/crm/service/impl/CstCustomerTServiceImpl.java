package com.cn.crm.service.impl;

import com.cn.crm.bean.CstCustomerT;
import com.cn.crm.dao.CstCustomerTMapper;
import com.cn.crm.service.CstCustomerTService;
import com.cn.crm.vo.CustomerReqVo;
import com.cn.crm.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:29
 */
@Service("cstCustomerTService")
public class CstCustomerTServiceImpl implements CstCustomerTService {

    @Autowired(required = false)
    private CstCustomerTMapper cstCustomerTMapper;

    @Override
    public List<CustomerVo> selectByUser(CustomerReqVo customerReqVo){
        return cstCustomerTMapper.selectByUser(customerReqVo);
    }

    @Override
    public int insertSelective(CstCustomerT cstCustomerT){
        return cstCustomerTMapper.insertSelective(cstCustomerT);
    }

    @Override
    public int updateByPrimaryKeySelective(CstCustomerT cstCustomerT){
        return cstCustomerTMapper.updateByPrimaryKeySelective(cstCustomerT);
    }

    @Override
    public int deleteByPrimaryKey(Integer cstId){
        return cstCustomerTMapper.deleteByPrimaryKey(cstId);
    }

    @Override
    public int countByUser(CustomerReqVo customerReqVo){
        return cstCustomerTMapper.countByUser(customerReqVo);
    }

}
