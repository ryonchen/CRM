package com.cn.crm.service;

import com.cn.crm.bean.SysAuth;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-05 01:42
 */
public interface SysAuthService {
    SysAuth getAuth(Integer authId);

    List<SysAuth> getAuthList(List<Integer> authIds);

    List<SysAuth> getParentAuthListByRoleId(Integer roleId);

    List<SysAuth> getAuthListByAuthParentId(Integer authId);


}
