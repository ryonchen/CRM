package com.cn.crm.bean;

import java.util.Date;

public class SysUser {
    private Integer userId;

    private String userCode;

    private String userName;

    private String userPassword;

    private Integer userRoleId;

    private Byte isDeleted;

    private Date createTime;

    private Date updateTime;

    private Date lastLoginTime;

    private Byte isLocked;

    private Integer failLoginTimes;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public Integer getUserRoleId() {
        return userRoleId;
    }

    public void setUserRoleId(Integer userRoleId) {
        this.userRoleId = userRoleId;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public Byte getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Byte isLocked) {
        this.isLocked = isLocked;
    }

    public Integer getFailLoginTimes() {
        return failLoginTimes;
    }

    public void setFailLoginTimes(Integer failLoginTimes) {
        this.failLoginTimes = userRoleId;
    }
}