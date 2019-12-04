package com.cn.crm.service.impl;

import com.cn.crm.bean.SysRole;
import com.cn.crm.dao.SysRoleMapper;
import com.cn.crm.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-05 00:58
 */
@Service("sysRoleService")
public class SysRoleServiceImpl implements SysRoleService{
    @Autowired(required = false)
    private SysRoleMapper sysRoleMapper;

    @Override
    public SysRole getRoleById(Integer roleId){
        return sysRoleMapper.selectByPrimaryKey(roleId);
    }

}
