package com.cn.crm.service;

import com.cn.crm.bean.SysRoleAuth;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-04 23:36
 */
public interface SysRoleAuthService {
    List<SysRoleAuth> getAuthListByRoleId(Integer roleId);
}
