package com.cn.crm.bean;

public class SysRightT {
    private Integer right_id;

    private String right_text;

    private String right_tip;

    private String right_type;

    private String rigth_url;

    private Integer sys_right_t_right_id;

    public Integer getRight_id() {
        return right_id;
    }

    public void setRight_id(Integer right_id) {
        this.right_id = right_id;
    }

    public String getRight_text() {
        return right_text;
    }

    public void setRight_text(String right_text) {
        this.right_text = right_text == null ? null : right_text.trim();
    }

    public String getRight_tip() {
        return right_tip;
    }

    public void setRight_tip(String right_tip) {
        this.right_tip = right_tip == null ? null : right_tip.trim();
    }

    public String getRight_type() {
        return right_type;
    }

    public void setRight_type(String right_type) {
        this.right_type = right_type == null ? null : right_type.trim();
    }

    public String getRigth_url() {
        return rigth_url;
    }

    public void setRigth_url(String rigth_url) {
        this.rigth_url = rigth_url == null ? null : rigth_url.trim();
    }

    public Integer getSys_right_t_right_id() {
        return sys_right_t_right_id;
    }

    public void setSys_right_t_right_id(Integer sys_right_t_right_id) {
        this.sys_right_t_right_id = sys_right_t_right_id;
    }
}