package com.cn.crm.bean;

public class SysRoleAuth {
    private Integer raId;

    private Integer roleId;

    private Integer authId;

    private Byte isDeleted;

    public Integer getRaId() {
        return raId;
    }

    public void setRaId(Integer raId) {
        this.raId = raId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getAuthId() {
        return authId;
    }

    public void setAuthId(Integer authId) {
        this.authId = authId;
    }

    public Byte getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }
}