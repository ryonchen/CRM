package com.cn.crm.vo;

import com.cn.crm.bean.SysUser;

public class CustomerReqVo extends RequstVo{
    private Integer userId;

    public String getCstName() {
        return cstName;
    }

    public void setCstName(String cstName) {
        this.cstName = cstName;
    }

    private String cstName;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }


}
