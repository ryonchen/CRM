package com.cn.crm.bean;

import java.util.Date;

public class cstActivityT {
    private Integer atv_id;

    private Date atv_date;

    private String atv_desc;

    private String atv_place;

    private String atv_title;

    private Integer cst_customer_t_cst_id;

    private String atv_detail;

    public Integer getAtv_id() {
        return atv_id;
    }

    public void setAtv_id(Integer atv_id) {
        this.atv_id = atv_id;
    }

    public Date getAtv_date() {
        return atv_date;
    }

    public void setAtv_date(Date atv_date) {
        this.atv_date = atv_date;
    }

    public String getAtv_desc() {
        return atv_desc;
    }

    public void setAtv_desc(String atv_desc) {
        this.atv_desc = atv_desc == null ? null : atv_desc.trim();
    }

    public String getAtv_place() {
        return atv_place;
    }

    public void setAtv_place(String atv_place) {
        this.atv_place = atv_place == null ? null : atv_place.trim();
    }

    public String getAtv_title() {
        return atv_title;
    }

    public void setAtv_title(String atv_title) {
        this.atv_title = atv_title == null ? null : atv_title.trim();
    }

    public Integer getCst_customer_t_cst_id() {
        return cst_customer_t_cst_id;
    }

    public void setCst_customer_t_cst_id(Integer cst_customer_t_cst_id) {
        this.cst_customer_t_cst_id = cst_customer_t_cst_id;
    }

    public String getAtv_detail() {
        return atv_detail;
    }

    public void setAtv_detail(String atv_detail) {
        this.atv_detail = atv_detail == null ? null : atv_detail.trim();
    }
}