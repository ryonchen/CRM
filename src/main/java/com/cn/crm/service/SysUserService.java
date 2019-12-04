package com.cn.crm.service;

import com.cn.crm.bean.SysUser;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-04 14:24
 */
public interface SysUserService {
    SysUser getUser(String userCode);

    int updateByPrimaryKeySelective(SysUser sysUser);
}
