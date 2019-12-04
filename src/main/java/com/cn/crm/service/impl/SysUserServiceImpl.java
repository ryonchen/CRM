package com.cn.crm.service.impl;

import com.cn.crm.bean.SysUser;
import com.cn.crm.dao.SysUserMapper;
import com.cn.crm.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-04 14:20
 */
@Service("sysUserService")
public class SysUserServiceImpl implements SysUserService {

    @Autowired(required = false)
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser getUser(String userCode){
        return sysUserMapper.selectByUserCode(userCode);
    }

    @Override
    public int updateByPrimaryKeySelective(SysUser sysUser){
        return sysUserMapper.updateByPrimaryKeySelective(sysUser);
    }

}
