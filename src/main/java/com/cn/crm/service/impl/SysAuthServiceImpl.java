package com.cn.crm.service.impl;

import com.cn.crm.bean.SysAuth;
import com.cn.crm.dao.SysAuthMapper;
import com.cn.crm.service.SysAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


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

    @Override
    public List<SysAuth> getAuthList(List<Integer> authIds){
        return sysAuthMapper.selectByPrimaryKeyList(authIds);
    }

    @Override
    public List<SysAuth> getParentAuthListByRoleId(Integer roleId){
        return sysAuthMapper.selectParentByRoleId(roleId);
    }

    @Override
    public List<SysAuth> getAuthListByAuthParentId(Integer authId){
        return sysAuthMapper.selectByAuthParentId(authId);
    }
}
