package com.cn.crm.bean;

import lombok.Data;

/**
 * @program: crm
 * @description: LoginForm实体
 * @author: gkt
 * @create: 2019-12-04 11:33
 */
@Data
public class LoginForm {
        private String userName;
        private String password;
        private String verifiCode;
}
