package com.cn.crm.service.impl;

import com.cn.crm.bean.SysAuth;
import com.cn.crm.dao.SysAuthMapper;
import com.cn.crm.service.SysAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-05 01:44
 */
@Service("sysAuthService")
public class SysAuthServiceImpl implements SysAuthService{
    @Autowired(required = false)
    private SysAuthMapper sysAuthMapper;

    @Override
    public SysAuth getAuth(Integer authId){
        return sysAuthMapper.selectByPrimaryKey(authId);
    }
}
