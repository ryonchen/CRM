package com.cn.crm.bean;

import java.util.Date;

public class SysUserT {
    private Integer user_id;

    private String user_flag;

    private String user_name;

    private String user_password;

    private Integer sys_role_t_role_id;

    private String user_code;

    private Byte is_deleted;

    private Date create_time;

    private Date update_time;

    private Date last_login_time;

    private Byte is_locked;

    private Byte fail_login_time;

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_flag() {
        return user_flag;
    }

    public void setUser_flag(String user_flag) {
        this.user_flag = user_flag == null ? null : user_flag.trim();
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name == null ? null : user_name.trim();
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password == null ? null : user_password.trim();
    }

    public Integer getSys_role_t_role_id() {
        return sys_role_t_role_id;
    }

    public void setSys_role_t_role_id(Integer sys_role_t_role_id) {
        this.sys_role_t_role_id = sys_role_t_role_id;
    }

    public String getUser_code() {
        return user_code;
    }

    public void setUser_code(String user_code) {
        this.user_code = user_code == null ? null : user_code.trim();
    }

    public Byte getIs_deleted() {
        return is_deleted;
    }

    public void setIs_deleted(Byte is_deleted) {
        this.is_deleted = is_deleted;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    public Date getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Date update_time) {
        this.update_time = update_time;
    }

    public Date getLast_login_time() {
        return last_login_time;
    }

    public void setLast_login_time(Date last_login_time) {
        this.last_login_time = last_login_time;
    }

    public Byte getIs_locked() {
        return is_locked;
    }

    public void setIs_locked(Byte is_locked) {
        this.is_locked = is_locked;
    }

    public Byte getFail_login_time() {
        return fail_login_time;
    }

    public void setFail_login_time(Byte fail_login_time) {
        this.fail_login_time = fail_login_time;
    }
}