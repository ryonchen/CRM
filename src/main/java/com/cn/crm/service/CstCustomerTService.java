package com.cn.crm.service;

import com.cn.crm.bean.CstCustomerT;
import com.cn.crm.vo.CustomerReqVo;
import com.cn.crm.vo.CustomerVo;

import java.util.List;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-08 00:33
 */
public interface CstCustomerTService {
    List<CustomerVo> selectByUser(CustomerReqVo customerReqVo);

    int insertSelective(CstCustomerT cstCustomerT);

    int updateByPrimaryKeySelective(CstCustomerT cstCustomerT);

    int deleteByPrimaryKey(Integer cstId);

    int countByUser(CustomerReqVo customerReqVo);


}
