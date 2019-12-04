package com.cn.crm.service.impl;

import com.cn.crm.bean.SysRoleAuth;
import com.cn.crm.dao.SysRoleAuthMapper;
import com.cn.crm.service.SysRoleAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-04 23:37
 */
@Service("sysRoleAuthService")
public class SysRoleAuthServiceImpl implements SysRoleAuthService {
    @Autowired(required = false)
    private SysRoleAuthMapper sysRoleAuthMapper;

    @Override
    public List<SysRoleAuth> getAuthListByRoleId(Integer roleId){
        return sysRoleAuthMapper.selectByRoleId(roleId);
    }
}
