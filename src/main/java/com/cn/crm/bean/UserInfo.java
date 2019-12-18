package com.cn.crm.bean;

import lombok.Data;

import java.util.ArrayList;
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


        private List<Auth> auths;
    }


    public static void main(String[] args) {
        UserInfo u = new UserInfo();
        UserInfo.Auth a = new UserInfo.Auth();
        a.setAuthId(1);
        a.setAuthParentId(1);
        a.setAuthName("1");
        List<UserInfo.Auth> b = new ArrayList<UserInfo.Auth>();


        List<UserInfo.Auth> bb = new ArrayList<UserInfo.Auth>();
        UserInfo.Auth aa = new UserInfo.Auth();
        aa.setAuthId(11);
        aa.setAuthParentId(11);
        aa.setAuthName("11");
        bb.add(aa);
        a.setAuths(bb);

        b.add(a);
        u.setAuths(b);
        System.out.println("a");
    }
}
