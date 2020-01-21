package com.cn.crm.bean;

public class SysRoleT {
    private Integer role_id;

    private String role_desc;

    private String role_flag;

    private String role_name;

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public String getRole_desc() {
        return role_desc;
    }

    public void setRole_desc(String role_desc) {
        this.role_desc = role_desc == null ? null : role_desc.trim();
    }

    public String getRole_flag() {
        return role_flag;
    }

    public void setRole_flag(String role_flag) {
        this.role_flag = role_flag == null ? null : role_flag.trim();
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name == null ? null : role_name.trim();
    }
}