package com.cn.crm.bean;

import lombok.Data;

import java.util.List;

/**
 * @program: crm
 * @description:
 * @author: gkt
 * @create: 2019-12-04 23:45
 */
@Data
public class UserInfo {
    private Integer userId;
    private String userCode;
    private String userName;
    private Integer roleId;
    private String roleName;
    private List<Auth> auths;

    @Data
    public static class Auth{
        private Integer authId;
        private Integer authParentId;
        private String authName;
        private String authUrl;
    }
}
