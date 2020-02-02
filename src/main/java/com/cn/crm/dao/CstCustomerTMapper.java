package com.cn.crm.dao;

import com.cn.crm.bean.CstCustomerT;
import com.cn.crm.vo.CustomerReqVo;
import com.cn.crm.vo.CustomerVo;

import java.util.List;

public interface CstCustomerTMapper {
    int deleteByPrimaryKey(Integer cstId);

    int insert(CstCustomerT record);

    int insertSelective(CstCustomerT record);

    CstCustomerT selectByPrimaryKey(Integer cstId);

    int updateByPrimaryKeySelective(CstCustomerT record);

    int updateByPrimaryKey(CstCustomerT record);

    List<CustomerVo> selectByUser(CustomerReqVo customerReqVo);

    int countByUser(CustomerReqVo customerReqVo);

    List<CstCustomerT> selectUserById(CustomerReqVo customerReqVo);
}