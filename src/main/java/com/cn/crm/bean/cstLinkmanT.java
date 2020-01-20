package com.cn.crm.bean;

public class cstLinkmanT {
    private Integer link_id;

    private Integer link_cst_id;

    private String link_cst_name;

    private String link_memo;

    private String link_mobile;

    private String link_name;

    private String link_postion;

    private String link_sex;

    private String link_tel;

    private Integer cst_customer_t_cst_id;

    public Integer getLink_id() {
        return link_id;
    }

    public void setLink_id(Integer link_id) {
        this.link_id = link_id;
    }

    public Integer getLink_cst_id() {
        return link_cst_id;
    }

    public void setLink_cst_id(Integer link_cst_id) {
        this.link_cst_id = link_cst_id;
    }

    public String getLink_cst_name() {
        return link_cst_name;
    }

    public void setLink_cst_name(String link_cst_name) {
        this.link_cst_name = link_cst_name == null ? null : link_cst_name.trim();
    }

    public String getLink_memo() {
        return link_memo;
    }

    public void setLink_memo(String link_memo) {
        this.link_memo = link_memo == null ? null : link_memo.trim();
    }

    public String getLink_mobile() {
        return link_mobile;
    }

    public void setLink_mobile(String link_mobile) {
        this.link_mobile = link_mobile == null ? null : link_mobile.trim();
    }

    public String getLink_name() {
        return link_name;
    }

    public void setLink_name(String link_name) {
        this.link_name = link_name == null ? null : link_name.trim();
    }

    public String getLink_postion() {
        return link_postion;
    }

    public void setLink_postion(String link_postion) {
        this.link_postion = link_postion == null ? null : link_postion.trim();
    }

    public String getLink_sex() {
        return link_sex;
    }

    public void setLink_sex(String link_sex) {
        this.link_sex = link_sex == null ? null : link_sex.trim();
    }

    public String getLink_tel() {
        return link_tel;
    }

    public void setLink_tel(String link_tel) {
        this.link_tel = link_tel == null ? null : link_tel.trim();
    }

    public Integer getCst_customer_t_cst_id() {
        return cst_customer_t_cst_id;
    }

    public void setCst_customer_t_cst_id(Integer cst_customer_t_cst_id) {
        this.cst_customer_t_cst_id = cst_customer_t_cst_id;
    }
}